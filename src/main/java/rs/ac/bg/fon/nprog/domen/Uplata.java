package rs.ac.bg.fon.nprog.domen;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Uplata {
	
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
        this.redniBrojUplate = redniBrojUplate;
        this.iznosUplate = iznosUplate;
        this.datumUplate = datumUplate;
        this.mesec = mesec;
        this.godina = godina;
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
        this.redniBrojUplate = redniBrojUplate;
    }

    public BigDecimal getIznosUplate() {
        return iznosUplate;
    }

    public void setIznosUplate(BigDecimal iznosUplate) {
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
        this.mesec = mesec;
    }

    public String getGodina() {
        return godina;
    }

    public void setGodina(String godina) {
        this.godina = godina;
    }

    @Override
    public String toString() {
        return "Uplata{" + "baletskiIgrac=" + baletskiIgrac + ", redniBrojUplate=" + redniBrojUplate + ", iznosUplate=" + iznosUplate + ", datumUplate=" + datumUplate + ", mesec=" + mesec + ", godina=" + godina + '}';
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
}
