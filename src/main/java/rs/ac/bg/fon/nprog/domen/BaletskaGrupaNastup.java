package rs.ac.bg.fon.nprog.domen;

import java.util.Objects;

public class BaletskaGrupaNastup {
	
	private BaletskaGrupa baletskaGrupaId;
    private Nastup nastupId;

    public BaletskaGrupaNastup() {
    }

    public BaletskaGrupaNastup(BaletskaGrupa baletskaGrupaId, Nastup nastupId) {
        this.baletskaGrupaId = baletskaGrupaId;
        this.nastupId = nastupId;
    }

    public Nastup getNastupId() {
        return nastupId;
    }

    public void setNastupId(Nastup nastupId) {
        this.nastupId = nastupId;
    }

    public BaletskaGrupa getBaletskaGrupaId() {
        return baletskaGrupaId;
    }

    public void setBaletskaGrupaId(BaletskaGrupa baletskaGrupaId) {
        this.baletskaGrupaId = baletskaGrupaId;
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
        final BaletskaGrupaNastup other = (BaletskaGrupaNastup) obj;
        if (!Objects.equals(this.baletskaGrupaId, other.baletskaGrupaId)) {
            return false;
        }
        if (!Objects.equals(this.nastupId, other.nastupId)) {
            return false;
        }
        return true;
    }
}
