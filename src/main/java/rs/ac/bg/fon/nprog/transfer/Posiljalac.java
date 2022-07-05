package rs.ac.bg.fon.nprog.transfer;

import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Posiljalac {
	
	 private Socket socket;

	    public Posiljalac(Socket socket) {
	        this.socket = socket;
	    }
	    
	    public void posalji(Object object){
	        try{
	            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
	            out.writeObject(object);
	            out.flush();
	        }catch(Exception e){
	            e.printStackTrace();
	           // throw new Exception("Error sending object!\n" + e.getMessage());
	        }
	    }
}
