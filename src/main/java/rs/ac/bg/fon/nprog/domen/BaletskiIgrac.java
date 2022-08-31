package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Klasa koja predstavlja baletskog igraca u baletskom studiju. 
 * Ova klasa implementira interfejs ApstraktniDomenskiObjekat u odnosu na tabelu baletskiigrac u bazi podataka.
 * Takodje,implementira interfejs Serializiable zbog prolaza kroz mrezu.
 * 
 * Baletski igrac pripada jednoj baletskoj grupi. 
 * On vrsi uplate clanarine i sadrzi listu svojih uplata.
 * 
 * Baletska igrac takodje ima svoj jedinstveni identifikator koji je jedinstveno identifikuje, ime,
 * prezime, datumRodjenja, email, brojTelefona, brojTelefonaRoditelja, datumUpisa u baletski studio,
 * trenutni iznos clanarine
 * 
 * @author Dragica Ljubisavljevic
 * @version 1.0
 *
 */
public class BaletskiIgrac implements Serializable, ApstraktniDomenskiObjekat{
	
	/**
	 * ID baletskog igraca kao Long vrednost.
	 */
	private Long baletskiIgracId;
	/**
	 * Ime baletskog igraca kao String.
	 */
    private String ime;
    /**
	 * Prezime baletskog igraca kao String.
	 */
    private String prezime;
    /**
	 * Datum rodjenja baletskog igraca kao Date.
	 */
    private Date datumRodjenja;
    /**
	 * Email baletskog igraca kao String.
	 */
    private String email;
    /**
	 * Broj telefona baletskog igraca kao String.
	 */
    private String brojTelefona;
    /**
	 * Broj telefona roditelja baletskog igraca kao String.
	 */
    private String brojTelefonaRoditelja;
    /**
	 * Datum upisa baletskog igraca u baletski studio kao Date.
	 */
    private Date datumUpisa;
    /**
	 * Iznos trenutne clanarine baletskog igraca kao BigDecimal.
	 */
    private BigDecimal trenutnaClanarina;
    /**
	 * Baletska grupa kojoj baletski igrac pripada.
	 */
    private BaletskaGrupa baletskaGrupa;
    /**
     * Lista izvrsenih uplata clanarine baletskog igraca.
     */
    private List<Uplata> listaUplata;

    /**
     * Konstruktor koji inicijalizuje objekat klase BaletskiIgrac. Lista uplata baletskog igraca
     * inicijalizovana kao ArrayList
     */
    public BaletskiIgrac() {
        listaUplata=new ArrayList<>();
    }
    
    /**
     * Konstruktor koji inicijalizuje objekat klase BaletskiIgrac i postavlja prosledjene vrednosti njenim atributima. 
     * 
     * @param baletskiIgracId novi ID baletskog igraca kao Long vrendost.
     * @param ime ime novog baletskog igraca kao String vrednost.
     * @param prezime prezime novog baletskog igraca kao String vrednost.
     * @param datumRodjenja datum rodjenja novog baletskog igraca kao Date vrednost.
     * @param email email novog baletskog igraca kao String vrednost.
     * @param brojTelefona broj telefona novog baletskog igraca kao String vrednost.
     * @param brojTelefonaRoditelja broj telefona roditelja novog baletskog igraca kao String vrednost.
     * @param datumUpisa datum upisa novog baletskog igraca kao Date vrednost.
     * @param trenutnaClanarina trenutna clanarina novog baletskog igraca kao BigDecimal vrednost.
     * @param baletskaGrupa baletska grupa u kojoj ce trenirati novi baletski igrac.
     * @param listaUplata lista evidentiranih uplata novog baletskog igraca.
     */
    public BaletskiIgrac(Long baletskiIgracId, String ime, String prezime, Date datumRodjenja, String email, String brojTelefona, String brojTelefonaRoditelja, Date datumUpisa, BigDecimal trenutnaClanarina, BaletskaGrupa baletskaGrupa, List<Uplata> listaUplata) {
        this.baletskiIgracId = baletskiIgracId;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.brojTelefonaRoditelja = brojTelefonaRoditelja;
        this.datumUpisa = datumUpisa;
        this.trenutnaClanarina = trenutnaClanarina;
        this.baletskaGrupa = baletskaGrupa;
        this.listaUplata = listaUplata;
    }
    
    /**
     * Vraca ID baletskog igraca.
     * 
     * @return ID baletskog igraca kao Long.
     */
    public Long getBaletskiIgracId() {
        return baletskiIgracId;
    }
    
    /**
     * Postavlja vrednost atributa baletskiIgracId na novu unetu vrednost.
     * 
     * @param baletskiIgracId ID baletskog igraca kao Long.
     */
    public void setBaletskiIgracId(Long baletskiIgracId) {
        this.baletskiIgracId = baletskiIgracId;
    }
    
    /**
     * Vraca ime baletskog igraca.
     * 
     * @return ime baletskog igraca kao String.
     */
    public String getIme() {
        return ime;
    }
    
