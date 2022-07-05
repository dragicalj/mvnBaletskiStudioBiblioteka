package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public interface ApstraktniDomenskiObjekat extends Serializable{
	
	public String vratiNazivTabele();
    
    public String vratiNaziveKolonaZaInsert();

    public String vratiVrednostiZaInsert();
    
    public String vratiUslovZaSelect();
    
    public String postaviVrednostiAtributa();
    
    public String vratiUslovZaPromenuVrednostiAtributa();
    
    public String vratiUslovZaPretragu();
    
    public String vratiUslovZaPretragu2();

    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet resultSet) throws Exception;
}
