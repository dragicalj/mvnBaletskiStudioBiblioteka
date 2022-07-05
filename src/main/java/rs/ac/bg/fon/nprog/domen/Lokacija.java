package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lokacija implements Serializable, ApstraktniDomenskiObjekat{
	
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
    
    @Override
    public String vratiNazivTabele() {
        return "Lokacija";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "NazivGrada, NazivUstanove, Sala";    
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + nazivGrada + "', '" + nazivUstanove + "', '" + sala + "'";
    }

    @Override
    public String vratiUslovZaSelect() {
        return "LokacijaId = " + lokacijaId;
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
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Lokacija lokacija = new Lokacija();
            lokacija.setLokacijaId(rs.getLong("LokacijaId"));
            lokacija.setNazivGrada(rs.getString("NazivGrada"));
            lokacija.setNazivUstanove(rs.getString("NazivUstanove"));
            lokacija.setSala(rs.getString("Sala"));

            lista.add(lokacija);
        }
        return lista;
    }

    @Override
    public String vratiUslovZaPretragu2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
