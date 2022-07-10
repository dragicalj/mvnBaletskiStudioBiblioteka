package rs.ac.bg.fon.nprog.domen;

import static org.junit.jupiter.api.Assertions.*;

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
class BaletskaGrupaTest {
	
	BaletskaGrupa baletskaGrupa;
	
	@Mock
	private ResultSet rs;

	@BeforeEach
	void setUp() throws Exception {
		baletskaGrupa=new BaletskaGrupa();
	}

	@AfterEach
	void tearDown() throws Exception {
		baletskaGrupa=null;
	}

	@Test
	void testBaletskaGrupa() {
		baletskaGrupa=new BaletskaGrupa();
		
		assertNotNull(baletskaGrupa);
	}

	@Test
	void testBaletskaGrupaLongStringTipGrupeDateIntKoreografListOfBaletskaGrupaNastup() {
		Koreograf k=new Koreograf();
		k.setKoreografId(1l);
		ArrayList<BaletskaGrupaNastup> lista=new ArrayList<>();
		Nastup n1=new Nastup();
		n1.setNastupId(1l);
		Nastup n2=new Nastup();
		n2.setNastupId(2l);
		BaletskaGrupaNastup grupaNastup1=new BaletskaGrupaNastup(baletskaGrupa, n1);
		BaletskaGrupaNastup grupaNastup2=new BaletskaGrupaNastup(baletskaGrupa, n2);
		lista.add(grupaNastup1);
		lista.add(grupaNastup2);
		
		baletskaGrupa=new BaletskaGrupa(1l, "Kolibri", TipGrupe.Mini, new Date(30, 1, 9), 12, k, lista);
		
		assertNotNull(k);
		assertEquals(1l, baletskaGrupa.getBaletskaGrupaId());
		assertEquals("Kolibri", baletskaGrupa.getNazivGrupe());
		assertEquals(TipGrupe.Mini, baletskaGrupa.getTipGrupe());
		assertEquals(new Date(30, 1, 9), baletskaGrupa.getDatumNastanka());
		assertEquals(k, baletskaGrupa.getKoreograf());
		assertEquals(lista, baletskaGrupa.getListaNastupa());

	}

	@Test
	void testToString() {
		baletskaGrupa.setNazivGrupe("Miks");
		
		String rezultat=baletskaGrupa.toString();
		
		assertEquals("Miks", rezultat);

	}

	@ParameterizedTest
	@CsvSource(
			{
				"2, 1, false",
				"5, 5, true",
			}
	)
	void testEqualsObject(Long baletskaGrupaId1, Long baletskaGrupaId2, boolean rez) {
		baletskaGrupa.setBaletskaGrupaId(baletskaGrupaId1);
		
		BaletskaGrupa baletskaGrupa2=new BaletskaGrupa();
		baletskaGrupa2.setBaletskaGrupaId(baletskaGrupaId2);
		
		assertEquals(rez, baletskaGrupa.equals(baletskaGrupa2));
	}


	@Test
	void testVratiVrednostiZaInsert() {
		baletskaGrupa.setNazivGrupe("Miks");
		baletskaGrupa.setTipGrupe(TipGrupe.Junior);
		baletskaGrupa.setDatumNastanka(new Date(1, 5, 4));
		baletskaGrupa.setKapacitet(20);
		Koreograf k=new Koreograf();
		k.setKoreografId(2l);
		baletskaGrupa.setKoreograf(k);
		
		String rezultat=baletskaGrupa.vratiVrednostiZaInsert();
		
		assertEquals("'Miks', 'Junior', '2022-07-10', 20,2", rezultat);

	}

	@Test
	void testVratiUslovZaSelect() {
		baletskaGrupa.setBaletskaGrupaId(1l);
		
		String rezultat=baletskaGrupa.vratiUslovZaSelect();
		
		assertEquals("BaletskaGrupaId = 1", rezultat);
	}

	

	@Test
	void testVratiListu() throws Exception {
		AutoCloseable ac = MockitoAnnotations.openMocks(this);

		kreirajBaletskaGrupaResultSet();
				
		BaletskaGrupa baletskaGrupa1=new BaletskaGrupa();
		List<ApstraktniDomenskiObjekat> lista1=baletskaGrupa1.vratiListu(rs);

		BaletskaGrupa baletskaGrupa2=new BaletskaGrupa();
		baletskaGrupa2.setBaletskaGrupaId(1l);
		baletskaGrupa2.setNazivGrupe("Kolibri");
		baletskaGrupa2.setTipGrupe(TipGrupe.Mini);
		baletskaGrupa2.setDatumNastanka(new java.sql.Date(1, 5, 4));
		baletskaGrupa2.setKapacitet(20);
		Koreograf k=new Koreograf();
		k.setKoreografId(3l);
		baletskaGrupa2.setKoreograf(k);
		
		List<ApstraktniDomenskiObjekat> lista2=new ArrayList<>();
		lista2.add(baletskaGrupa2);
		
		assertEquals(lista1, lista2);
		ac.close();
	}

	private void kreirajBaletskaGrupaResultSet() throws SQLException {
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getLong("BaletskaGrupaId")).thenReturn(1l);
		Mockito.when(rs.getString("NazivGrupe")).thenReturn("Kolibri");
		Mockito.when(rs.getString("TipGrupe")).thenReturn(TipGrupe.Mini.toString());
		Mockito.when(rs.getDate("DatumNastanka")).thenReturn(new java.sql.Date(1, 5, 4));
		Mockito.when(rs.getInt("Kapacitet")).thenReturn(20);
		Mockito.when(rs.getInt("KoreografId")).thenReturn(3);
	}

	@Test
	void testSetNazivGrupe() {
		baletskaGrupa.setNazivGrupe("Miks");
		
		assertEquals("Miks", baletskaGrupa.getNazivGrupe());
	}
	
	@Test
	void testSetNazivGrupeNull(){
		assertThrows(java.lang.NullPointerException.class, () -> baletskaGrupa.setNazivGrupe(null));
	}

	@Test
	void testSetKapacitet() {
		baletskaGrupa.setKapacitet(20);
		
		assertEquals(20, baletskaGrupa.getKapacitet());
	}
	
	@Test
	void testSetKapacitetOpseg() {
		assertThrows(java.lang.RuntimeException.class, () -> baletskaGrupa.setKapacitet(100));		
	}

}
