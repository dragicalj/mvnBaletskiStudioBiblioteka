package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Uplata implements Serializable,ApstraktniDomenskiObjekat{
	
	private BaletskiIgrac baletskiIgrac;
    private int redniBrojUplate;
    private BigDecimal iznosUplate;
    private Date datumUplate;
    private String mesec;
    private String godina;

    public Uplata() {
    }

    public Uplata(BaletskiIgrac baletskiIgrac, int redniBrojUplate, BigDecimal iznosUplate, Date datumUplate, String mesec, String godina) {
        this.baletskiIgrac = baletskiIgrac;
        setRedniBrojUplate(redniBrojUplate);
        setIznosUplate(iznosUplate);
        this.datumUplate = datumUplate;
        setMesec(mesec);
        setGodina(godina);
    }

    public BaletskiIgrac getBaletskiIgrac() {
        return baletskiIgrac;
    }

    public void setBaletskiIgrac(BaletskiIgrac baletskiIgrac) {
        this.baletskiIgrac = baletskiIgrac;
    }

    public int getRedniBrojUplate() {
        return redniBrojUplate;
    }

    public void setRedniBrojUplate(int redniBrojUplate) {
    	if(redniBrojUplate <= 0) {
    		throw new RuntimeException("Redni broj uplate mora biti veci od 0!");
    	}
        this.redniBrojUplate = redniBrojUplate;
    }

    public BigDecimal getIznosUplate() {
        return iznosUplate;
    }

    public void setIznosUplate(BigDecimal iznosUplate) {
    	if(iznosUplate.intValue() <= 0) {
    		throw new RuntimeException("Iznos uplate mora biti veci od 0!");
    	}
        this.iznosUplate = iznosUplate;
    }

    public Date getDatumUplate() {
        return datumUplate;
    }

    public void setDatumUplate(Date datumUplate) {
        this.datumUplate = datumUplate;
    }

    public String getMesec() {
        return mesec;
    }

    public void setMesec(String mesec) {
    	if(mesec == null) {
    		throw new NullPointerException("Mesec ne sme biti null");
    	}
        this.mesec = mesec;
    }

    public String getGodina() {
        return godina;
    }

    public void setGodina(String godina) {
    	if(godina == null) {
    		throw new NullPointerException("Godina ne sme biti null");
    	}
        this.godina = godina;
    }

    @Override
    public String toString() {
        return "Uplata{redniBrojUplate=" + redniBrojUplate + ", iznosUplate=" + iznosUplate +", mesec=" + mesec + ", godina=" + godina + '}';
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
