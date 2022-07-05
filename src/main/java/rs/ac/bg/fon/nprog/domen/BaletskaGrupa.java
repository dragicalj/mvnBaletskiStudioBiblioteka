package rs.ac.bg.fon.nprog.domen;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BaletskaGrupa {
	
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
}
