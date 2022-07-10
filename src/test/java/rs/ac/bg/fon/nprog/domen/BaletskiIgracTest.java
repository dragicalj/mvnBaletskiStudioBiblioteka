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
class BaletskiIgracTest {
	
	BaletskiIgrac baletskiIgrac;
	
	@Mock
	private ResultSet rs;

	@BeforeEach
	void setUp() throws Exception {
		baletskiIgrac=new BaletskiIgrac();
	}

	@AfterEach
	void tearDown() throws Exception {
		baletskiIgrac=null;
	}

	@Test
	void testBaletskiIgrac() {
		baletskiIgrac=new BaletskiIgrac();
		
		assertNotNull(baletskiIgrac);
	}	

	@Test
	void testBaletskiIgracLongStringStringDateStringStringStringDateBigDecimalBaletskaGrupaListOfUplata() {
		Uplata u1=new Uplata(baletskiIgrac,1,new BigDecimal(2000),new java.util.Date(),"Januar","2022");
		Uplata u2=new Uplata(baletskiIgrac,1,new BigDecimal(2000),new java.util.Date(),"Februar","2022");
		ArrayList<Uplata> listaUplata1=new ArrayList<>();
		listaUplata1.add(u1);
		listaUplata1.add(u2);
		
		baletskiIgrac=new BaletskiIgrac(1l, "Lena", "Jokic", new Date(15, 3, 2), "lenajokic@gmail.com", "0623222255", "0658026028", new  java.util.Date(), new BigDecimal(2000), new BaletskaGrupa(1l, "Miks", TipGrupe.Junior, new Date(21, 1, 9), 20, new Koreograf(), null), listaUplata1);
		ArrayList<Uplata> listaUplata2=new ArrayList<>();
		listaUplata2.add(u1);
		listaUplata2.add(u2);
		BaletskaGrupa baletskaGrupa2=new BaletskaGrupa(1l, "Miks", TipGrupe.Junior, new Date(21, 1, 9), 20, new Koreograf(), null);
		
		assertNotNull(baletskiIgrac);
		assertEquals(1l, baletskiIgrac.getBaletskiIgracId());
		assertEquals("Lena", baletskiIgrac.getIme());
		assertEquals("Jokic", baletskiIgrac.getPrezime());
		assertEquals(new Date(15, 3, 2), baletskiIgrac.getDatumRodjenja());
		assertEquals("lenajokic@gmail.com", baletskiIgrac.getEmail());
		assertEquals("0623222255", baletskiIgrac.getBrojTelefona());
		assertEquals("0658026028", baletskiIgrac.getBrojTelefonaRoditelja());
		assertEquals(baletskaGrupa2, baletskiIgrac.getBaletskaGrupa());
		assertEquals(listaUplata2, baletskiIgrac.getListaUplata());

	}

	@Test
	void testSetIme() {
		baletskiIgrac.setIme("Lena");
		
		assertEquals("Lena", baletskiIgrac.getIme());
	}
	
	@Test
	void testSetImeNull(){
		assertThrows(java.lang.NullPointerException.class, () -> baletskiIgrac.setIme(null));
	}
	
	@Test
	void testSetImeKratakString() {
		assertThrows(java.lang.RuntimeException.class, () -> baletskiIgrac.setIme("L"));
	}
	
	@Test
	void testSetPrezime() {
		baletskiIgrac.setPrezime("Jokic");
		
		assertEquals("Jokic", baletskiIgrac.getPrezime());	
	}
	
