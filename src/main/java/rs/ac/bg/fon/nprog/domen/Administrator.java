package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Administrator implements Serializable, ApstraktniDomenskiObjekat{
	
	private Long administratorID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    
    public Administrator() {
    }

    public Administrator(Long administratorID, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.administratorID = administratorID;
        setIme(ime);
        setPrezime(prezime);
        setKorisnickoIme(korisnickoIme);
        setLozinka(lozinka);
    }
    
    public Long getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(Long administratorID) {
        this.administratorID = administratorID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
    	if(ime == null) {
    		throw new NullPointerException("Ime ne sme biti null!");
    	}
    	if(ime.length() < 2) {
    		throw new RuntimeException("Ime mora imati vise od dva znaka!");
    	}
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
    	if(prezime == null) {
    		throw new NullPointerException("Prezime ne sme biti null!");
    	}
    	if(prezime.length() < 2) {
    		throw new RuntimeException("Prezime mora imati vise od dva znaka!");
    	}
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
    	if(korisnickoIme == null) {
    		throw new NullPointerException("Korisnicko ime ne sme biti null!");
    	}
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
    	if(lozinka == null) {
    		throw new NullPointerException("Ime ne sme biti null!");
    	}
    	if(lozinka.length() <= 4) {
    		throw new RuntimeException("Lozinka mora imati barem 4 znaka!");
    	}
        this.lozinka = lozinka;
    }

    

    @Override
    public String toString() {
        return "Administrator{" + "ime=" + ime + ", prezime=" + prezime + '}';
    }


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
