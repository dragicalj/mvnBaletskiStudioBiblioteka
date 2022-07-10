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
class NastupTest {
	
	Nastup nastup;
	
	@Mock
	private ResultSet rs;

	@BeforeEach
	void setUp() throws Exception {
		nastup=new Nastup();
	}

	@AfterEach
	void tearDown() throws Exception {
		nastup=null;
	}

	@Test
	void testNastup() {
		nastup=new Nastup();
		
		assertNotNull(nastup);
	}

	@Test
	void testNastupLongDateTipNastupaLokacija() {
		Lokacija l=new Lokacija();
		l.setLokacijaId(2l);
		nastup=new Nastup(1l, new Date(2022, 10, 1), TipNastupa.KONCERT, l);
		
		assertNotNull(nastup);
		assertEquals(1l, nastup.getNastupId());
		assertEquals(new Date(2022, 10, 1), nastup.getDatumVremeNastupa());
		assertEquals(TipNastupa.KONCERT, nastup.getTipNastupa());
		assertEquals(l, nastup.getLokacija());


	}

	@Test
	void testSetDatumVremeNastupa() {
		nastup.setDatumVremeNastupa(new Date(2022, 10, 1));
		
		assertEquals(new Date(2022, 10, 1), nastup.getDatumVremeNastupa());	
	}

	@Test
	void testToString() {
		nastup.setDatumVremeNastupa(new Date(2022, 10, 1));
		nastup.setTipNastupa(TipNastupa.KARNEVAL);
		Lokacija l=new Lokacija();
		l.setLokacijaId(1l);
		l.setNazivGrada("Pozarevac");
		l.setNazivUstanove("Dom kulture");
		nastup.setLokacija(l);
		
		String rezultat=nastup.toString();
		assertTrue(rezultat.contains("KARNEVAL"));
		assertTrue(rezultat.contains("Pozarevac"));
		assertTrue(rezultat.contains("Dom kulture"));


	}

	@ParameterizedTest
	@CsvSource(
			{
				"1, 1, true",
				"1, 11, false",
			}
	)
	void testEqualsObject(Long nastupId1, Long nastupId2, boolean rez) {
		nastup.setNastupId(nastupId1);
		
		Nastup nastup2=new Nastup();
		nastup2.setNastupId(nastupId2);
		
		assertEquals(rez, nastup.equals(nastup2));
	}

	@Test
	void testVratiVrednostiZaInsert() {
		nastup.setDatumVremeNastupa(new Date(122, 10, 1));
		nastup.setTipNastupa(TipNastupa.KARNEVAL);
		Lokacija l=new Lokacija();
		l.setLokacijaId(5l);
		nastup.setLokacija(l);
		
		String rezultat=nastup.vratiVrednostiZaInsert();
		
		assertEquals("'2022-11-01', 'KARNEVAL', 5", rezultat);
		
	}

	@Test
	void testVratiUslovZaSelect() {
		nastup.setNastupId(3l);;
		
		String rezultat=nastup.vratiUslovZaSelect();
		
		assertEquals("NastupI = 3", rezultat);
	}


	
}
