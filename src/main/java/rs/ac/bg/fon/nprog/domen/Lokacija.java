package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Klasa koja predstavlja lokacije na kojima se odrzavaju nastupi baletskih grupa baletskog studija. 
 * Ova klasa implementira interfejs ApstraktniDomenskiObjekat u odnosu na tabelu lokacija u bazi podataka.
 * Takodje,implementira interfejs Serializiable zbog prolaza kroz mrezu.
 * 
 * Lokacija ima svoj jedinstveni identifikator koji je jedinstveno identifikuje, naziv grada, naziv
 * ustanove i salu u kojoj ce se nastup odrzati
 * 
 * @author Dragica Ljubisavljevic
 * @version 1.0
 *
 */
public class Lokacija implements Serializable, ApstraktniDomenskiObjekat{
	
	/**
	 * ID lokacije kao Long vrednost.
	 */
	private Long lokacijaId;
	/**
	 * Naziv grada u kome se nastup odrzava kao String.
	 */
    private String nazivGrada;
    /**
	 * Naziv ustanove u kojoj se nastup odrzava kao String.
	 */
    private String nazivUstanove;
    /**
	 * Naziv sale u kojoj se nastup odrzava kao String.
	 */
    private String sala;
    
    /**
     * Konstruktor koji inicijalizuje objekat klase BaletskaGrupa.
     */
    public Lokacija() {
    }
    
    /**
     * Konstruktor koji inicijalizuje objekat klase Lokacija i postavlja prosledjene vrednosti njenim atributima. 
     * 
     * @param lokacijaId novi ID lokacije kao Long vrednost.
     * @param nazivGrada naziv grada za nastup kao String vrednost.
     * @param nazivUstanove naziv ustanove za nastup kao String vrednost.
     * @param sala sala za nastup kao String vrednost.
     */
    public Lokacija(Long lokacijaId, String nazivGrada, String nazivUstanove, String sala) {
        this.lokacijaId = lokacijaId;
        setNazivGrada(nazivGrada);
        setNazivUstanove(nazivUstanove);
        setSala(sala);
    }
    
    /**
     * Vraca oznaku sale u kojoj se odrzava nastup baletske grupe.
     * 
     * @return oznaka sale kao String.
     */
    public String getSala() {
        return sala;
    }
    
    /**
     * Postavlja vrednost atributa sala na novu unetu vrednost.
     * 
     * @param sala oznaka sale za nastup kao String.
     * @throws java.lang.NullPointerException ako je uneta oznaka sale null
     * @throws java.lang.RuntimeException ako je uneta oznaka sale koja ima manje od jednog znaka
     * 
     */
    public void setSala(String sala) {
    	if(sala == null) {
    		throw new NullPointerException("Oznaka sale ne sme biti null!");
    	}
    	if(sala.length() < 1) {
    		throw new RuntimeException("Oznaka sale mora imati barem jedan znak!");
    	}
        this.sala = sala;
    }
    
    /**
     * Vraca ID lokacije za odrzavanje nastupa.
     * 
     * @return ID lokacije kao Long.
     */
    public Long getLokacijaId() {
        return lokacijaId;
    }
    
    /**
     * Postavlja vrednost atributa lokacijaId na novu unetu vrednost.
     * 
     * @param lokacijaId ID lokacije kao Long.
     */
    public void setLokacijaId(Long lokacijaId) {
        this.lokacijaId = lokacijaId;
    }
    
    /**
     * Vraca naziv grada u kome ce se nastup odrzati.
     * 
     * @return naziv grada kao String.
     */
    public String getNazivGrada() {
        return nazivGrada;
    }
    
    /**
     * Postavlja vrednost atributa nazivGrada na novu unetu vrednost.
     * 
     * @param nazivGrada naziv grada u kome ce se nastup odrzati kao String.
     * @throws java.lang.NullPointerException ako je unet naziv null
     * @throws java.lang.RuntimeException ako je unet naziv koji ima manje od 2 znaka
     * 
     */
    public void setNazivGrada(String nazivGrada) {
    	if(nazivGrada == null) {
    		throw new NullPointerException("Naziv grada ne sme biti null!");
    	}
    	if(nazivGrada.length() < 2) {
    		throw new RuntimeException("Naziv grada mora biti duzi od dva karaktera!");
    	}
        this.nazivGrada = nazivGrada;
    }
    
    /**
     * Vraca naziv ustanove u komjoj ce se nastup odrzati.
     * 
     * @return naziv ustanove kao String.
     */
    public String getNazivUstanove() {
        return nazivUstanove;
    }
    
    /**
     * Postavlja vrednost atributa nazivUstanove na novu unetu vrednost.
     * 
     * @param nazivUstanove naziv ustanove u komjoj ce se nastup odrzati kao String.
     * @throws java.lang.NullPointerException ako je unet naziv null
     * @throws java.lang.RuntimeException ako je unet naziv koji ima manje od 2 znaka
     * 
     */
    public void setNazivUstanove(String nazivUstanove) {
    	if(nazivUstanove == null) {
    		throw new NullPointerException("Naziv ustanove ne sme biti null!");
    	}
    	if(nazivUstanove.length() < 2) {
    		throw new RuntimeException("Naziv ustanove mora biti duzi od dva karaktera!");
    	}
        this.nazivUstanove = nazivUstanove;
    }

    /**
     * Vraca String koji predstavlja naziv ustanove i naziv grada.
     * 
     * @return naziv ustanove i naziv grada kao String.
     */
    @Override
    public String toString() {
        return nazivUstanove+" "+nazivGrada;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    
    /**
     * Poredi dve lokacije po jedinstvenim identifikatorima i vraca true ili false.
     * 
     * @return
	 * <ul>
	 * <li>true ako su oba objekta klase Lokacija i imaju isti ID.</li>
	 * <li>false u svim ostalim slucajevima</li>
	 * </ul>
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lokacija other = (Lokacija) obj;
        if (!Objects.equals(this.lokacijaId, other.lokacijaId)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String vratiNazivTabele() {
        return "Lokacija";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "NazivGrada, NazivUstanove, Sala";    
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + nazivGrada + "', '" + nazivUstanove + "', '" + sala + "'";
    }

    @Override
    public String vratiUslovZaSelect() {
        return "LokacijaId = " + lokacijaId;
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaPromenuVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaPretragu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Lokacija lokacija = new Lokacija();
            lokacija.setLokacijaId(rs.getLong("LokacijaId"));
            lokacija.setNazivGrada(rs.getString("NazivGrada"));
            lokacija.setNazivUstanove(rs.getString("NazivUstanove"));
            lokacija.setSala(rs.getString("Sala"));

            lista.add(lokacija);
        }
        return lista;
    }

    @Override
    public String vratiUslovZaPretragu2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
