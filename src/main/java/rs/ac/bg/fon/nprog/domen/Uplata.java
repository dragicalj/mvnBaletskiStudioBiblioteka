package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Klasa koja predstavlja uplate clanarine baletskog igraca u baletskom studiju. 
 * Ova klasa implementira interfejs ApstraktniDomenskiObjekat u odnosu na tabelu uplata u bazi podataka.
 * Takodje,implementira interfejs Serializiable zbog prolaza kroz mrezu.
 * 
 * Uplate se odnose na jednog baletskog igraca. 
 * Svaku uplatu jedinstveno identifikuje ID baletskog igraca koji je izvrsio uplatu i redni broj
 * njegove uplate
 * 
 * Uplata takodje ima iznos koji je uplacen, datum kada je uplata izvrsena, mesec i godinu 
 * na koje se uplata clanarine odnosi
 * 
 * @author Dragica Ljubisavljevic
 * @version 1.0
 *
 */
public class Uplata implements Serializable,ApstraktniDomenskiObjekat{
	
	/**
	 * Baletski igrac koji je izvrsio uplatu.
	 */
	private BaletskiIgrac baletskiIgrac;
	/**
	 * Redni broj uplate kao int vrednost.
	 */
    private int redniBrojUplate;
    /**
     * Visina iznosa uplate koja je izvrsena kao BigDecimal vrednost.
     */
    private BigDecimal iznosUplate;
    /**
     * Datum kada je uplata izvrsena kao Date.
     */
    private Date datumUplate;
    /**
     * Mesec na koji se uplata clanarine odnosi kao String vrednost.
     */
    private String mesec;
    /**
    * Godina na koju se uplata clanarine odnosi kao String vrednost.
    */
    private String godina;
    
    /**
     * Konstruktor koji inicijalizuje objekat klase Uplata.
     */
    public Uplata() {
    }
    
    /**
     * Konstruktor koji inicijalizuje objekat klase Uplata i postavlja prosledjene vrednosti njenim atributima. 
     * 
     * @param baletskiIgrac baletski igrac koji je izvrsio uplatu.
     * @param redniBrojUplate redni broj uplate baletskog igraca kao int vrednost.
     * @param iznosUplate visina iznosa uplate kao BigDecimal vrednost.
     * @param datumUplate datum kada je uplata izvrsena kao Date vrednost.
     * @param mesec mesec na koji se uplata clanarine odnosi kao String vrednost.
     * @param godina godina na koju se uplata clanarine odnosi kao String vrednost.
     */
    public Uplata(BaletskiIgrac baletskiIgrac, int redniBrojUplate, BigDecimal iznosUplate, Date datumUplate, String mesec, String godina) {
        this.baletskiIgrac = baletskiIgrac;
        setRedniBrojUplate(redniBrojUplate);
        setIznosUplate(iznosUplate);
        this.datumUplate = datumUplate;
        setMesec(mesec);
        setGodina(godina);
    }
    
    /**
     * Vraca ID baletskog igraca koji je izvrsio uplatu clanarine.
     * 
     * @return ID baletskog igraca kao Long.
     */
    public BaletskiIgrac getBaletskiIgrac() {
        return baletskiIgrac;
    }
    
    /**
     * Postavlja vrednost atributa baletskiIgrac na novu unetu vrednost.
     * 
     * @param baletskiIgrac baletski igrac koji je izvrsio uplatu.
     */
    public void setBaletskiIgrac(BaletskiIgrac baletskiIgrac) {
        this.baletskiIgrac = baletskiIgrac;
    }
    
    /**
     * Vraca redni broj izvrsene uplate baletskog igraca.
     * 
     * @return ID baletskog igraca kao Long.
     */
    public int getRedniBrojUplate() {
        return redniBrojUplate;
    }
    
    /**
     * Postavlja vrednost atributa redniBrojUplate na novu unetu vrednost.
     * 
     * @param redniBrojUplate redni broj izvrsene uplate baletskog igraca kao int.
     * @throws java.lang.RuntimeException ako je unet redni broj manji od 0
     * 
     */
    public void setRedniBrojUplate(int redniBrojUplate) {
    	if(redniBrojUplate <= 0) {
    		throw new RuntimeException("Redni broj uplate mora biti veci od 0!");
    	}
        this.redniBrojUplate = redniBrojUplate;
    }
    
    /**
     * Vraca iznos izvrsene uplate baletskog igraca.
     * 
     * @return iznos uplate baletskog igraca kao BigDecimal.
     */
    public BigDecimal getIznosUplate() {
        return iznosUplate;
    }
    
