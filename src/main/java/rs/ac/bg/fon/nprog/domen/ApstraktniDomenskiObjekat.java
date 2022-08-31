package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;
/**
 * Interfejs koji daje specifikaciju operacija koje su neophodne za rad sa generickim upitima prilikom komunikacije sa bazom podataka.
 * 
 * Predstavlja visi nivo apstrakcije u odosu na sve domenske klase. 
 * 
 * @author Dragica Ljubisavljevic
 * @version 1.0
 *
 */
public interface ApstraktniDomenskiObjekat extends Serializable{
	
	/**
	 * Vraca naziv tabele u bazi podataka.
	 * 
	 * @return Naziv tabele kao String.
	 */
	public String vratiNazivTabele();
    /**
     * Vraca nazive kolona iz odgovarajuce tabele u bazi podataka. Samo nazive kolona koje treba popunjavati vrednostima prilikom kreiranja objekata.
     * 
     * @return Nazivi kolona iz tabele u bazi odvojeni zarezima kao jedan String.
     */
    public String vratiNaziveKolonaZaInsert();
    /**
     * Vraca unete vrednosti za atribute klase.
     * 
     * @return Vrednosti atributa klase odvojeni zarezima kao jedan String.
     */
    public String vratiVrednostiZaInsert();
    /**
     * Vraca uslov za pretragu na osnovu jedinstvenog identifikatora. 
     * Koristimo kada je potrebno da ucitamo odredjeni red iz baze podataka.
     * 
     * @return Uslov kao String.
     */
    public String vratiUslovZaSelect();
    /**
     * Vraca String koji sadrzi imena kolona u bazi podataka i unete vrednosti atributa klase. 
     * Koristimo kada je potrebno da promenimo vrednosti odredjenog reda u bazi podataka.
     * 
     * @return Imena kolona u bazi podatka i vrednosti na koje ih je potrebno postaviti kao String.
     */
    public String postaviVrednostiAtributa();
    /**
     * Vraca uslov na osnovu jedinstvenog identifikatora.
     * Koristimo kada je potrebno da promenimo vrednosti da bismo znali na koji red u bazi podataka se izmena odnosi. 
     * 
     * @return Uslov kao String.
     */
    public String vratiUslovZaPromenuVrednostiAtributa();
    
    public String vratiUslovZaPretragu();
    
    public String vratiUslovZaPretragu2();
    /**
     * Vraca listu objekata koja predstavlja ucitane redove iz baze podataka nakon izvrsavanja SQL upita.
     * Prolazi se redom po redovima, ucitavaju se podaci iz svakog reda baze podataka i postavljaju
     * na vrednosti atributa objekta koji se dodaje u listu.  
     * 
     * @param resultSet Objekat koji sadrzi podatke iz baze podataka nakon izvrsavanja SQL upita.
     * @return Lista objekata ucitanih na osnovu vrednosti u bazi podataka nakon izvrsavanja SQL upita.
     * @throws Exception ako dodje do greske prilikom ucitavanja podataka iz baze.
     */
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet resultSet) throws Exception;
}
