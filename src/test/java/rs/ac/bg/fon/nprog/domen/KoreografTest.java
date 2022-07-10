package rs.ac.bg.fon.nprog.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
class KoreografTest {
	
	Koreograf k;
	
	@Mock
	private ResultSet rs;

	@BeforeEach
	void setUp() throws Exception {
		k=new Koreograf();
	}

	@AfterEach
	void tearDown() throws Exception {
		k=null;
	}

	@Test
	void testKoreograf() {
		k=new Koreograf();
		
		assertNotNull(k);
		
	}

	@SuppressWarnings("deprecation")
	@Test
	void testKoreografLongStringStringDateStringStringString() {
		k=new Koreograf(1l, "Nevena", "Jovic",new Date(1, 02, 05), "nevenaj@gmail.com", "+38162222320", "Klasican balet");

		assertNotNull(k);
		assertEquals(1l, k.getKoreografId());
		assertEquals("Nevena", k.getIme());
		assertEquals("Jovic", k.getPrezime());
		assertEquals(new Date(1, 2, 5), k.getDatumRodjenja());
		assertEquals("nevenaj@gmail.com", k.getEmail());
		assertEquals("+38162222320", k.getBrojTelefona());
		assertEquals("Klasican balet", k.getSpecijalizovanost());


	}

	@Test
	void testSetSpecijalizovanost() {
		
	}

	@Test
	void testSetIme() {
		k.setIme("Nevena");
		
		assertEquals("Nevena", k.getIme());
	}
	
	@Test
	void testSetImeNull(){
		assertThrows(java.lang.NullPointerException.class, () -> k.setIme(null));
	}
	
	@Test
	void testSetImeKratakString() {
		assertThrows(java.lang.RuntimeException.class, () -> k.setIme("N"));
	}

	@Test
	void testSetPrezime() {
		k.setPrezime("Ljubisavljevic");
		
		assertEquals("Ljubisavljevic", k.getPrezime());	
	}
	
	@Test
	void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class, () -> k.setPrezime(null));
	}
	
	@Test
	void testSetPrezimeKratakString() {
		assertThrows(java.lang.RuntimeException.class, () -> k.setPrezime("L"));
	}

	@Test
	void testSetDatumRodjenja() {
		k.setDatumRodjenja(new Date(1, 5, 4));
		
		assertEquals(new Date(1, 5, 4), k.getDatumRodjenja());		
	}
	
	@Test
	void testSetDatumRodjenjaPosleDanasnjeg() {
		assertThrows(java.lang.RuntimeException.class, () -> k.setDatumRodjenja(new Date(2225, 1, 4)));		
	}

	@Test
	void testSetEmail() {
		k.setEmail("nevenaa@gmail.com");
		
		assertEquals("nevenaa@gmail.com", k.getEmail());		
	}
	
	@Test
	void testSetBrojTelefona() {
		k.setBrojTelefona("+381658222320");
		
		assertEquals("+381658222320", k.getBrojTelefona());
	}
	
	@Test
	void testSetBrojTelefonaFormat() {
		assertThrows(java.lang.RuntimeException.class, () -> k.setBrojTelefona("1255"));
	}
	@Test
	void testSetEmailFormat() {
		assertThrows(java.lang.RuntimeException.class, () -> k.setEmail("nevena.com"));				
	}

	@Test
	void testToString() {
		k.setIme("Nevena");
		k.setPrezime("Ljubisavljevic");
		
		String rezultat=k.toString();
		
		assertTrue(rezultat.contains("Nevena"));
		assertTrue(rezultat.contains("Ljubisavljevic"));	}

	@ParameterizedTest
	@CsvSource(
			{
				"1, 1, true",
				"1, 11, false",
			}
	)
	void testEqualsObject(Long koreografId1, Long koreografId2, boolean rez) {
		k.setKoreografId(koreografId1);
		
		Koreograf k2=new Koreograf();
		k2.setKoreografId(koreografId2);
		
		assertEquals(rez, k.equals(k2));
	}

	@Test
	void testVratiVrednostiZaInsert() {
		k.setIme("Nevena");
		k.setPrezime("Ljubisavljevic");
		k.setDatumRodjenja(new Date(1, 5, 4));
		k.setBrojTelefona("+381652222320");
		k.setEmail("nevena@gmail.com");
		k.setSpecijalizovanost("Klasican balet");
		
		String rezultat=k.vratiVrednostiZaInsert();
		
		assertEquals("'Nevena', 'Ljubisavljevic', '1901-06-04', 'nevena@gmail.com', '+381652222320', 'Klasican balet'", rezultat);
	}

	@Test
	void testVratiUslovZaSelect() {
		k.setKoreografId(1l);
		
		String rezultat=k.vratiUslovZaSelect();
		
		assertEquals("KoreografId = 1", rezultat);
	}

	@Test
	void testVratiListu() throws Exception {
		AutoCloseable ac = MockitoAnnotations.openMocks(this);

		kreirajKoreografResultSet();
				
		Koreograf k1=new Koreograf();
		List<ApstraktniDomenskiObjekat> lista1=k1.vratiListu(rs);

		Koreograf k2=new Koreograf();
		k2.setKoreografId(1l);
		k2.setIme("Nevena");
		k2.setPrezime("Jovic");
		k2.setEmail("nevenaa@gmail.com");
		k2.setDatumRodjenja(new java.sql.Date(1, 5, 6));
		k2.setBrojTelefona("+381658222320");
		k2.setSpecijalizovanost("Klasican balet");
		
		List<ApstraktniDomenskiObjekat> lista2=new ArrayList<>();
		lista2.add(k2);
		
		assertEquals(lista1, lista2);
		ac.close();
	}

	
	private void kreirajKoreografResultSet() throws SQLException {
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getLong("KoreografId")).thenReturn(1l);
		Mockito.when(rs.getString("Ime")).thenReturn("Nevena");
		Mockito.when(rs.getString("Prezime")).thenReturn("Jovic");
		Mockito.when(rs.getString("Email")).thenReturn("nevenaa@gmail.com");
		Mockito.when(rs.getDate("DatumRodjenja")).thenReturn(new java.sql.Date(1, 5, 6));
		Mockito.when(rs.getString("BrojTelefona")).thenReturn("+381658222320");
		Mockito.when(rs.getString("Specijalizovanost")).thenReturn("Klasican balet");
	}

	@Test
	void testVratiUslovZaPretragu() {
		k.setIme("Nevena");
		k.setPrezime("Jovic");
		k.setSpecijalizovanost("Klasican balet");
		
		String upit=k.vratiUslovZaPretragu();
		
		assertEquals("ime LIKE 'Nevena' AND prezime LIKE 'Jovic' AND specijalizovanost LIKE 'Klasican balet'", upit);

	}
	


}
