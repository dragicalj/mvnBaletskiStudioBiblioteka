package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Klasa koja predstavlja koreografa u baletskom studiju. 
 * Ova klasa implementira interfejs ApstraktniDomenskiObjekat u odnosu na tabelu koreograf u bazi podataka.
 * Takodje,implementira interfejs Serializiable zbog prolaza kroz mrezu.
 * 
 * Svaka baletska grupa ima svog koreografa.
 * 
 * Koreograf ima svoj jedinstveni identifikator koji je jedinstveno identifikuje, ime,
 * prezime, datumRodjenja, email, brojTelefona i vrstu baleta za koju je specijalizovan
 * (klasican, moderan ili jazz balet)
 * 
 * @author Dragica Ljubisavljevic
 * @version 1.0
 *
 */
public class Koreograf implements Serializable,ApstraktniDomenskiObjekat {
		
		/**
		 * ID koreografa kao Long vrednost.
		 */
	 	private Long koreografId;
	 	/**
		 * Ime koreografa kao String.
		 */
	    private String ime;
	    /**
		 * Prezime koreografa kao String.
		 */
	    private String prezime;
	    /**
		 * Datum rodjenja koreografa kao Date.
		 */
	    private Date datumRodjenja;
	    /**
		 * Email koreografa kao String.
		 */
	    private String email;
	    /**
		 * Broj telefona koreografa kao String.
		 */
	    private String brojTelefona;
	    /**
		 * Specijalizovanost koreografa kao String.
		 */
	    private String specijalizovanost;
	    
	    
	    /**
	     * Konstruktor koji inicijalizuje objekat klase Koreograf.
	     */
	    public Koreograf() {
	    }
	    
	    /**
	     * Konstruktor koji inicijalizuje objekat klase Koreograf i postavlja prosledjene vrednosti njenim atributima. 
	     * 
	     * @param koreografId novi ID koreografa kao Long vrendost.
	     * @param ime ime novog koreografa kao String vrednost.
	     * @param prezime prezime novog koreografa kao String vrednost.
	     * @param datumRodjenja datum rodjenja novog koreografa kao Date vrednost.
	     * @param email email novog koreografa kao String vrednost.
	     * @param brojTelefona broj telefona novog koreografa kao String vrednost.
	     * @param specijalizovanost specijalizovanost novog koreografa kao String vrednost.
	     */
	    public Koreograf(Long koreografId, String ime, String prezime, Date datumRodjenja, String email, String brojTelefona, String specijalizovanost) {
	        this.koreografId = koreografId;
	        setIme(ime);
	        setPrezime(prezime);
	        setDatumRodjenja(datumRodjenja);
	        setEmail(email);
	        setBrojTelefona(brojTelefona);
	        setSpecijalizovanost(specijalizovanost);
	    }
	    
	    
	    /**
	     * Vraca vrstu baleta za koju je koreograf specijalizovan.
	     * 
	     * @return specijalizovanost koreografa kao String.
	     */
	    public String getSpecijalizovanost() {
	        return specijalizovanost;
	    }
	    
	    /**
	     * Postavlja vrednost atributa specijalizovanost na novu unetu vrednost.
	     * 
	     * @param specijalizovanost specijalizovanost koreografa kao String.
	     * @throws java.lang.RuntimeException ako nije uneto klasican, moderan ili jazz balet za specijalizovanost koreografa
	     * 
	     */
	    public void setSpecijalizovanost(String specijalizovanost) {
	    	if(!specijalizovanost.equalsIgnoreCase("Klasican balet") && !specijalizovanost.equalsIgnoreCase("Moderan balet") && !specijalizovanost.equalsIgnoreCase("Jazz balet")) {
	    		throw new RuntimeException("Specijalizovanost koreografa mora biti: klasican, moderan ili jazz balet!");
	    	}
	        this.specijalizovanost = specijalizovanost;
	    }
	    
	    /**
	     * Vraca ID koreografa.
	     * 
	     * @return ID koreografa kao Long.
	     */
	    public Long getKoreografId() {
	        return koreografId;
	    }
	    
	    /**
	     * Postavlja vrednost atributa koreografId na novu unetu vrednost.
	     * 
	     * @param koreografId ID koreografa kao Long.
	     */
	    public void setKoreografId(Long koreografId) {
	        this.koreografId = koreografId;
	    }
	    
