import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MultiThreads implements Runnable {
	Thread thread;
	String txtfile = "test.txt";
	/*
	 * trame : 
	 * on prend le fichier de base on le slice en plusieurs partie selon le nombre de mot
	 * pour chaque partie on créer un thread et on le start pour faire le map 
	 * 
	 * puis partie reduce à travailler
	 */
	
	@Override
	public void run() {
		
		System.out.println("hello im fred");
		//MapForAFile.mapgen(txtfile);
	}
	
public void executeThreads (int nbr) {
	/*
	 * mettre les parties de textes dans la boucle for 
	 */
	for (int i = 0; i < nbr; i++) {
		(new Thread(new MultiThreads())).start();
		
	}
		
		
	}
	
		
	public void get_result() {
		
	}
	
	/*
	 * pour récuperer le résultas du thread faire appel à une fonction
	 * 
	 */
	
	
	

	public static void main(String[] args) {
		/*
		 * ici on va créer plusieurs thread pour executer le map 
		 * 
		 * voir si on change le type de l'entrée en mode liste plutot que fichier
		 */
		
		MultiThreads m = new MultiThreads();
		m.executeThreads(7);
		
		
		
		
	}	
	

	
	
		


	


	
}
			    