    /**
     * Postavlja vrednost atributa ime na novu unetu vrednost.
     * 
     * @param ime ime baletskog igraca kao String.
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
     * Vraca prezime baletskog igraca.
     * 
     * @return prezime baletskog igraca kao String.
     */
    public String getPrezime() {
        return prezime;
    }
    
    /**
     * Postavlja vrednost atributa prezime na novu unetu vrednost.
     * 
     * @param prezime prezime baletskog igraca kao String.
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
     * Vraca datum rodjenja baletskog igraca.
     * 
     * @return datum rodjenja baletskog igraca kao Date.
     */
    public Date getDatumRodjenja() {
        return datumRodjenja;
    }
    
    /**
     * Postavlja vrednost atributa datumRodjenja na novu unetu vrednost.
     * 
     * @param datumRodjenja datum rodjenja baletskog igraca kao Date.
     * @throws java.lang.RuntimeException ako je uneti datum rodjenja posle danasnjeg datuma
     * 
     */
    public void setDatumRodjenja(Date datumRodjenja) {
    	if(datumRodjenja.after(new java.util.Date())) {
    		throw new RuntimeException("Datum rodjenja ne sme biti posle danasnjeg datuma!");
    	}

    	this.datumRodjenja = datumRodjenja;
    }
    
    /**
     * Vraca email baletskog igraca.
     * 
     * @return email baletskog igraca kao String.
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Postavlja vrednost atributa email na novu unetu vrednost.
     * 
     * @param email email baletskog igraca kao String.
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
     * Vraca brojTelefona baletskog igraca.
     * 
     * @return broj telefona baletskog igraca kao String.
     */
    public String getBrojTelefona() {
        return brojTelefona;
    }
    
    /**
     * Postavlja vrednost atributa broj telefona na novu unetu vrednost.
     * 
     * @param brojTelefona broj telefona baletskog igraca kao String.
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
     * Vraca broj telefona roditelja baletskog igraca.
     * 
     * @return broj telefona roditelja baletskog igraca kao String.
     */
    public String getBrojTelefonaRoditelja() {
        return brojTelefonaRoditelja;
    }
    
    /**
     * Postavlja vrednost atributa brojTelefonaRoditelja na novu unetu vrednost.
     * 
     * @param brojTelefonaRoditelja broj telefona roditelja baletskog igraca kao String.
     * @throws java.lang.RuntimeException ako unet broj telefona roditelja nije u odgovarajucem formatu
     * 
     */
    public void setBrojTelefonaRoditelja(String brojTelefonaRoditelja) {
    	Pattern pattern = Pattern.compile("^(\\+)(3816)([0-9]){6,9}$");

    	if(!pattern.matcher(brojTelefona).matches()) {
    		throw new RuntimeException("Broj telefona nije u dobrom formatu!");
    	}
    	
        this.brojTelefonaRoditelja = brojTelefonaRoditelja;
    }
    
    /**
     * Vraca datum upisa baletskog igraca.
     * 
     * @return datum upisa baletskog igraca kao Date.
     */
    public Date getDatumUpisa() {
        return datumUpisa;
    }
    
    /**
     * Postavlja vrednost atributa datumUpisa na novu unetu vrednost.
     * 
     * @param datumUpisa datum upisa baletskog igraca kao Date.
     * 
     */
    public void setDatumUpisa(Date datumUpisa) {
        this.datumUpisa = datumUpisa;
    }
    
    /**
     * Vraca iznos trenutne clanarine baletskog igraca.
     * 
     * @return trenutna clanarina baletskog igraca kao BigDecimal.
     */
    public BigDecimal getTrenutnaClanarina() {
        return trenutnaClanarina;
    }
    
    /**
     * Postavlja vrednost atributa trenutnaClanarina na novu unetu vrednost.
     * 
     * @param trenutnaClanarina trenutna clanarina baletskog igraca kao BigDecimal.
     * @throws java.lang.RuntimeException ako uneta clanarina broj manji od 0
     * 
     */
    public void setTrenutnaClanarina(BigDecimal trenutnaClanarina) {
    	if(trenutnaClanarina.intValue() < 0) {
    		throw new RuntimeException("Iznos clanarine mora biti broj veci od 0!");
    	}
        this.trenutnaClanarina = trenutnaClanarina;
    }
    
    /**
     * Vraca grupu kojoj pripada baletski igrac.
     * 
     * @return grupa kojoj pripada baletski igrac.
     */
    public BaletskaGrupa getBaletskaGrupa() {
        return baletskaGrupa;
    }
    
    /**
     * Postavlja vrednost atributa baletskaGrupa na novu unetu vrednost.
     * 
     * @param baletskaGrupa baletska grupa kojoj ce pripadati baletski igrac.
     * 
     */
    public void setBaletskaGrupa(BaletskaGrupa baletskaGrupa) {
        this.baletskaGrupa = baletskaGrupa;
    }
    
