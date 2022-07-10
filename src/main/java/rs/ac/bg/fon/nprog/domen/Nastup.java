package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Nastup implements Serializable,ApstraktniDomenskiObjekat{
	
	private Long nastupId;
    private Date datumVremeNastupa;
    private TipNastupa tipNastupa;
    private Lokacija lokacija;

    public Nastup() {
    }

    public Nastup(Long nastupId, Date datumVremeNastupa, TipNastupa tipNastupa, Lokacija lokacija) {
        this.nastupId = nastupId;
        setDatumVremeNastupa(datumVremeNastupa);
        this.tipNastupa = tipNastupa;
        this.lokacija = lokacija;
    }

    public Long getNastupId() {
        return nastupId;
    }

    public void setNastupId(Long nastupId) {
        this.nastupId = nastupId;
    }

    public Date getDatumVremeNastupa() {
        return datumVremeNastupa;
    }

    public void setDatumVremeNastupa(Date datumVremeNastupa) {
    	if(datumVremeNastupa.before(new java.util.Date())) {
    		throw new RuntimeException("Datum nastupa mora biti posle danasnjeg datuma!");
    	}
        this.datumVremeNastupa = datumVremeNastupa;
    }

    public TipNastupa getTipNastupa() {
        return tipNastupa;
    }

    public void setTipNastupa(TipNastupa tipNastupa) {
        this.tipNastupa = tipNastupa;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

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
