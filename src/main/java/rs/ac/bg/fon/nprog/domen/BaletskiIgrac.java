package rs.ac.bg.fon.nprog.domen;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BaletskiIgrac {
	
	private Long baletskiIgracId;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String email;
    private String brojTelefona;
    private String brojTelefonaRoditelja;
    private Date datumUpisa;
    private BigDecimal trenutnaClanarina;
    private BaletskaGrupa baletskaGrupa;
    private List<Uplata> listaUplata;

    public BaletskiIgrac() {
        listaUplata=new ArrayList<>();
    }

    public BaletskiIgrac(Long baletskiIgracId, String ime, String prezime, Date datumRodjenja, String email, String brojTelefona, String brojTelefonaRoditelja, Date datumUpisa, BigDecimal trenutnaClanarina, BaletskaGrupa baletskaGrupa, List<Uplata> listaUplata) {
        this.baletskiIgracId = baletskiIgracId;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.brojTelefonaRoditelja = brojTelefonaRoditelja;
        this.datumUpisa = datumUpisa;
        this.trenutnaClanarina = trenutnaClanarina;
        this.baletskaGrupa = baletskaGrupa;
        this.listaUplata = listaUplata;
    }

    public Long getBaletskiIgracId() {
        return baletskiIgracId;
    }

    public void setBaletskiIgracId(Long baletskiIgracId) {
        this.baletskiIgracId = baletskiIgracId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getBrojTelefonaRoditelja() {
        return brojTelefonaRoditelja;
    }

    public void setBrojTelefonaRoditelja(String brojTelefonaRoditelja) {
        this.brojTelefonaRoditelja = brojTelefonaRoditelja;
    }

    public Date getDatumUpisa() {
        return datumUpisa;
    }

    public void setDatumUpisa(Date datumUpisa) {
        this.datumUpisa = datumUpisa;
    }

    public BigDecimal getTrenutnaClanarina() {
        return trenutnaClanarina;
    }

    public void setTrenutnaClanarina(BigDecimal trenutnaClanarina) {
        this.trenutnaClanarina = trenutnaClanarina;
    }

    public BaletskaGrupa getBaletskaGrupa() {
        return baletskaGrupa;
    }

    public void setBaletskaGrupa(BaletskaGrupa baletskaGrupa) {
        this.baletskaGrupa = baletskaGrupa;
    }

    public List<Uplata> getListaUplata() {
        return listaUplata;
    }

    public void setListaUplata(List<Uplata> listaUplata) {
        this.listaUplata = listaUplata;
    }

    @Override
    public String toString() {
        return baletskiIgracId+"";    
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
        final BaletskiIgrac other = (BaletskiIgrac) obj;
        if (!Objects.equals(this.baletskiIgracId, other.baletskiIgracId)) {
            return false;
        }
        return true;
    }

}