    /**
     * Vraca listu uplata koje je izvrsio baletski igrac.
     * 
     * @return lista uplata baletskog igraca.
     */
    public List<Uplata> getListaUplata() {
        return listaUplata;
    }
    
    /**
     * Postavlja vrednost atributa listaUplata na novu unetu vrednost.
     * 
     * @param listaUplata lista izvrsenih uplata baletskog igraca.
     * 
     */
    public void setListaUplata(List<Uplata> listaUplata) {
    	if(listaUplata.isEmpty()) {
    		throw new RuntimeException("Baletski igrac mora imati barem jednu uplatu!");
    	}
        this.listaUplata = listaUplata;
    }
    
    /**
     * Vraca String koji predstavlja jedinstveni identifikator baletskog igraca.
     * 
     * @return Jedinstveni identifikator baletskog igraca kao String.
     */
    @Override
    public String toString() {
        return baletskiIgracId+"";    
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    
    /**
     * Poredi dva baletska igraca po jedinstvenim identifikatorima i vraca true ili false.
     * 
     * @return
	 * <ul>
	 * <li>true ako su oba objekta klase BaletskiIgrac i imaju isti ID.</li>
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
        final BaletskiIgrac other = (BaletskiIgrac) obj;
        if (!Objects.equals(this.baletskiIgracId, other.baletskiIgracId)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String vratiNazivTabele() {
        return "baletskiigrac";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "Ime, Prezime, DatumRodjenja, Email, BrojTelefona, BrojTelefonaRoditelja, DatumUpisa, TrenutnaClanarina, BaletskaGrupaId";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', '" + new java.sql.Date(datumRodjenja.getTime()) + "', '" + 
                     email + "', '" + brojTelefona + "', '"+brojTelefonaRoditelja+"', '" + new java.sql.Date(datumRodjenja.getTime()) + "', "+trenutnaClanarina+", " + baletskaGrupa.getBaletskaGrupaId();
    }

    @Override
    public String vratiUslovZaSelect() {
        return "BaletskiIgracId = " + baletskiIgracId;
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "Ime='" + ime + "', Prezime='" + prezime + "', DatumRodjenja='" + new java.sql.Date(datumRodjenja.getTime()) +
                "', Email='" + email + "', BrojTelefona='" + brojTelefona +
                "', BrojTelefonaRoditelja='" + brojTelefonaRoditelja+ "', DatumUpisa='" + new java.sql.Date(datumUpisa.getTime()) +"', TrenutnaClanarina="+ trenutnaClanarina;
    }

    @Override
    public String vratiUslovZaPromenuVrednostiAtributa() {
        return "BaletskiIgracId=" + baletskiIgracId;

    }
    
    /**
     * Vraca uslov koji se koristi prilikom pretrage baletskih igraca.
     * Pretraga se vrsi na osnovu toga da li je uneto samo ime, samo prezime ili i ime i prezime.
     * Na osnovu vrednosti ovih atributa formira se uslov za upit i vraca kao String vrednost.
     * 
     * @return uslov za pretragu baletskih igraca kao String.
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
        return upit;
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            BaletskiIgrac baletskiIgrac=new BaletskiIgrac();
            BaletskaGrupa baletskaGrupa = new BaletskaGrupa();
            baletskaGrupa.setBaletskaGrupaId(rs.getLong("BaletskaGrupaId"));
            baletskiIgrac.setBaletskaGrupa(baletskaGrupa);
            /*baletskaGrupa.setNazivGrupe(rs.getString("NazivGrupe"));
            baletskaGrupa.setTipGrupe(TipGrupe.valueOf(rs.getString("TipGrupe")));
            Date datumNastanka = new Date(rs.getDate("DatumNastanka").getTime());
            baletskaGrupa.setDatumNastanka(datumNastanka);
            baletskaGrupa.setKapacitet(rs.getInt("Kapacitet"));*/
            
            baletskiIgrac.setBaletskiIgracId(rs.getLong("BaletskiIgracId"));
            baletskiIgrac.setIme(rs.getString("Ime"));
            baletskiIgrac.setPrezime(rs.getString("Prezime"));
            Date datumRodjenja = new Date(rs.getDate("DatumRodjenja").getTime());
            baletskiIgrac.setDatumRodjenja(datumRodjenja);
            baletskiIgrac.setEmail(rs.getString("Email"));
            baletskiIgrac.setBrojTelefona(rs.getString("BrojTelefona"));
            baletskiIgrac.setBrojTelefonaRoditelja(rs.getString("BrojTelefonaRoditelja"));
            Date datumUpisa = new Date(rs.getDate("DatumUpisa").getTime());
            baletskiIgrac.setDatumUpisa(datumUpisa);
            baletskiIgrac.setTrenutnaClanarina(rs.getBigDecimal("TrenutnaClanarina"));
            lista.add(baletskiIgrac);
        }
        return lista;
    }

    @Override
    public String vratiUslovZaPretragu2() {
        return "BaletskaGrupaId = " + baletskaGrupa.getBaletskaGrupaId();
    }


}
