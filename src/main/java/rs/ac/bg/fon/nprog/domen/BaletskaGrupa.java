package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Klasa koja predstavlja baletsku grupu u baletskom studiju. 
 * Ova klasa implementira interfejs ApstraktniDomenskiObjekat u odnosu na tabelu baletskagrupa u bazi podataka.
 * Takodje,implementira interfejs Serializiable zbog prolaza kroz mrezu.
 * 
 * Baletska grupa ima svoj jedinstveni identifikator koji je jedinstveno identifikuje, naziv grupe,
 * tip grupe koji moze biti Mini, Junior, Senior, datum nastanka grupe, kapacitet koji predstavlja
 * maksimalan broj clanova grupe, koreografa baletske grupe iz baletskog studija i
 * listu njenih zakazanih nastupa
 * 
 * @author Dragica Ljubisavljevic
 * @version 1.0
 *
 */
public class BaletskaGrupa implements Serializable,ApstraktniDomenskiObjekat {
		
		/**
		 * ID baletske grupe kao Long vrednost.
		 */
	 	private Long baletskaGrupaId;
	 	/**
	 	 * Naziv baletske grupe kao String.
	 	 */
	    private String nazivGrupe;
	    /**
	     * Tip baletske grupe kao enum TipGrupe.
	     */
	    private TipGrupe tipGrupe;
	    /**
	     * Datum nastanka baletske grupe tipa Date. 
	     */
	    private Date datumNastanka;
	    /**
	     * Kapacitet baletske grupe kao int.
	     */
	    private int kapacitet;
	    /**
	     * Koreograf baletske grupe tipa klase Koreograf.
	     */
	    private Koreograf koreograf;
	    //private List<Nastup> listaNastupa;
	    /**
	     * Lista zakazanih nastupa konkretne baletske grupe.
	     */
	    private List<BaletskaGrupaNastup> listaNastupa;
	    
	    /**
	     * Konstruktor koji inicijalizuje objekat klase BaletskaGrupa.
	     */
	    public BaletskaGrupa() {
	    }
	    
	    /**
	     * Konstruktor koji inicijalizuje objekat klase BaletskaGrupa i postavlja prosledjene vrednosti njenim atributima. 
	     * 
	     * @param baletskaGrupaId novi ID baletske grupe kao Long vrednost.
	     * @param nazivGrupe novi naziv baletske grupe kao String vrednost.
	     * @param tipGrupe novi tip baletske grupe tipa enuma TipGrupe.
	     * @param datumNastanka novi datum nastanka baletske grupe tipa Date.
	     * @param kapacitet novi kapacitet baletske grupe kao int vrednost.
	     * @param koreograf novi koreograf baletske grupe tipa klase Koreograf.
	     * @param listaNastupa lista zakazanih nastupa baletske grupe.
	     */
	    public BaletskaGrupa(Long baletskaGrupaId, String nazivGrupe, TipGrupe tipGrupe, Date datumNastanka, int kapacitet, Koreograf koreograf, List<BaletskaGrupaNastup> listaNastupa) {
	        this.baletskaGrupaId = baletskaGrupaId;
	        setNazivGrupe(nazivGrupe);
	        setTipGrupe(tipGrupe);
	        setDatumNastanka(datumNastanka);;
	        setKapacitet(kapacitet);
	        this.koreograf = koreograf;
	        this.listaNastupa = listaNastupa;
	    }
	    
	    /**
	     * Vraca String koji predstavlja naziv baletske grupe.
	     * 
	     * @return naziv baletske grupe kao String.
	     */
	    @Override
	    public String toString() {
	        return nazivGrupe;
	    }
	    
	    @Override
	    public int hashCode() {
	        int hash = 7;
	        return hash;
	    }
	    
	    /**
	     * Poredi dve baletske grupe po jedinstvenim identifikatorima i vraca true ili false.
	     * 
	     * @return
		 * <ul>
		 * <li>true ako su oba objekta klase BaletskaGrupa i imaju isti ID.</li>
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
	        final BaletskaGrupa other = (BaletskaGrupa) obj;
	        if (!Objects.equals(this.baletskaGrupaId, other.baletskaGrupaId)) {
	            return false;
	        }
	        return true;
	    }
	    
	    @Override
	    public String vratiNazivTabele() {
	        return "baletskagrupa";
	    }

	    @Override
	    public String vratiNaziveKolonaZaInsert() {
	        return "NazivGrupe, TipGrupe, DatumNastanka, Kapacitet, KoreografId";
	    }

	    @Override
	    public String vratiVrednostiZaInsert() {
	      return "'" + nazivGrupe + "', '" + tipGrupe.toString() + "', '"+new java.sql.Date(new Date().getTime()) + "', " +kapacitet+","+(koreograf == null ? null : koreograf.getKoreografId());    }


	    @Override
	    public String vratiUslovZaSelect() {
	        return "BaletskaGrupaId = " + baletskaGrupaId;
	    }

	    @Override
	    public String postaviVrednostiAtributa() {
	        return "NazivGrupe='" + nazivGrupe + "', TipGrupe='" + tipGrupe + "', DatumNastanka='" + new java.sql.Date(datumNastanka.getTime()) +
	                "', Kapacitet=" + kapacitet+",KoreografId="+koreograf.getKoreografId();
	    }
	    
	    @Override
	    public String vratiUslovZaPromenuVrednostiAtributa() {
	        return "BaletskaGrupaId=" + baletskaGrupaId;

	    }
	    
	    @Override
	    public String vratiUslovZaPretragu() {
	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }

	    @Override
	    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
	        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
	        while (rs.next()) {
	            BaletskaGrupa baletskaGrupa = new BaletskaGrupa();
	            Koreograf koreograf=new Koreograf();
	            koreograf.setKoreografId(rs.getLong("KoreografId"));
	           /* koreograf.setIme(rs.getString("Ime"));
	            koreograf.setPrezime(rs.getString("Prezime"));
	            Date datumRodjenja = new Date(rs.getDate("DatumRodjenja").getTime());
	            koreograf.setDatumRodjenja(datumRodjenja);
	            koreograf.setEmail(rs.getString("Email"));
	            koreograf.setBrojTelefona(rs.getString("BrojTelefona"));
	            koreograf.setSpecijalizovanost(rs.getString("Specijalizovanost"));*/
	            baletskaGrupa.setKoreograf(koreograf);
	            
