package cliente2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import computeEngine.Compute;
import computeEngine.ComputeEngine;

public class Cliente2 {
	
	public static void main(String[] args) {
		
		Tarefa3 t3 = new Tarefa3();
		do {
			String nome = JOptionPane.showInputDialog("Informe o nome");
			t3.adicionarNome(nome);
		} while (JOptionPane.showConfirmDialog(null, 
					"Deseja informar novo nome?", 
					"Aula JavaRMI", 
					JOptionPane.YES_NO_OPTION)
				== JOptionPane.YES_OPTION);
		
		List<String> listaOrdenada = t3.execute();
		
		
		String name = "Compute";
			try {
				Registry Registry = LocateRegistry.getRegistry(2020);
				Compute comp = (Compute) Registry.lookup(name);
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		System.out.println("A lista de nomes ordenada é : ");
		for (int i=0; i<listaOrdenada.size(); i++) {
			System.out.println(listaOrdenada.get(i));
		}
		
		
	}
	
}
