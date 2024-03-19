

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class ComputeEngine implements Compute {

	public ComputeEngine() {
		super();
	}
	
	public <T> T executeTask(Task<T> t) throws RemoteException {
		return t.execute();
	}
	
	public static void main(String[] args) {
		
		try {
			String name = "Compute";
			Compute engine = new ComputeEngine();
			Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
			
			Registry registry = LocateRegistry.createRegistry(2020);
			registry.bind(name, stub);
			System.out.println("ComputeEngine bound!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
