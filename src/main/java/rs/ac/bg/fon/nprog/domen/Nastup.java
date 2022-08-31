package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Klasa koja predstavlja nastup baletske grupe. 
 * Ova klasa implementira interfejs ApstraktniDomenskiObjekat u odnosu na tabelu nastup u bazi podataka.
 * Takodje,implementira interfejs Serializiable zbog prolaza kroz mrezu.
 * 
 * Nastup moze biti jednog od tri tipa: koncert, takmicenje, karneval
 * Nastup se odrzava na jednoj od postojecih lokacija.
 * 
 * Nastup takodje ima i svoj jedinstveni identifikator koji ga jedinstveno identifikuje i datum 
 * odrzavanja nastupa
 * 
 * @author Dragica Ljubisavljevic
 * @version 1.0
 *
 */
public class Nastup implements Serializable,ApstraktniDomenskiObjekat{
	
	/**
	 * ID nastupa kao Long vrednost.
	 */
	private Long nastupId;
	/**
     * Datum nastupa baletske grupe tipa Date. 
     */
    private Date datumVremeNastupa;
    /**
     * Tip nastupa kao enum TipNastupa.
     */
    private TipNastupa tipNastupa;
    /**
     * Lokacija na kojoj ce se nastup odrzati.
     */
    private Lokacija lokacija;
    
    /**
     * Konstruktor koji inicijalizuje objekat klase Nastup.
     */
    public Nastup() {
    }
    
    /**
     * Konstruktor koji inicijalizuje objekat klase Nastup i postavlja prosledjene vrednosti njenim atributima. 
     * 
     * @param nastupId novi ID nastupa kao Long vrednost.
     * @param datumVremeNastupa datum zakazanog nastupa tipa Date.
     * @param tipNastupa tip zakazanog nastupa.
     * @param lokacija lokacija zakazanog nastupa.
     */
    public Nastup(Long nastupId, Date datumVremeNastupa, TipNastupa tipNastupa, Lokacija lokacija) {
        this.nastupId = nastupId;
        setDatumVremeNastupa(datumVremeNastupa);
        this.tipNastupa = tipNastupa;
        this.lokacija = lokacija;
    }
    
    /**
     * Vraca ID nastupa.
     * 
     * @return ID nastupa kao Long.
     */
    public Long getNastupId() {
        return nastupId;
    }
    
    /**
     * Postavlja vrednost atributa nastupId na novu unetu vrednost.
     * 
     * @param nastupId ID nastupa kao Long.
     */
    public void setNastupId(Long nastupId) {
        this.nastupId = nastupId;
    }
    
    /**
     * Vraca datum nastupa baletske grupe.
     * 
     * @return datum nastupa baletske grupe kao Date.
     */
    public Date getDatumVremeNastupa() {
        return datumVremeNastupa;
    }
    
    /**
     * Postavlja vrednost atributa datumVremeNastupa na novu unetu vrednost.
     * 
     * @param datumVremeNastupa datum za koji se zakazuje nastup baletske grupe kao Date.
     * @throws java.lang.RuntimeException ako je uneti datumNastupa pre danasnjeg datuma
     */
    public void setDatumVremeNastupa(Date datumVremeNastupa) {
    	if(datumVremeNastupa.before(new java.util.Date())) {
    		throw new RuntimeException("Datum nastupa mora biti posle danasnjeg datuma!");
    	}
        this.datumVremeNastupa = datumVremeNastupa;
    }
    
    /**
     * Vraca tip nastupa baletske grupe.
     * 
     * @return tip nastupa baletske grupe kao vrednost enuma TipNastupa.
     */
    public TipNastupa getTipNastupa() {
        return tipNastupa;
    }
    
    /**
     * Postavlja vrednost atributa tipNastupa na novu unetu vrednost.
     * 
     * @param tipNastupa tip nastupa baletske grupe kao vrednost enuma TipNastupa.
     */
    public void setTipNastupa(TipNastupa tipNastupa) {
        this.tipNastupa = tipNastupa;
    }
    
    /**
     * Vraca lokaciju na kojoj ce se odrzati nastup baletske grupe.
     * 
     * @return lokacija odrzavanja nastupa baletske grupe.
     */
    public Lokacija getLokacija() {
        return lokacija;
    }
    
    /**
     * Postavlja vrednost atributa lokacija na novu unetu vrednost.
     * 
     * @param lokacija lokacija na kojoj ce baletska grupa odrzati nastup
     */
    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }
    
    /**
     * Vraca String koji vraca osnovne informacije o nastupu, datum, tip i lokaciju odrzavanja.
     * 
     * @return datum, tip i lokacija nastupa kao String.
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        return "datumNastupa=" + datumVremeNastupa + ", tipNastupa=" + tipNastupa + ", lokacija=" + lokacija;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }
    
    /**
     * Poredi dva nastupa po jedinstvenim identifikatorima i vraca true ili false.
     * 
     * @return
	 * <ul>
	 * <li>true ako su oba objekta klase Nastup i imaju isti ID.</li>
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
        final Nastup other = (Nastup) obj;
        if (!Objects.equals(this.nastupId, other.nastupId)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String vratiNazivTabele() {
        return "Nastup";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
      return "DatumVremeNastupa, TipNastupa, Lokacija";
    }

    @Override
    public String vratiVrednostiZaInsert() {
      return "'" + new java.sql.Date(datumVremeNastupa.getTime()) + "', '" + tipNastupa.toString() + "', " +(lokacija == null ? null : lokacija.getLokacijaId());    }

    @Override
    public String vratiUslovZaSelect() {
       return "NastupI = " + nastupId;

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
        List<ApstraktniDomenskiObjekat> lista=new ArrayList<>();
        while(rs.next()){
            Nastup nastup=new Nastup();
            
            Lokacija l=new Lokacija();
            l.setLokacijaId(rs.getLong("Lokacija"));
            nastup.setLokacija(l);
            
            nastup.setNastupId(rs.getLong("NastupI"));
            nastup.setDatumVremeNastupa(new Date(rs.getDate("DatumVremeNastupa").getTime()));
            nastup.setTipNastupa(TipNastupa.valueOf(rs.getString("TipNastupa")));
            
            lista.add(nastup);
        }
        return lista;
    }

    @Override
    public String vratiUslovZaPretragu2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
