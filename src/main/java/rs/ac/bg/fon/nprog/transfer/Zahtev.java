package rs.ac.bg.fon.nprog.transfer;

import java.io.Serializable;

public class Zahtev implements Serializable{
	
	private int operacija;
    private Object argument;

    public Zahtev(int operation, Object argument) {
        this.operacija = operation;
        this.argument = argument;
    }

    public Object getArgument() {
        return argument;
    }

    public int getOperacija() {
        return operacija;
    }
}
