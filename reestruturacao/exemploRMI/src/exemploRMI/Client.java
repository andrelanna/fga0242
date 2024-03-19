package exemploRMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry(2020);
			Hello stub = (Hello) registry.lookup("Hello");
			String response = stub.sayHello();
			System.out.println("resposta: " + response);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
