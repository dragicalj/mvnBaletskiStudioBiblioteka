package rs.ac.bg.fon.nprog.transfer;

import java.io.ObjectInputStream;
import java.net.Socket;

public class Primalac {
	
	private Socket socket;

    public Primalac(Socket socket) {
        this.socket = socket;
    }
    
    public Object primi() throws Exception{
        try{
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Greska kod prijema objekta:\n" + e.getMessage());
        }
    }
}
