package rs.ac.bg.fon.nprog.domen;

import java.util.Date;
import java.util.Objects;

public class Koreograf {
	
	 	private Long koreografId;
	    private String ime;
	    private String prezime;
	    private Date datumRodjenja;
	    private String email;
	    private String brojTelefona;
	    private String specijalizovanost;

	    public Koreograf() {
	    }

	    public Koreograf(Long koreografId, String ime, String prezime, Date datumRodjenja, String email, String brojTelefona, String specijalizovanost) {
	        this.koreografId = koreografId;
	        this.ime = ime;
	        this.prezime = prezime;
	        this.datumRodjenja = datumRodjenja;
	        this.email = email;
	        this.brojTelefona = brojTelefona;
	        this.specijalizovanost = specijalizovanost;
	    }

	    public String getSpecijalizovanost() {
	        return specijalizovanost;
	    }

	    public void setSpecijalizovanost(String specijalizovanost) {
	        this.specijalizovanost = specijalizovanost;
	    }

	    public Long getKoreografId() {
	        return koreografId;
	    }

	    public void setKoreografId(Long koreografId) {
	        this.koreografId = koreografId;
	    }

	    public String getIme() {
	        return ime;
	    }

	    public void setIme(String ime) {
	        this.ime = ime;
	    }

	    public String getPrezime() {
	        return prezime;
	    }

	    public void setPrezime(String prezime) {
	        this.prezime = prezime;
	    }

	    public Date getDatumRodjenja() {
	        return datumRodjenja;
	    }

	    public void setDatumRodjenja(Date datumRodjenja) {
	        this.datumRodjenja = datumRodjenja;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getBrojTelefona() {
	        return brojTelefona;
	    }

	    public void setBrojTelefona(String brojTelefona) {
	        this.brojTelefona = brojTelefona;
	    }

	    @Override
	    public String toString() {
	        return ime+" "+prezime; //To change body of generated methods, choose Tools | Templates.
	    }

	    @Override
	    public int hashCode() {
	        int hash = 7;
	        return hash;
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
	        final Koreograf other = (Koreograf) obj;
	        if (!Objects.equals(this.koreografId, other.koreografId)) {
	            return false;
	        }
	        return true;
	    }
}
