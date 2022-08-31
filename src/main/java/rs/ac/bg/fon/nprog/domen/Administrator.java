package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Klasa koja predstavlja coveka koji je administrator u baletskom studiju. 
 * Ova klasa implementira interfejs ApstraktniDomenskiObjekat u odnosu na tabelu administrator u bazi podataka.
 * Takodje,implementira interfejs Serializiable zbog prolaza kroz mrezu.
 * Administrator ima svoj ID koji ga jedinstveno identifikuje, ime, prezime, korisnicko ime i lozinku kao String vrednosti
 * 
 * @author Dragica Ljubisavljevic
 * @version 1.0
 *
 */
public class Administrator implements Serializable, ApstraktniDomenskiObjekat{
	
	/**
	 * ID administratora kao Long vrednost.
	 */
	private Long administratorID;
	/**
	 * Ime administratora kao String.
	 */
    private String ime;
    /**
     * Prezime administratora kao String.
     */
    private String prezime;
    /**
     * Korisnicko ime administratora za prijavu na aplikaciju kao String.
     */
    private String korisnickoIme;
    /**
     * Lozinka administratora kao String.
     */
    private String lozinka;
    
    /**
     * Konstruktor koji inicijalizuje objekat klase Administrator.
     */
    public Administrator() {
    }
    /**
     * Konstruktor koji inicijalizuje objekat klase Administrator i postavlja prosledjene vrednosti njenim atributima. 
     * 
     * @param administratorID ID administratora kao Long.
     * @param ime Ime administratora kao String.
     * @param prezime Prezime administratora kao String.
     * @param korisnickoIme Korisnicko ime administratora kao String
     * @param lozinka Lozinka administratora kao String.
     */
    public Administrator(Long administratorID, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.administratorID = administratorID;
        setIme(ime);
        setPrezime(prezime);
        setKorisnickoIme(korisnickoIme);
        setLozinka(lozinka);
    }
    /**
     * Vraca ID administratora.
     * 
     * @return ID administratora kao Long.
     */
    public Long getAdministratorID() {
        return administratorID;
    }
    /**
     * Postavlja vrednost atributa administratorID na novu unetu vrednost.
     * 
     * @param administratorID ID administratora kao Long.
     */
    public void setAdministratorID(Long administratorID) {
        this.administratorID = administratorID;
    }
    /**
     * Vraca ime administratora.
     * 
     * @return ime administratora kao String.
     */
    public String getIme() {
        return ime;
    }
    
    /**
     * Postavlja vrednost atributa ime na novu unetu vrednost.
     * 
     * @param ime ime administratora kao String.
     * @throws java.lang.NullPointerException ako je uneto ime null
     * @throws java.lang.RuntimeException ako je uneto ime koje ima manje od 2 znaka
     * 
     */
    public void setIme(String ime) {
    	if(ime == null) {
    		throw new NullPointerException("Ime ne sme biti null!");
    	}
    	if(ime.length() < 2) {
    		throw new RuntimeException("Ime mora imati vise od dva znaka!");
    	}
        this.ime = ime;
    }
    /**
     * Vraca prezime administratora.
     * 
     * @return prezime administratora kao String.
     */
    public String getPrezime() {
        return prezime;
    }
    /**
     * Postavlja vrednost atributa prezime na novu unetu vrednost.
     * 
     * @param prezime prezime administratora kao String.
     * @throws java.lang.NullPointerException ako je uneto prezime null
     * @throws java.lang.RuntimeException ako je uneto prezime koje ima manje od 2 znaka
     * 
     */
    public void setPrezime(String prezime) {
    	if(prezime == null) {
    		throw new NullPointerException("Prezime ne sme biti null!");
    	}
    	if(prezime.length() < 2) {
    		throw new RuntimeException("Prezime mora imati vise od dva znaka!");
    	}
        this.prezime = prezime;
    }
    /**
     * Vraca korisnicko ime administratora.
     * 
     * @return korisnicko ime administratora kao String.
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }
    /**
     * Postavlja vrednost atributa korisnicko ime na novu unetu vrednost.
     * 
     * @param korisnickoIme korisnicko ime administratora kao String.
     * @throws java.lang.NullPointerException ako je uneto korisnicko ime null
     * 
     */
    public void setKorisnickoIme(String korisnickoIme) {
    	if(korisnickoIme == null) {
    		throw new NullPointerException("Korisnicko ime ne sme biti null!");
    	}
        this.korisnickoIme = korisnickoIme;
    }
    /**
     * Vraca lozinku administratora.
     * 
     * @return lozinka administratora kao String.
     */
    public String getLozinka() {
        return lozinka;
    }
    /**
     * Postavlja vrednost atributa lozinka na novu unetu vrednost.
     * 
     * @param lozinka lozinka administratora kao String.
     * @throws java.lang.NullPointerException ako je uneta lozinka null
     * @throws java.lang.RuntimeException ako je uneta lozinka koje ima manje od 4 znaka
     * 
     */
    public void setLozinka(String lozinka) {
    	if(lozinka == null) {
    		throw new NullPointerException("Ime ne sme biti null!");
    	}
    	if(lozinka.length() < 4) {
    		throw new RuntimeException("Lozinka mora imati barem 4 znaka!");
    	}
        this.lozinka = lozinka;
    }

    
    /**
     * Vraca String koji predstavlja ime i prezime administatora.
     * 
     * @return Ime i prezime administratora kao String.
     */
    @Override
    public String toString() {
        return "Administrator{" + "ime=" + ime + ", prezime=" + prezime + '}';
    }

    /**
     * Poredi dva administratora po korisnickom imenu i vraca true ili false.
     * 
     * @return
	 * <ul>
	 * <li>true ako su oba objekta klase Adminitrator i imaju isto korisnicko ime.</li>
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
        final Administrator other = (Administrator) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String vratiNazivTabele() {
        return "Administrator"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaSelect() {
        return "korisnickoIme='" + korisnickoIme + "' and lozinka='" + lozinka + "'"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet resultSet) throws Exception {
        List<ApstraktniDomenskiObjekat> list = new ArrayList<>();
        while (resultSet.next()) {
            Administrator administrator = new Administrator();
            administrator.setAdministratorID(resultSet.getLong("AdministratorId"));
            administrator.setIme(resultSet.getString("Ime"));
            administrator.setPrezime(resultSet.getString("Prezime"));
            administrator.setKorisnickoIme(resultSet.getString("KorisnickoIme"));
            administrator.setLozinka(resultSet.getString("Lozinka"));
            
            list.add(administrator);
        }
        return list;
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public String vratiUslovZaPretragu2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
