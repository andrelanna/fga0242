import java.math.BigDecimal;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client {

	public static void main(String[] args) {
		try {
			String name = "Compute";
			Registry registry = LocateRegistry.getRegistry(2020);
			Compute comp = (Compute) registry.lookup(name);
			
			Tarefa1 t = new Tarefa1();
			
			BigDecimal x = comp.executeTask(t);
			System.out.println(x);
			
			Tarefa2 t2 = new Tarefa2();
			Integer[] r = comp.executeTask(t2);
			for (Integer i : r) {
				System.out.print(i + ", ");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
