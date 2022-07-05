package rs.ac.bg.fon.nprog.domen;

import java.util.Objects;

public class Lokacija {
	
	private Long lokacijaId;
    private String nazivGrada;
    private String nazivUstanove;
    private String sala;

    public Lokacija() {
    }

    public Lokacija(Long lokacijaId, String nazivGrada, String nazivUstanove, String sala) {
        this.lokacijaId = lokacijaId;
        this.nazivGrada = nazivGrada;
        this.nazivUstanove = nazivUstanove;
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Long getLokacijaId() {
        return lokacijaId;
    }

    public void setLokacijaId(Long lokacijaId) {
        this.lokacijaId = lokacijaId;
    }

    public String getNazivGrada() {
        return nazivGrada;
    }

    public void setNazivGrada(String nazivGrada) {
        this.nazivGrada = nazivGrada;
    }

    public String getNazivUstanove() {
        return nazivUstanove;
    }

    public void setNazivUstanove(String nazivUstanove) {
        this.nazivUstanove = nazivUstanove;
    }

    @Override
    public String toString() {
        return nazivUstanove+" "+nazivGrada;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Lokacija other = (Lokacija) obj;
        if (!Objects.equals(this.lokacijaId, other.lokacijaId)) {
            return false;
        }
        return true;
    }
}
