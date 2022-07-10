package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class BaletskiIgrac implements Serializable, ApstraktniDomenskiObjekat{
	
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
    	if(ime == null) {
    		throw new NullPointerException("Ime ne sme biti null!");
    	}
    	if(ime.length() < 2) {
    		throw new RuntimeException("Ime mora imati vise od dva znaka!");
    	}
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
    	if(prezime == null) {
    		throw new NullPointerException("Prezime ne sme biti null!");
    	}
    	if(prezime.length() < 2) {
    		throw new RuntimeException("Prezime mora imati vise od dva znaka!");
    	}
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
    	if(datumRodjenja.after(new java.util.Date())) {
    		throw new RuntimeException("Datum rodjenja ne sme biti posle danasnjeg datuma!");
    	}

    	this.datumRodjenja = datumRodjenja;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
    	if(!email.contains("@")) {
    		throw new RuntimeException("Email adresa mora da sadrzi @!");
    	}
        this.email = email;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
    	Pattern pattern = Pattern.compile("^(\\+)(3816)([0-9]){6,9}$");

    	if(!pattern.matcher(brojTelefona).matches()) {
    		throw new RuntimeException("Broj telefona nije u dobrom formatu!");
    	}
    	
        this.brojTelefona = brojTelefona;
    }

    public String getBrojTelefonaRoditelja() {
        return brojTelefonaRoditelja;
    }

    public void setBrojTelefonaRoditelja(String brojTelefonaRoditelja) {
    	Pattern pattern = Pattern.compile("^(\\+)(3816)([0-9]){6,9}$");

    	if(!pattern.matcher(brojTelefona).matches()) {
    		throw new RuntimeException("Broj telefona nije u dobrom formatu!");
    	}
    	
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
    	if(trenutnaClanarina.intValue() < 0) {
    		throw new RuntimeException("Iznos clanarine mora biti broj veci od 0!");
    	}
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
    	if(listaUplata.isEmpty()) {
    		throw new RuntimeException("Baletski igrac mora imati barem jednu uplatu!");
    	}
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
    
    @Override
    public String vratiNazivTabele() {
        return "baletskiigrac";
    }

    @Override
    public String vratiNaziveKolonaZaInsert() {
        return "Ime, Prezime, DatumRodjenja, Email, BrojTelefona, BrojTelefonaRoditelja, DatumUpisa, TrenutnaClanarina, BaletskaGrupaId";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', '" + new java.sql.Date(datumRodjenja.getTime()) + "', '" + 
                     email + "', '" + brojTelefona + "', '"+brojTelefonaRoditelja+"', '" + new java.sql.Date(datumRodjenja.getTime()) + "', "+trenutnaClanarina+", " + baletskaGrupa.getBaletskaGrupaId();
    }

    @Override
    public String vratiUslovZaSelect() {
        return "BaletskiIgracId = " + baletskiIgracId;
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "Ime='" + ime + "', Prezime='" + prezime + "', DatumRodjenja='" + new java.sql.Date(datumRodjenja.getTime()) +
                "', Email='" + email + "', BrojTelefona='" + brojTelefona +
                "', BrojTelefonaRoditelja='" + brojTelefonaRoditelja+ "', DatumUpisa='" + new java.sql.Date(datumUpisa.getTime()) +"', TrenutnaClanarina="+ trenutnaClanarina;
    }

    @Override
    public String vratiUslovZaPromenuVrednostiAtributa() {
        return "BaletskiIgracId=" + baletskiIgracId;

    }

    @Override
    public String vratiUslovZaPretragu() {
        String upit="";
        if(!(ime.equals(""))){
            upit+="ime LIKE '" + ime+"' ";
        }
        if(!(prezime.equals("")) && !(ime.equals("")) ){
            upit+="AND prezime "+"LIKE '"+prezime+"' ";
        }
        if(!(prezime.equals("")) && ime.equals("") ){
            upit+="prezime "+"LIKE '"+prezime+"' ";
        }
        return upit;
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            BaletskiIgrac baletskiIgrac=new BaletskiIgrac();
            BaletskaGrupa baletskaGrupa = new BaletskaGrupa();
            baletskaGrupa.setBaletskaGrupaId(rs.getLong("BaletskaGrupaId"));
            baletskiIgrac.setBaletskaGrupa(baletskaGrupa);
            /*baletskaGrupa.setNazivGrupe(rs.getString("NazivGrupe"));
            baletskaGrupa.setTipGrupe(TipGrupe.valueOf(rs.getString("TipGrupe")));
            Date datumNastanka = new Date(rs.getDate("DatumNastanka").getTime());
            baletskaGrupa.setDatumNastanka(datumNastanka);
            baletskaGrupa.setKapacitet(rs.getInt("Kapacitet"));*/
            
            baletskiIgrac.setBaletskiIgracId(rs.getLong("BaletskiIgracId"));
            baletskiIgrac.setIme(rs.getString("Ime"));
            baletskiIgrac.setPrezime(rs.getString("Prezime"));
            Date datumRodjenja = new Date(rs.getDate("DatumRodjenja").getTime());
            baletskiIgrac.setDatumRodjenja(datumRodjenja);
            baletskiIgrac.setEmail(rs.getString("Email"));
            baletskiIgrac.setBrojTelefona(rs.getString("BrojTelefona"));
            baletskiIgrac.setBrojTelefonaRoditelja(rs.getString("BrojTelefonaRoditelja"));
            Date datumUpisa = new Date(rs.getDate("DatumUpisa").getTime());
            baletskiIgrac.setDatumUpisa(datumUpisa);
            baletskiIgrac.setTrenutnaClanarina(rs.getBigDecimal("TrenutnaClanarina"));
            lista.add(baletskiIgrac);
        }
        return lista;
    }

    @Override
    public String vratiUslovZaPretragu2() {
        return "BaletskaGrupaId = " + baletskaGrupa.getBaletskaGrupaId();
    }


}
