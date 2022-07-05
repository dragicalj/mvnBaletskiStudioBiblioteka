package rs.ac.bg.fon.nprog.transfer;

import java.io.Serializable;

public class Odgovor implements Serializable {
	
	private TipOdgovora tipOdgovora;
    private Object rezultat;
    private Exception exception;

    public Odgovor() {
    }

    public TipOdgovora getTipOdgovora() {
        return tipOdgovora;
    }

    public void setTipOdgovora(TipOdgovora tipOdgovora) {
        this.tipOdgovora = tipOdgovora;
    }

    public Object getRezultat() {
        return rezultat;
    }

    public void setRezultat(Object rezultat) {
        this.rezultat = rezultat;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