	@Test
	void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class, () -> baletskiIgrac.setPrezime(null));
	}
	
	@Test
	void testSetPrezimeKratakString() {
		assertThrows(java.lang.RuntimeException.class, () -> baletskiIgrac.setPrezime("L"));
	}
	
	@Test
	void testSetDatumRodjenja() {
		baletskiIgrac.setDatumRodjenja(new Date(1, 5, 4));
		
		assertEquals(new Date(1, 5, 4), baletskiIgrac.getDatumRodjenja());	
	}
	
	@Test
	void testSetDatumRodjenjaPosleDanasnjeg() {
		assertThrows(java.lang.RuntimeException.class, () -> baletskiIgrac.setDatumRodjenja(new Date(2225, 1, 4)));		
	}

	@Test
	void testSetEmail() {
		baletskiIgrac.setEmail("lena123@gmail.com");
		
		assertEquals("lena123@gmail.com", baletskiIgrac.getEmail());	
	}
	
	@Test
	void testSetBrojTelefona() {
		baletskiIgrac.setBrojTelefona("+381658222320");
		
		assertEquals("+381658222320", baletskiIgrac.getBrojTelefona());
	}
	
	@Test
	void testSetBrojTelefonaFormat() {
		assertThrows(java.lang.RuntimeException.class, () -> baletskiIgrac.setBrojTelefona("1255"));
	}
	
	@Test
	void testSetBrojTelefonaRoditelja() {
		baletskiIgrac.setBrojTelefona("+381658026028");
		
		assertEquals("+381658026028", baletskiIgrac.getBrojTelefona());
	}
	
	@Test
	void testSetBrojTelefonaRoditeljaFormat() {
		assertThrows(java.lang.RuntimeException.class, () -> baletskiIgrac.setBrojTelefonaRoditelja("2222"));
	}
	

	@Test
	void testSetTrenutnaClanarina() {
		baletskiIgrac.setTrenutnaClanarina(new BigDecimal(2000));
		
		assertEquals(new BigDecimal(2000), baletskiIgrac.getTrenutnaClanarina());
	}
	
	@Test
	void testSetTrenutnaClanarinaManjaOdNule() {
		assertThrows(java.lang.RuntimeException.class, () -> baletskiIgrac.setTrenutnaClanarina(new BigDecimal(-1000)));
	}

	@Test
	void testSetListaUplata() {
		Uplata u1=new Uplata(baletskiIgrac, 1, new BigDecimal(2000), new java.util.Date(), "Jul", "2022");
		ArrayList<Uplata> lista=new ArrayList<>();
		lista.add(u1);
		
		baletskiIgrac.setListaUplata(lista);
		assertEquals(lista, baletskiIgrac.getListaUplata());

	}
	
	@Test
	void testSetListaUplataPrazna() {
		assertThrows(java.lang.RuntimeException.class, () -> baletskiIgrac.setListaUplata(new ArrayList<>()));
	}

	

	@ParameterizedTest
	@CsvSource(
			{
				"1, 1, true",
				"1, 11, false",
			}
	)
	void testEqualsObject(Long baletskiIgracId1, Long baletskiIgracId2, boolean rez) {
		baletskiIgrac.setBaletskiIgracId(baletskiIgracId1);
		
		BaletskiIgrac baletskiIgrac2=new  BaletskiIgrac();
		baletskiIgrac2.setBaletskiIgracId(baletskiIgracId2);
		
		assertEquals(rez, baletskiIgrac.equals(baletskiIgrac2));
	}

	@Test
	void testVratiVrednostiZaInsert() {
		baletskiIgrac.setIme("Lena");
		baletskiIgrac.setPrezime("Jokic");
		baletskiIgrac.setDatumRodjenja(new Date(1, 5, 4));
		baletskiIgrac.setBrojTelefona("+381658222320");
		baletskiIgrac.setBrojTelefonaRoditelja("+381658026028");
		baletskiIgrac.setEmail("lena@gmail.com");
		baletskiIgrac.setTrenutnaClanarina(new BigDecimal(2000));
		baletskiIgrac.setDatumUpisa(new Date(32, 5, 4));
		
		BaletskaGrupa baletskaGrupa=new BaletskaGrupa();
		baletskaGrupa.setBaletskaGrupaId(1l);
		baletskiIgrac.setBaletskaGrupa(baletskaGrupa);
		
		String rezultat=baletskiIgrac.vratiVrednostiZaInsert();
		
		assertEquals("'Lena', 'Jokic', '1901-06-04', 'lena@gmail.com', '+381658222320', '+381658026028', '1901-06-04', 2000, 1", rezultat);


	}

	@Test
	void testVratiUslovZaSelect() {
		baletskiIgrac.setBaletskiIgracId(1l);
		
		String rezultat=baletskiIgrac.vratiUslovZaSelect();
		
		assertEquals("BaletskiIgracId = 1", rezultat);
		
	}

	
	
	
	@Test
	void testVratiUslovZaPretragu() {
		baletskiIgrac.setIme("Lena");
		baletskiIgrac.setPrezime("Jokic");
		
		String rezultat=baletskiIgrac.vratiUslovZaPretragu();
		
		assertEquals("ime LIKE 'Lena' AND prezime LIKE 'Jokic' ", rezultat);
	}

	@Test
	void testVratiListu() throws Exception {
		AutoCloseable ac = MockitoAnnotations.openMocks(this);

		kreirajBaletskiIgracResultSet();
				
		BaletskiIgrac baletskiIgrac1=new BaletskiIgrac();
		List<ApstraktniDomenskiObjekat> lista1=baletskiIgrac1.vratiListu(rs);

		BaletskiIgrac baletskiIgrac2=new BaletskiIgrac();
		baletskiIgrac2.setBaletskiIgracId(1l);
		baletskiIgrac2.setIme("Milica");
		baletskiIgrac2.setPrezime("Zivkovic");		
		baletskiIgrac2.setDatumRodjenja(new java.sql.Date(1, 5, 6));
		baletskiIgrac2.setEmail("milicaz@gmail.com");
		baletskiIgrac2.setBrojTelefona("+381658222320");
		baletskiIgrac2.setBrojTelefonaRoditelja("+381658026028");
		baletskiIgrac2.setDatumUpisa(new java.sql.Date(31, 5, 6));
		baletskiIgrac2.setTrenutnaClanarina(new BigDecimal(2000));
		BaletskaGrupa baletskaGrupa=new BaletskaGrupa();
		baletskaGrupa.setBaletskaGrupaId(1l);
		baletskiIgrac2.setBaletskaGrupa(baletskaGrupa);
		
		List<ApstraktniDomenskiObjekat> lista2=new ArrayList<>();
		lista2.add(baletskiIgrac2);
		
		assertEquals(lista1, lista2);
		ac.close();
	}

	private void kreirajBaletskiIgracResultSet() throws SQLException {
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getLong("BaletskiIgracId")).thenReturn(1l);
		Mockito.when(rs.getString("Ime")).thenReturn("Milica");
		Mockito.when(rs.getString("Prezime")).thenReturn("Zivkovic");
		Mockito.when(rs.getString("Email")).thenReturn("milicaz@gmail.com");
		Mockito.when(rs.getDate("DatumRodjenja")).thenReturn(new java.sql.Date(1, 5, 6));
		Mockito.when(rs.getDate("DatumUpisa")).thenReturn(new java.sql.Date(31, 5, 6));
		Mockito.when(rs.getString("BrojTelefona")).thenReturn("+381658222320");
		Mockito.when(rs.getString("BrojTelefonaRoditelja")).thenReturn("+381658026028");
		Mockito.when(rs.getBigDecimal("TrenutnaClanarina")).thenReturn(new BigDecimal(2000));
		Mockito.when(rs.getLong("BaletskaGrupaId")).thenReturn(1l);
	}

}
