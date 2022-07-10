package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Koreograf implements Serializable,ApstraktniDomenskiObjekat {
	
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
	        setIme(ime);
	        setPrezime(prezime);
	        setDatumRodjenja(datumRodjenja);
	        setEmail(email);
	        setBrojTelefona(brojTelefona);
	        setSpecijalizovanost(specijalizovanost);
	    }

	    public String getSpecijalizovanost() {
	        return specijalizovanost;
	    }

	    public void setSpecijalizovanost(String specijalizovanost) {
	    	if(!specijalizovanost.equalsIgnoreCase("Klasican balet") && !specijalizovanost.equalsIgnoreCase("Moderan balet") && !specijalizovanost.equalsIgnoreCase("Jazz balet")) {
	    		throw new RuntimeException("Specijalizovanost koreografa mora biti: klasican, moderan ili jazz balet!");
	    	}
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

	    public Date getDatumRodjenja() {
	        return datumRodjenja;
	    }

	    public void setDatumRodjenja(Date datumRodjenja) {
	    	if(datumRodjenja.after(new java.util.Date())) {
	    		throw new RuntimeException("Datum rodjenja ne sme biti posle danasnjeg datuma!");
	    	}
	        this.datumRodjenja = datumRodjenja;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	    	if(!email.contains("@")) {
	    		throw new RuntimeException("Email adresa mora da sadrzi @!");
	    	}
	        this.email = email;
	    }

	    public String getBrojTelefona() {
	        return brojTelefona;
	    }

	    public void setBrojTelefona(String brojTelefona) {
	    	Pattern pattern = Pattern.compile("^(\\+)(3816)([0-9]){6,9}$");

	    	if(!pattern.matcher(brojTelefona).matches()) {
	    		throw new RuntimeException("Broj telefona nije u dobrom formatu!");
	    	}
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
	    
	    @Override
	    public String vratiNazivTabele() {
	        return "Koreograf";
	    }

	    @Override
	    public String vratiNaziveKolonaZaInsert() {
	        return "Ime, Prezime, DatumRodjenja, Email, BrojTelefona, Specijalizovanost";
	    }

	    @Override
	    public String vratiVrednostiZaInsert() {
	        return "'" + ime + "', '" + prezime + "', '" + new java.sql.Date(datumRodjenja.getTime()) + "', '" + 
	                     email + "', '" + brojTelefona + "', '" + specijalizovanost+"'";
	    }

	    @Override
	    public String vratiUslovZaSelect() {
	        return "KoreografId = " + koreografId;
	    }

	    @Override
	    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
	        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
	        while (rs.next()) {
	            Koreograf koreograf = new Koreograf();
	            koreograf.setKoreografId(rs.getLong("KoreografId"));
	            koreograf.setIme(rs.getString("Ime"));
	            koreograf.setPrezime(rs.getString("Prezime"));
	            Date datumRodjenja = new Date(rs.getDate("DatumRodjenja").getTime());
	            koreograf.setDatumRodjenja(datumRodjenja);
	            koreograf.setEmail(rs.getString("Email"));
	            koreograf.setBrojTelefona(rs.getString("BrojTelefona"));
	            koreograf.setSpecijalizovanost(rs.getString("Specijalizovanost"));

	            lista.add(koreograf);
	        }
	        return lista;
	    }

	    @Override
	    public String postaviVrednostiAtributa() {
	      return "Ime='" + ime + "', Prezime='" + prezime + "', DatumRodjenja='" + new java.sql.Date(datumRodjenja.getTime()) +
	                "', Email='" + email + "', BrojTelefona='" + brojTelefona +
	                "', Specijalizovanost='" + specijalizovanost+"'";
	    }

	    @Override
	    public String vratiUslovZaPromenuVrednostiAtributa() {
	        return "KoreografId=" + koreografId;
	    }

	    
	    @Override
	    public String vratiUslovZaPretragu() {
	        String upit="";
	        if(!(ime.equals(""))){
	            upit+="ime LIKE '" + ime+"' ";
	        }
	        if(!(prezime.equals("")) && !(ime.equals("")) ){
	            upit+="AND prezime "+"LIKE '"+prezime+"' ";
	        }
	        if(!(prezime.equals("")) && ime.equals("") ){
	            upit+="prezime "+"LIKE '"+prezime+"' ";
	        }
	        if(specijalizovanost != null && (!(prezime.equals("")) || !(ime.equals("")))){
	            upit+="AND specijalizovanost LIKE '"+specijalizovanost+"'";
	        }
	        if(specijalizovanost != null && prezime.equals("") && ime.equals("")){
	            upit+="specijalizovanost LIKE '"+specijalizovanost+"'";
	        }
	        
	        return upit;
	    }

	    @Override
	    public String vratiUslovZaPretragu2() {
	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }
	    
	    
}
