package rs.ac.bg.fon.nprog.domen;

import static org.junit.jupiter.api.Assertions.*;

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
class BaletskaGrupaNastupTest {
	
	BaletskaGrupaNastup baletskaGrupaNastup;
	
	@Mock
	private ResultSet rs;


	@BeforeEach
	void setUp() throws Exception {
		baletskaGrupaNastup=new BaletskaGrupaNastup();
	}

	@AfterEach
	void tearDown() throws Exception {
		baletskaGrupaNastup=null;
	}

	@Test
	void testBaletskaGrupaNastup() {
		baletskaGrupaNastup=new BaletskaGrupaNastup();
		
		assertNotNull(baletskaGrupaNastup);
	}

	@Test
	void testBaletskaGrupaNastupBaletskaGrupaNastup() {
		BaletskaGrupa bg1=new BaletskaGrupa();
		bg1.setBaletskaGrupaId(1l);
		
		Nastup n1=new Nastup();
		n1.setNastupId(1l);
		
		BaletskaGrupaNastup baletskaGrupaNastup=new BaletskaGrupaNastup(bg1, n1);
		
		assertEquals(bg1, baletskaGrupaNastup.getBaletskaGrupaId());
		assertEquals(n1, baletskaGrupaNastup.getNastupId());
		
	}

	@ParameterizedTest
	@CsvSource(
			{
				"1, 3, 1, 3, true",
				"1, 1, 2, 2, false",
			}
	)
	void testEqualsObject(Long baletskaGrupaId1, Long nastupId1,Long baletskaGrupaId2,  Long nastupId2, boolean rez) {
		BaletskaGrupa bg1=new BaletskaGrupa();
		bg1.setBaletskaGrupaId(baletskaGrupaId1);
		Nastup n1=new Nastup();
		n1.setNastupId(nastupId1);
		baletskaGrupaNastup.setBaletskaGrupaId(bg1);
		baletskaGrupaNastup.setNastupId(n1);
		
		BaletskaGrupaNastup baletskaGrupaNastup2=new BaletskaGrupaNastup();
		BaletskaGrupa bg2=new BaletskaGrupa();
		bg2.setBaletskaGrupaId(baletskaGrupaId2);
		Nastup n2=new Nastup();
		n2.setNastupId(nastupId2);
		
		baletskaGrupaNastup2.setBaletskaGrupaId(bg2);
		baletskaGrupaNastup2.setNastupId(n2);
		
		assertEquals(rez, baletskaGrupaNastup.equals(baletskaGrupaNastup2));

	}

	@Test
	void testVratiVrednostiZaInsert() {
		BaletskaGrupa bg1=new BaletskaGrupa();
		bg1.setBaletskaGrupaId(1l);
		Nastup n1=new Nastup();
		n1.setNastupId(3l);
		
		BaletskaGrupaNastup baletskaGrupaNastup=new BaletskaGrupaNastup();
		baletskaGrupaNastup.setBaletskaGrupaId(bg1);
		baletskaGrupaNastup.setNastupId(n1);
		
		String rezultat=baletskaGrupaNastup.vratiVrednostiZaInsert();
		
		assertEquals("1, 3", rezultat);

	}

	@Test
	void testVratiUslovZaSelect() {
		BaletskaGrupa bg1=new BaletskaGrupa();
		bg1.setBaletskaGrupaId(2l);
		Nastup n1=new Nastup();
		n1.setNastupId(1l);
		
		BaletskaGrupaNastup baletskaGrupaNastup=new BaletskaGrupaNastup();
		baletskaGrupaNastup.setBaletskaGrupaId(bg1);
		baletskaGrupaNastup.setNastupId(n1);
		
		String rezultat=baletskaGrupaNastup.vratiUslovZaSelect();
		
		assertEquals("BaletskaGrupaId = 2 AND NastupId = 1", rezultat);
	}


	@Test
	void testVratiUslovZaPretragu() {
		BaletskaGrupa bg1=new BaletskaGrupa();
		bg1.setBaletskaGrupaId(2l);
		Nastup n1=new Nastup();
		n1.setNastupId(1l);
		
		BaletskaGrupaNastup baletskaGrupaNastup=new BaletskaGrupaNastup();
		baletskaGrupaNastup.setBaletskaGrupaId(bg1);
		baletskaGrupaNastup.setNastupId(n1);
		
		String rezultat=baletskaGrupaNastup.vratiUslovZaPretragu();
		
		assertEquals("BaletskaGrupaId= 2", rezultat);
	}

	@Test
	void testVratiListu() throws Exception {
		AutoCloseable ac = MockitoAnnotations.openMocks(this);

		kreirajBaletskaGrupaNastupResultSet();
				
		BaletskaGrupaNastup baletskaGrupaNastup1=new BaletskaGrupaNastup();
		List<ApstraktniDomenskiObjekat> lista1=baletskaGrupaNastup1.vratiListu(rs);

		BaletskaGrupaNastup baletskaGrupaNastup2=new BaletskaGrupaNastup();
		BaletskaGrupa baletskaGrupa=new BaletskaGrupa();
		baletskaGrupa.setBaletskaGrupaId(2l);
		Nastup nastup=new Nastup();
		nastup.setNastupId(1l);
		
		baletskaGrupaNastup2.setBaletskaGrupaId(baletskaGrupa);
		baletskaGrupaNastup2.setNastupId(nastup);
		
		List<ApstraktniDomenskiObjekat> lista2=new ArrayList<>();
		lista2.add(baletskaGrupaNastup2);
		
		assertEquals(lista1, lista2);
		ac.close();
	}

	private void kreirajBaletskaGrupaNastupResultSet() throws SQLException {
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rs.getLong("BaletskaGrupaId")).thenReturn(2l);
		Mockito.when(rs.getLong("NastupId")).thenReturn(1l);
		
	}

	
}