	    /**
	     * Vraca ime koreografa.
	     * 
	     * @return ime koreografa kao String.
	     */
	    public String getIme() {
	        return ime;
	    }
	    
	    /**
	     * Postavlja vrednost atributa ime na novu unetu vrednost.
	     * 
	     * @param ime ime koreografa kao String.
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
	     * Vraca prezime koreografa.
	     * 
	     * @return prezime koreografa kao String.
	     */
	    public String getPrezime() {
	        return prezime;
	    }
	    
	    /**
	     * Postavlja vrednost atributa prezime na novu unetu vrednost.
	     * 
	     * @param prezime prezime koreografa kao String.
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
	     * Vraca datum rodjenja koreografa.
	     * 
	     * @return datum rodjenja koreografa kao String.
	     */
	    public Date getDatumRodjenja() {
	        return datumRodjenja;
	    }
	    
	    /**
	     * Postavlja vrednost atributa datumRodjenja na novu unetu vrednost.
	     * 
	     * @param datumRodjenja datumRodjenja koreografa kao Date.
	     * @throws java.lang.RuntimeException ako je uneti datumRodjenja posle danasnjeg datuma
	     * 
	     */
	    public void setDatumRodjenja(Date datumRodjenja) {
	    	if(datumRodjenja.after(new java.util.Date())) {
	    		throw new RuntimeException("Datum rodjenja ne sme biti posle danasnjeg datuma!");
	    	}
	        this.datumRodjenja = datumRodjenja;
	    }
	    
	    /**
	     * Vraca email koreografa.
	     * 
	     * @return email koreografa kao String.
	     */
	    public String getEmail() {
	        return email;
	    }
	    
	    /**
	     * Postavlja vrednost atributa email na novu unetu vrednost.
	     * 
	     * @param email email koreografa kao String.
	     * @throws java.lang.RuntimeException ako unet email ne sadrzi potreban znak
	     * 
	     */
	    public void setEmail(String email) {
	    	if(!email.contains("@")) {
	    		throw new RuntimeException("Email adresa mora da sadrzi @!");
	    	}
	        this.email = email;
	    }
	    
	    /**
	     * Vraca brojTelefona koreografa.
	     * 
	     * @return broj telefona koreografa kao String.
	     */
	    public String getBrojTelefona() {
	        return brojTelefona;
	    }
	    
	    /**
	     * Postavlja vrednost atributa broj telefona na novu unetu vrednost.
	     * 
	     * @param brojTelefona broj telefona koreografa kao String.
	     * @throws java.lang.RuntimeException ako unet broj telefona nije u odgovarajucem formatu
	     * 
	     */
	    public void setBrojTelefona(String brojTelefona) {
	    	Pattern pattern = Pattern.compile("^(\\+)(3816)([0-9]){6,9}$");

	    	if(!pattern.matcher(brojTelefona).matches()) {
	    		throw new RuntimeException("Broj telefona nije u dobrom formatu!");
	    	}
	        this.brojTelefona = brojTelefona;
	    }
	    
	    /**
	     * Vraca String koji predstavlja ime i prezime koreografa.
	     * 
	     * @return Ime i prezime koreografa kao String.
	     */
	    @Override
	    public String toString() {
	        return ime+" "+prezime; //To change body of generated methods, choose Tools | Templates.
	    }

	    @Override
	    public int hashCode() {
	        int hash = 7;
	        return hash;
	    }
	    
	    /**
	     * Poredi dva administratora po jedinstvenim identifikatorima i vraca true ili false.
	     * 
	     * @return
		 * <ul>
		 * <li>true ako su oba objekta klase Koreograf i imaju isti ID.</li>
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

	    /**
	     * Vraca uslov koji se koristi prilikom pretrage koreografa.
	     * Pretraga se vrsi na osnovu toga da li je uneto samo ime, samo prezime, samo specijalizovanost
	     * ili sva tri parametra.
	     * Na osnovu vrednosti ovih atributa formira se uslov za upit i vraca kao String vrednost.
	     * 
	     * @return uslov za pretragu koreografa kao String.
	     * 
	     */
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
