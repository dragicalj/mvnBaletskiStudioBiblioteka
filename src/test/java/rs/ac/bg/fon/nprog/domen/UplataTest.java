package rs.ac.bg.fon.nprog.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class UplataTest {
	
	Uplata uplata;
	
	@Mock
	private ResultSet rs;
	
	@BeforeEach
	void setUp() throws Exception {
		uplata=new Uplata();
	}

	@AfterEach
	void tearDown() throws Exception {
		uplata=null;
	}

	@Test
	void testUplata() {
		uplata=new Uplata();
		
		assertNotNull(uplata);
	}

	@Test
	void testUplataBaletskiIgracIntBigDecimalDateStringString() {
		BaletskiIgrac baletskiIgrac=new BaletskiIgrac();
		baletskiIgrac.setBaletskiIgracId(1l);
		
		uplata=new Uplata(baletskiIgrac, 1, new BigDecimal(2000), new java.util.Date(), "Januar", "2022");
	
		assertNotNull(uplata);
		assertEquals(baletskiIgrac, uplata.getBaletskiIgrac());
		assertEquals(1, uplata.getRedniBrojUplate());
		assertEquals(new BigDecimal(2000), uplata.getIznosUplate());
		assertEquals("Januar", uplata.getMesec());
		assertEquals("2022", uplata.getGodina());

	}

	@Test
	void testSetRedniBrojUplate() {
		uplata.setRedniBrojUplate(1);
		
		assertEquals(1, uplata.getRedniBrojUplate());
	}
	
	@Test
	void testSetRedniBrojUplateManjiOdJedan() {
		assertThrows(java.lang.RuntimeException.class, () -> uplata.setRedniBrojUplate(0));
	}
	@Test
	void testSetIznosUplate() {
		uplata.setIznosUplate(new BigDecimal(2000));
		
		assertEquals(new BigDecimal(2000), uplata.getIznosUplate());
	}
	
	@Test
	void testSetIznosUplateManjiOdNule() {
		assertThrows(java.lang.RuntimeException.class, () -> uplata.setIznosUplate(new BigDecimal(-2600)));
	}

	@Test
	void testSetMesec() {
		uplata.setMesec("Februar");
		
		assertEquals("Februar", uplata.getMesec());
	}
	
	@Test
	void testSetMesecNull(){
		assertThrows(java.lang.NullPointerException.class, () -> uplata.setMesec(null));
	}
	
	@Test
	void testSetGodina() {
		uplata.setGodina("2022");
		
		assertEquals("2022", uplata.getGodina());
	}
	
	@Test
	void testSetGodinaNull(){
		assertThrows(java.lang.NullPointerException.class, () -> uplata.setGodina(null));
	}
	

	@Test
	void testToString() {
		uplata.setDatumUplate(new java.util.Date());
		uplata.setGodina("2022");
		uplata.setMesec("Januar");
		uplata.setIznosUplate(new BigDecimal(2000));
		uplata.setRedniBrojUplate(1);
		BaletskiIgrac baletskiIgrac=new BaletskiIgrac();
		baletskiIgrac.setBaletskiIgracId(1l);
		uplata.setBaletskiIgrac(baletskiIgrac);
		
		String rezultat=uplata.toString();

		assertEquals("Uplata{redniBrojUplate=1, iznosUplate=2000, mesec=Januar, godina=2022}", rezultat);
	}

	@ParameterizedTest
	@CsvSource(
			{
				"1, 3, 1, 3, true",
				"1, 1, 2, 2, false",
			}
	)
	void testEqualsObject(Long baletskiIgracId1, int redniBrojUplate1,Long baletskiIgracId2, int redniBrojUplate2, boolean rez) {
		BaletskiIgrac baletskiIgrac1=new BaletskiIgrac();
		baletskiIgrac1.setBaletskiIgracId(baletskiIgracId1);
		uplata.setBaletskiIgrac(baletskiIgrac1);
		uplata.setRedniBrojUplate(redniBrojUplate1);
		
		Uplata uplata2=new Uplata();
		BaletskiIgrac baletskiIgrac2=new BaletskiIgrac();
		baletskiIgrac2.setBaletskiIgracId(baletskiIgracId2);
		uplata2.setRedniBrojUplate(redniBrojUplate2);
		uplata2.setBaletskiIgrac(baletskiIgrac2);
		
		assertEquals(rez, uplata.equals(uplata2));
	}

	@Test
	void testVratiVrednostiZaInsert() {
		BaletskiIgrac baletskiIgrac=new BaletskiIgrac();
		baletskiIgrac.setBaletskiIgracId(1l);
		uplata.setBaletskiIgrac(baletskiIgrac);
		uplata.setRedniBrojUplate(1);
		uplata.setIznosUplate(new BigDecimal(2000));		
		uplata.setDatumUplate(new Date(122, 5, 4));
		uplata.setMesec("Mart");
		uplata.setGodina("2022");
		
		String rezultat=uplata.vratiVrednostiZaInsert();
		
		assertEquals("1,1, 2000, '2022-06-04', 'Mart', '2022'", rezultat);

	}

	@Test
	void testVratiUslovZaSelect() {
		BaletskiIgrac baletskiIgrac=new BaletskiIgrac();
		baletskiIgrac.setBaletskiIgracId(1l);
		uplata.setBaletskiIgrac(baletskiIgrac);
		uplata.setRedniBrojUplate(2);
		
		String rezultat=uplata.vratiUslovZaSelect();
		
		assertEquals("BaletskiIgracId = 1 AND RedniBrojUplate = 2", rezultat);
	}

	@Test
	void testVratiListu() throws Exception {
		AutoCloseable ac = MockitoAnnotations.openMocks(this);

		kreirajUplataResultSet();
				
		Uplata u1=new Uplata();
		List<ApstraktniDomenskiObjekat> lista1=u1.vratiListu(rs);

		Uplata u2=new Uplata();
		BaletskiIgrac baletskiIgrac=new BaletskiIgrac();
		baletskiIgrac.setBaletskiIgracId(1l);
		u2.setBaletskiIgrac(baletskiIgrac);
		u2.setRedniBrojUplate(1);
		u2.setIznosUplate(new BigDecimal(2000));		
		u2.setDatumUplate(new java.sql.Date(122, 5, 4));
		u2.setMesec("Mart");
		u2.setGodina("2022");
		
		List<ApstraktniDomenskiObjekat> lista2=new ArrayList<>();
		lista2.add(u2);
		
		assertEquals(lista1, lista2);
		ac.close();
	}

	private void kreirajUplataResultSet() throws SQLException {
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getLong("BaletskiIgracId")).thenReturn(1l);
        Mockito.when(rs.getInt("RedniBrojUplate")).thenReturn(1);
        Mockito.when(rs.getBigDecimal("IznosUplate")).thenReturn(new BigDecimal(2000));
		Mockito.when(rs.getDate("DatumUplate")).thenReturn(new java.sql.Date(122, 5, 4));
		Mockito.when(rs.getString("Mesec")).thenReturn("Mart");
		Mockito.when(rs.getString("Godina")).thenReturn("2022");
	}

}
