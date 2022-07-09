package rs.ac.bg.fon.nprog.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@RunWith(MockitoJUnitRunner.class)
class AdministratorTest {
	
	Administrator a;
	
	@Mock
	private ResultSet rs;

	@BeforeEach
	void setUp() throws Exception {
		a=new Administrator();
	}

	@AfterEach
	void tearDown() throws Exception {
		a=null;
	}

	@Test
	void testAdministrator() {
		a=new Administrator();
		
		assertNotNull(a);
	}

	@Test
	void testAdministratorLongStringStringStringString() {
		a=new Administrator(1l, "Dragica", "Ljubisavljevic", "gaga", "gaga123");
		
		assertNotNull(a);
		assertEquals(1l, a.getAdministratorID());
		assertEquals("Dragica", a.getIme());
		assertEquals("Ljubisavljevic", a.getPrezime());
		assertEquals("gaga", a.getKorisnickoIme());
		assertEquals("gaga123", a.getLozinka());

	}

	@Test
	void testSetIme() {
		a.setIme("Dragica");
		
		assertEquals("Dragica", a.getIme());
	}
	
	@Test
	void testSetImeNull(){
		assertThrows(java.lang.NullPointerException.class, () -> a.setIme(null));
	}
	
	@Test
	void testSetImeKratakString() {
		assertThrows(java.lang.RuntimeException.class, () -> a.setIme("D"));
	}
	
	@Test
	void testSetPrezime() {
		a.setPrezime("Ljubisavljevic");
		
		assertEquals("Ljubisavljevic", a.getPrezime());
	}
	
	@Test
	void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class, () -> a.setPrezime(null));
	}
	
	@Test
	void testSetPrezimeKratakString() {
		assertThrows(java.lang.RuntimeException.class, () -> a.setPrezime("L"));
	}


	@Test
	void testSetKorisnickoIme() {
		a.setKorisnickoIme("gaga");
		
		assertEquals("gaga", a.getKorisnickoIme());	
	}
	
	@Test
	void testSetKorisnickoImeNull(){
		assertThrows(java.lang.NullPointerException.class, () -> a.setKorisnickoIme(null));
	}
	

	@Test
	void testSetLozinka() {
		a.setLozinka("gaga123");
		
		assertEquals("gaga123", a.getLozinka());	
	}
	
	@Test
	void testSetLozinkaNull() {
		assertThrows(java.lang.NullPointerException.class, () -> a.setLozinka(null));
	}
	
	@Test
	void testSetLozinkaKratakString() {
		assertThrows(java.lang.RuntimeException.class, () -> a.setLozinka("gaga"));
	}

	@Test
	void testToString() {
		a.setIme("Dragica");
		a.setPrezime("Ljubisavljevic");
		
		String rezultat=a.toString();
		
		assertTrue(rezultat.contains("Dragica"));
		assertTrue(rezultat.contains("Ljubisavljevic"));
	}

	@ParameterizedTest
	@CsvSource(
			{
				"gaga, gaga, true",
				"gaga, gagaa, false",
			}
	)
	void testEqualsObject(String korisnickoIme1, String korisnickoIme2, boolean rez) {
		a.setKorisnickoIme(korisnickoIme1);
		
		Administrator a2=new Administrator();
		a2.setKorisnickoIme(korisnickoIme2);
		
		assertEquals(rez, a.equals(a2));
	}

	
	@Test
	void testVratiUslovZaSelect() {
		a.setKorisnickoIme("gaga");
		a.setLozinka("gaga123");
		
		String rezultat=a.vratiUslovZaSelect();
		
		assertEquals("korisnickoIme='gaga' and lozinka='gaga123'", rezultat);
	}

	@Test
	void testVratiListu() throws Exception {
        AutoCloseable ac = MockitoAnnotations.openMocks(this);

		kreirajAdmministratorResultSet();
				
		Administrator a1=new Administrator();
		List<ApstraktniDomenskiObjekat> lista1=a1.vratiListu(rs);

		Administrator a2=new Administrator();
		a2.setAdministratorID(1l);
		a2.setIme("Dragica");
		a2.setPrezime("Ljubisavljevic");
		a2.setKorisnickoIme("gaga");
		a2.setLozinka("gaga123");
		
		List<ApstraktniDomenskiObjekat> lista2=new ArrayList<>();
		lista2.add(a2);
		
		assertEquals(lista1, lista2);
		ac.close();
	}
	
	private void kreirajAdmministratorResultSet() throws SQLException {
        Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getLong("AdministratorId")).thenReturn(1l);
		Mockito.when(rs.getString("Ime")).thenReturn("Dragica");
		Mockito.when(rs.getString("Prezime")).thenReturn("Ljubisavljevic");
		Mockito.when(rs.getString("KorisnickoIme")).thenReturn("gaga");
		Mockito.when(rs.getString("Lozinka")).thenReturn("gaga123");
    }

}
