package rs.ac.bg.fon.nprog.domen;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Nastup {
	
	private Long nastupId;
    private Date datumVremeNastupa;
    private TipNastupa tipNastupa;
    private Lokacija lokacija;

    public Nastup() {
    }

    public Nastup(Long nastupId, Date datumVremeNastupa, TipNastupa tipNastupa, Lokacija lokacija) {
        this.nastupId = nastupId;
        this.datumVremeNastupa = datumVremeNastupa;
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

}
