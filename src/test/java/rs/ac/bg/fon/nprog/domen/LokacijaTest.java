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
class LokacijaTest {
	
	Lokacija l;
	
	@Mock
	private ResultSet rs;
	
	@BeforeEach
	void setUp() throws Exception {
		l=new Lokacija();
	}

	@AfterEach
	void tearDown() throws Exception {
		l=null;
	}

	@Test
	void testLokacija() {
		l=new Lokacija();
		
		assertNotNull(l);

	}

	@Test
	void testLokacijaLongStringStringString() {
		l=new Lokacija(1l, "Pozarevac", "Dom kulture", "glavna sala");
		
		assertNotNull(l);
		assertEquals(1l, l.getLokacijaId());
		assertEquals("Pozarevac", l.getNazivGrada());
		assertEquals("Dom kulture", l.getNazivUstanove());
		assertEquals("glavna sala", l.getSala());

	}

	@Test
	void testSetSala() {
		l.setSala("glavna sala");;
		
		assertEquals("glavna sala", l.getSala());
	}
	
	@Test
	void testSetSalaNull(){
		assertThrows(java.lang.NullPointerException.class, () -> l.setSala(null));
	}
	
	@Test
	void testSetSalaKratakString() {
		assertThrows(java.lang.RuntimeException.class, () -> l.setSala(""));
	}
	
	@Test
	void testSetNazivGrada() {
		l.setNazivGrada("Pozarevac");;
		
		assertEquals("Pozarevac", l.getNazivGrada());	
	}
	
	@Test
	void testSetNazivGradaNull(){
		assertThrows(java.lang.NullPointerException.class, () -> l.setNazivGrada(null));
	}
	
	@Test
	void testSetNazivGradaKratakString() {
		assertThrows(java.lang.RuntimeException.class, () -> l.setNazivGrada("P"));
	}

	@Test
	void testSetNazivUstanove() {
		l.setNazivUstanove("Dom kulture");;
		
		assertEquals("Dom kulture", l.getNazivUstanove());	
	}
	
	@Test
	void testSetNazivUstanoveNull(){
		assertThrows(java.lang.NullPointerException.class, () -> l.setNazivUstanove(null));
	}
	
	@Test
	void testSetNazivUstanoveKratakString() {
		assertThrows(java.lang.RuntimeException.class, () -> l.setNazivUstanove("D"));
	}
	@Test
	void testToString() {
		l.setNazivUstanove("Dom kulture");
		l.setNazivGrada("Pozarevac");
		
		String rezultat=l.toString();
		
		assertEquals("Dom kulture Pozarevac", rezultat);	

	}

	@ParameterizedTest
	@CsvSource(
			{
				"5, 5, true",
				"1, 15, false",
			}
	)
	void testEqualsObject(Long lokacijaId1, Long lokacijaId2, boolean rez) {
		l.setLokacijaId(lokacijaId1);
		
		Lokacija l2=new Lokacija();
		l2.setLokacijaId(lokacijaId2);
		
		assertEquals(rez, l.equals(l2));
	}

	@Test
	void testVratiVrednostiZaInsert() {
		l.setNazivGrada("Pozarevac");
		l.setNazivUstanove("Dom kulture");
		l.setSala("velika sala");
		
		String rezultat=l.vratiVrednostiZaInsert();
		
		assertEquals("'Pozarevac', 'Dom kulture', 'velika sala'", rezultat);	
	}

	@Test
	void testVratiUslovZaSelect() {
		l.setLokacijaId(1l);
		
		String rezultat=l.vratiUslovZaSelect();
		
		assertEquals("LokacijaId = 1", rezultat);
	}


	@Test
	void testVratiListu() throws Exception {
		AutoCloseable ac = MockitoAnnotations.openMocks(this);

		kreirajLokacijaResultSet();
				
		Lokacija l1=new Lokacija();
		List<ApstraktniDomenskiObjekat> lista1=l1.vratiListu(rs);

		Lokacija l2=new Lokacija();
		l2.setLokacijaId(1l);
		l2.setNazivGrada("Pozarevac");
		l2.setNazivUstanove("Dom kulture");
		l2.setSala("velika sala");
		
		List<ApstraktniDomenskiObjekat> lista2=new ArrayList<>();
		lista2.add(l2);
		
		assertEquals(lista1, lista2);
		ac.close();
	}

	private void kreirajLokacijaResultSet() throws SQLException {
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getLong("LokacijaId")).thenReturn(1l);
		Mockito.when(rs.getString("NazivGrada")).thenReturn("Pozarevac");
		Mockito.when(rs.getString("NazivUstanove")).thenReturn("Dom kulture");
		Mockito.when(rs.getString("Sala")).thenReturn("velika sala");
	}

}
