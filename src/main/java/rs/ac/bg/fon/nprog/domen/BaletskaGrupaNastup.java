package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Klasa koja predstavlja agregaciju izmedju domenskih objekata BaletksaGrupa i Nastup. 
 * Ova klasa implementira interfejs ApstraktniDomenskiObjekat u odnosu na tabelu grupanastup u bazi podataka.
 * Takodje,implementira interfejs Serializiable zbog prolaza kroz mrezu.
 * 
 * Jedinstveno je identifikuju identifikatori baletske grupe i nastupa.
 * 
 * Jedna baletska grupa moze imati vise nastupa, a na jednom nastupu moze nastupati vise baletskih grupa.
 * 
 * @author Dragica Ljubisavljevic
 * @version 1.0
 *
 */
public class BaletskaGrupaNastup implements Serializable,ApstraktniDomenskiObjekat{
	
	/**
	 * ID baletske grupe tipa BaletskaGrupa.
	 */
	private BaletskaGrupa baletskaGrupaId;
	/**
	 * ID nastupa tipa Nastup.
	 */
    private Nastup nastupId;
    
    /**
     * Konstruktor koji inicijalizuje objekat klase BaletskaGrupaNastup.
     */
    public BaletskaGrupaNastup() {
    }
    
    /**
	 * Konstruktor koji inicijalizuje objekat klase BaletskaGrupaNastup i postavlja prosledjene vrednosti njenim atributima. 
     *
     * @param baletskaGrupaId nova baletska grupa.
     * @param nastupId novi nastup.
     */
    public BaletskaGrupaNastup(BaletskaGrupa baletskaGrupaId, Nastup nastupId) {
        this.baletskaGrupaId = baletskaGrupaId;
        this.nastupId = nastupId;
    }
    
    /**
     * Vraca nastup.
     * 
     * @return nastup tipa Nastup.
     */
    public Nastup getNastupId() {
        return nastupId;
    }
    
    /**
     * Postavlja vrednost atributa baletskaGrupaId na novu unetu vrednost.
     * 
     * @param nastupId nastup tipa Nastup
     */
    public void setNastupId(Nastup nastupId) {
        this.nastupId = nastupId;
    }
    
    /**
     * Vraca baletsku grupu.
     * 
     * @return baletska grupa tipa BaletskaGrupa.
     */
    public BaletskaGrupa getBaletskaGrupaId() {
        return baletskaGrupaId;
    }
    
    /**
     * Postavlja vrednost atributa baletskaGrupaId na novu unetu vrednost.
     * 
     * @param baletskaGrupaId baletska grupa tipa BaletskaGrupa.
     */
    public void setBaletskaGrupaId(BaletskaGrupa baletskaGrupaId) {
        this.baletskaGrupaId = baletskaGrupaId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    
    /**
     * Poredi dva nastupa baletske grupe po jedinstvenim identifikatorima baletske grupe i nastupa i vraca true ili false.
     * 
     * @return
	 * <ul>
	 * <li>true ako su oba objekta klase BaletskaGrupaNastup i imaju ista oba identifikatora.</li>
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
        final BaletskaGrupaNastup other = (BaletskaGrupaNastup) obj;
        if (!Objects.equals(this.baletskaGrupaId, other.baletskaGrupaId)) {
            return false;
        }
        if (!Objects.equals(this.nastupId, other.nastupId)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String vratiNazivTabele() {
        return "grupanastup";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "BaletskaGrupaId, NastupId";

    }

    @Override
    public String vratiVrednostiZaInsert() {
        return baletskaGrupaId.getBaletskaGrupaId()+", "+nastupId.getNastupId();
    }

    @Override
    public String vratiUslovZaSelect() {
        return "BaletskaGrupaId = " + baletskaGrupaId.getBaletskaGrupaId() + " AND " + "NastupId = " + nastupId.getNastupId();

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
        return "BaletskaGrupaId= " + baletskaGrupaId.getBaletskaGrupaId();

    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            BaletskaGrupa baletskaGrupa = new BaletskaGrupa();
            BaletskaGrupaNastup grupaNastup = new BaletskaGrupaNastup();

            baletskaGrupa.setBaletskaGrupaId(rs.getLong("BaletskaGrupaId"));
            grupaNastup.setBaletskaGrupaId(baletskaGrupa);

            Nastup nastup = new Nastup();

            nastup.setNastupId(rs.getLong("NastupId"));
            /*nastup.setDatumVremeNastupa(rs.getDate("DatumVremeNastupa"));
            nastup.setTipNastupa(TipNastupa.valueOf(rs.getString("TipNastupa")));
            
            Lokacija lokacija=new Lokacija();
            lokacija.setLokacijaId(rs.getLong("LokacijaId"));
            lokacija.setNazivGrada(rs.getString("NazivGrada"));
            lokacija.setNazivUstanove(rs.getString("NazivUstanove"));
            lokacija.setSala(rs.getString("Sala"));*/

            //nastup.setLokacija(lokacija);
            grupaNastup.setNastupId(nastup);
            //System.out.println(grupaNastup.getNastupId().getNastupId());
            /*baletskiIgrac.setBaletskiIgracId(rs.getLong("BaletskiIgracId"));
            uplata.setBaletskiIgrac(baletskiIgrac);
            uplata.setRedniBrojUplate(rs.getInt("RedniBrojUplate"));
            uplata.setIznosUplate(rs.getBigDecimal("IznosUplate"));
            uplata.setDatumUplate(rs.getDate("DatumUplate"));
            uplata.setMesec(rs.getString("Mesec"));
            uplata.setGodina(rs.getString("Godina"));    */

            lista.add(grupaNastup);
            //System.out.println("lisa iz klase" + lista);
        }
        return lista;
    }
    /**
     * Vraca String koji sadrzi naziv baletske grupe i informacije o nastupu.
     * 
     * @return naziv baletske grupe i informacije o nastupu kao String.
     */
    @Override
    public String toString() {
        return baletskaGrupaId + " " + nastupId + ""; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaPretragu2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
