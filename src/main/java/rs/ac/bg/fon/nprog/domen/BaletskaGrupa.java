package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BaletskaGrupa implements Serializable,ApstraktniDomenskiObjekat {
	
	 	private Long baletskaGrupaId;
	    private String nazivGrupe;
	    private TipGrupe tipGrupe;
	    private Date datumNastanka;
	    private int kapacitet;
	    private Koreograf koreograf;
	    //private List<Nastup> listaNastupa;
	    private List<BaletskaGrupaNastup> listaNastupa;

	    public BaletskaGrupa() {
	    }

	    public BaletskaGrupa(Long baletskaGrupaId, String nazivGrupe, TipGrupe tipGrupe, Date datumNastanka, int kapacitet, Koreograf koreograf, List<BaletskaGrupaNastup> listaNastupa) {
	        this.baletskaGrupaId = baletskaGrupaId;
	        this.nazivGrupe = nazivGrupe;
	        this.tipGrupe = tipGrupe;
	        this.datumNastanka = datumNastanka;
	        this.kapacitet = kapacitet;
	        this.koreograf = koreograf;
	        this.listaNastupa = listaNastupa;
	    }
	    
	   
	    @Override
	    public String toString() {
	        return nazivGrupe;
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

	    public Long getBaletskaGrupaId() {
	        return baletskaGrupaId;
	    }

	    public void setBaletskaGrupaId(Long baletskaGrupaId) {
	        this.baletskaGrupaId = baletskaGrupaId;
	    }

	    public String getNazivGrupe() {
	        return nazivGrupe;
	    }

	    public void setNazivGrupe(String nazivGrupe) {
	        this.nazivGrupe = nazivGrupe;
	    }

	    public TipGrupe getTipGrupe() {
	        return tipGrupe;
	    }

	    public void setTipGrupe(TipGrupe tipGrupe) {
	        this.tipGrupe = tipGrupe;
	    }

	    public Date getDatumNastanka() {
	        return datumNastanka;
	    }

	    public void setDatumNastanka(Date datumNastanka) {
	        this.datumNastanka = datumNastanka;
	    }

	    public int getKapacitet() {
	        return kapacitet;
	    }

	    public void setKapacitet(int kapacitet) {
	        this.kapacitet = kapacitet;
	    }

	    public Koreograf getKoreograf() {
	        return koreograf;
	    }

	    public void setKoreograf(Koreograf koreograf) {
	        this.koreograf = koreograf;
	    }

	    public List<BaletskaGrupaNastup> getListaNastupa() {
	        return listaNastupa;
	    }

	    public void setListaNastupa(List<BaletskaGrupaNastup> listaNastupa) {
	        this.listaNastupa = listaNastupa;
	    }

	    @Override
	    public String vratiUslovZaPretragu2() {
	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }
	    
	   
}