	            baletskaGrupa.setBaletskaGrupaId(rs.getLong("BaletskaGrupaId"));
	            baletskaGrupa.setNazivGrupe(rs.getString("NazivGrupe"));
	            baletskaGrupa.setTipGrupe(TipGrupe.valueOf(rs.getString("TipGrupe")));
	            Date datumNastanka = new Date(rs.getDate("DatumNastanka").getTime());
	            baletskaGrupa.setDatumNastanka(datumNastanka);
	            baletskaGrupa.setKapacitet(rs.getInt("Kapacitet"));
	            lista.add(baletskaGrupa);
	        }
	        return lista;
	    }
	    
	    /**
	     * Vraca ID baletske grupe.
	     * 
	     * @return ID baletske grupe kao Long.
	     */
	    public Long getBaletskaGrupaId() {
	        return baletskaGrupaId;
	    }
	    /**
	     * Postavlja vrednost atributa baletskaGrupaId na novu unetu vrednost.
	     * 
	     * @param baletskaGrupaId ID baletske grupe kao Long.
	     */
	    public void setBaletskaGrupaId(Long baletskaGrupaId) {
	        this.baletskaGrupaId = baletskaGrupaId;
	    }
	    
	    /**
	     * Vraca naziv baletske grupe.
	     * 
	     * @return naziv baletske grupe kao String.
	     */
	    public String getNazivGrupe() {
	        return nazivGrupe;
	    }
	    
	    /**
	     * Postavlja vrednost atributa nazivGrupe na novu unetu vrednost.
	     * 
	     * @param nazivGrupe naziv grupe kao String.
	     * @throws java.lang.NullPointerException ako je unet naziv grupe null
	     * 
	     */
	    public void setNazivGrupe(String nazivGrupe) {
	    	if(nazivGrupe==null) {
	    		throw new NullPointerException("Naziv ne sme biti null!");
	    	}
	        this.nazivGrupe = nazivGrupe;
	    }
	    
	    /**
	     * Vraca tip baletske grupe.
	     * 
	     * @return tip baletske grupe kao enum TipGrupe.
	     */
	    public TipGrupe getTipGrupe() {
	        return tipGrupe;
	    }
	    
	    /**
	     * Postavlja vrednost atributa tipGrupe na novu unetu vrednost.
	     * 
	     * @param tipGrupe tip baletske grupe kao enum TipGrupe.
	     */
	    public void setTipGrupe(TipGrupe tipGrupe) {
	        this.tipGrupe = tipGrupe;
	    }
	    
	    /**
	     * Vraca datum nastanka baletske grupe.
	     * 
	     * @return datum nastanka baletske grupe kao Date.
	     */
	    public Date getDatumNastanka() {
	        return datumNastanka;
	    }
	    
	    /**
	     * Postavlja vrednost atributa datumNastanka na novu unetu vrednost.
	     * 
	     * @param datumNastanka datum nastanka baletske grupe kao Date.
	     */
	    public void setDatumNastanka(Date datumNastanka) {
	        this.datumNastanka = datumNastanka;
	    }
	    
	    /**
	     * Vraca kapacitet baletske grupe.
	     * 
	     * @return kapacitet baletske grupe kao int.
	     */
	    public int getKapacitet() {
	        return kapacitet;
	    }
	    
	    /**
	     * Postavlja vrednost atributa kapacitet na novu unetu vrednost.
	     * 
	     * @param nazivGrupe naziv grupe kao String.
	     * @throws java.lang.RuntimeException ako je unet kapacitet manji od 0 ili veci od 50
	     * 
	     */
	    public void setKapacitet(int kapacitet) {
	    	if(kapacitet <= 0 || kapacitet>50) {
	    		throw new RuntimeException("Kapaciter grupe ne sme biti broj manji od 0 i veci od 50");
	    	}
	        this.kapacitet = kapacitet;
	    }
	    
	    /**
	     * Vraca koreografa baletske grupe.
	     * 
	     * @return koreograf baletske grupe.
	     */
	    public Koreograf getKoreograf() {
	        return koreograf;
	    }
	    
	    /**
	     * Postavlja vrednost atributa koreograf na novu unetu vrednost.
	     * 
	     * @param koreograf koreograf baletske grupe
	     */
	    public void setKoreograf(Koreograf koreograf) {
	        this.koreograf = koreograf;
	    }
	    
	    /**
	     * Vraca listu nastupa baletske grupe.
	     * 
	     * @return lista nastupa baletske grupe.
	     */
	    public List<BaletskaGrupaNastup> getListaNastupa() {
	        return listaNastupa;
	    }
	    
	    /**
	     * Postavlja vrednost atributa listaNastupa na novu prosledjenu listu nastupa.
	     * 
	     * @param listaNastupa lista nastupa baletske grupe.
	     */
	    public void setListaNastupa(List<BaletskaGrupaNastup> listaNastupa) {
	        this.listaNastupa = listaNastupa;
	    }

	    @Override
	    public String vratiUslovZaPretragu2() {
	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }
	    
	   
}