    /**
     * Postavlja vrednost atributa iznosUplate na novu unetu vrednost.
     * 
     * @param iznosUplate iznos izvrsene uplate baletskog igraca kao BigDecimal.
     * @throws java.lang.RuntimeException ako je unet iznos uplate manji od 0
     * 
     */ 
    public void setIznosUplate(BigDecimal iznosUplate) {
    	if(iznosUplate.intValue() <= 0) {
    		throw new RuntimeException("Iznos uplate mora biti veci od 0!");
    	}
        this.iznosUplate = iznosUplate;
    }
    
    /**
     * Vraca datum izvrsenja uplate baletskog igraca.
     * 
     * @return datum uplate baletskog igraca kao Date.
     */
    public Date getDatumUplate() {
        return datumUplate;
    }
    
    /**
     * Postavlja vrednost atributa datumUplate na novu unetu vrednost.
     * 
     * @param datumUplate datum uplate baletskog igraca kao Date.
     * 
     */
    public void setDatumUplate(Date datumUplate) {
        this.datumUplate = datumUplate;
    }
    
    /**
     * Vraca mesec na koji se odnosi uplata clanarine baletskog igraca.
     * 
     * @return mesec na koji se odnosi uplata clanarine baletskog igraca kao String.
     */
    public String getMesec() {
        return mesec;
    }
    
    /**
     * Postavlja vrednost atributa mesec na novu unetu vrednost.
     * 
     * @param mesec mesec na koji se odnosi uplata clanarina baletskog igraca kao String.
     * @throws java.lang.NullPointerException ako je unet mesec null
     * 
     */
    public void setMesec(String mesec) {
    	if(mesec == null) {
    		throw new NullPointerException("Mesec ne sme biti null");
    	}
        this.mesec = mesec;
    }
    
    /**
     * Vraca godinu na koju se odnosi uplata clanarine baletskog igraca.
     * 
     * @return godina na koju se odnosi uplata clanarine baletskog igraca kao String.
     */
    public String getGodina() {
        return godina;
    }
    
    /**
     * Postavlja vrednost atributa godina na novu unetu vrednost.
     * 
     * @param godina godina na koju se odnosi uplata clanarina baletskog igraca kao String.
     * @throws java.lang.NullPointerException ako je uneta godina null
     * 
     */
    public void setGodina(String godina) {
    	if(godina == null) {
    		throw new NullPointerException("Godina ne sme biti null");
    	}
        this.godina = godina;
    }
    
    /**
     * Vraca String koji vraca osnovne informacije o uplati, redni broj uplate, iznos uplate i
     * mesec i godinu na koje se uplata clanarine odnosi
     * 
     * @return redni broj uplate, iznos, mesec i godinu kao String.
     */
    @Override
    public String toString() {
        return "Uplata{redniBrojUplate=" + redniBrojUplate + ", iznosUplate=" + iznosUplate +", mesec=" + mesec + ", godina=" + godina + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    
    /**
     * Poredi dve uplate po baletskom igracu i rednom broju uplate i vraca true ili false.
     * 
     * @return
	 * <ul>
	 * <li>true ako su oba objekta klase Uplata i imaju isti ID baletskog igraca i redni broj uplate.</li>
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
        final Uplata other = (Uplata) obj;
        if (this.redniBrojUplate != other.redniBrojUplate) {
            return false;
        }
        if (!Objects.equals(this.baletskiIgrac, other.baletskiIgrac)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String vratiNazivTabele() {
        return "uplata";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "BaletskiIgracId, RedniBrojUplate, IznosUplate, DatumUplate, Mesec, Godina";
    }

    @Override
    public String vratiVrednostiZaInsert() {
    return baletskiIgrac.getBaletskiIgracId()+","+redniBrojUplate + ", " + iznosUplate + ", '" + 
                new java.sql.Date(datumUplate.getTime()) + "', '" + mesec+"', '"+godina+"'";
    }

    @Override
    public String vratiUslovZaSelect() {
        return "BaletskiIgracId = " + baletskiIgrac.getBaletskiIgracId()+ " AND " + "RedniBrojUplate = " + redniBrojUplate;

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
            return "BaletskiIgracId= " + baletskiIgrac.getBaletskiIgracId();
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            BaletskiIgrac baletskiIgrac=new BaletskiIgrac();
            Uplata uplata=new Uplata();
            
            baletskiIgrac.setBaletskiIgracId(rs.getLong("BaletskiIgracId"));
            uplata.setBaletskiIgrac(baletskiIgrac);
            uplata.setRedniBrojUplate(rs.getInt("RedniBrojUplate"));
            uplata.setIznosUplate(rs.getBigDecimal("IznosUplate"));
            uplata.setDatumUplate(rs.getDate("DatumUplate"));
            uplata.setMesec(rs.getString("Mesec"));
            uplata.setGodina(rs.getString("Godina"));
            
                    

            lista.add(uplata);
        }
        return lista;
    }

    @Override
    public String vratiUslovZaPretragu2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
