package rs.ac.bg.fon.nprog.transfer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Primalac {
	
	private Socket socket;

    public Primalac(Socket socket) {
        this.socket = socket;
    }
    
    public Object primi() throws Exception{
    	ObjectInputStream in;
        try{
            in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        }catch(IOException e){
        	socket.close();
            e.printStackTrace();
            throw new Exception("Greska kod prijema objekta:\n" + e.getMessage());
        }
    }
}
