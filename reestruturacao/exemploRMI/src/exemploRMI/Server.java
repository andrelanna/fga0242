package exemploRMI;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello{
	int i = 0; 
	public String sayHello() throws RemoteException {
		System.out.println("Incoming call #" + i);
		i++;
		return "Hello World!";
	}
	
	public static void main(String[] args) {
		try {
			
			Server obj = new Server();
			Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
			
			//bind the remote object's stub in the registry
			Registry registry = LocateRegistry.createRegistry(2020);
			registry.bind("Hello", stub);
			
			System.err.println("Server ready");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
