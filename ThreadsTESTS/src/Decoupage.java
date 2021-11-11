package lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Decoupage {
	   
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException{  
		
		String line;
		StringTokenizer st;
		String word;
		Integer cpt = 0;
		ArrayList<String> words = new ArrayList<String>();
		
		        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zied\\Desktop\\big.txt"))) { 
		            while ((line = br.readLine()) != null) {
		                
		                st = new StringTokenizer(line, " ,.;:_-+/*\\.;\n\"'{}()=><\t!?#");
		                
		                while (st.hasMoreTokens()) {
		                    word = st.nextToken();
		                    words.add(word);
		                    cpt++; 
		                }    
		            }
		            System.out.println(cpt);
		            System.out.println(words);
		            System.out.println(words.size());
		        }
	      
		      // Détermination du nombre de threads
		      double nb_thread = Math.log(cpt);
	      
		      int nb_thread_int = (int) Math.round(nb_thread);
		      
		      System.out.println("nombre de threads à créer: " + Math.round(nb_thread));
	     
	      
		      // Découpage du fichier texte en liste de textes à donner à chaque thread
		      
		          long nb_mots_par_thread = Math.round(cpt/nb_thread);
		          
		          System.out.println("mots par thread: " + nb_mots_par_thread);
		         
		          
		          
		       // Création des intervales
		          ArrayList<Integer> intervales = new ArrayList<>();
		          
		          int a = 0;
		          int b = -1;
		          
		          
		          for (int i=0; i<nb_thread_int; i++ ) {
		        	  
		        	  intervales.add((int) (i*nb_mots_par_thread + a));
		        	  intervales.add((int) (i*nb_mots_par_thread + nb_mots_par_thread + b));
		        	  
		        	  b ++;
		        	  a = i;
		        	  
		          }
		          
		          System.out.println("intervales: " + intervales);
		          System.out.println("taille intervales: " + intervales.size());
		          System.out.println("dernier élément liste: " + intervales.get(intervales.size()-1));
		          
		          // Création des chaines de caractères (parties de textes que chaque thread va traiter)
		          
		          int valeur_max = intervales.get(intervales.size()-1); // dernière valeur de 'intervales'
		          
		          List<List<String>> chaines = new ArrayList<List<String>>(); // Liste principale, contenant les sous-listes 'chaine'
		          
		          List<String> clef_suppression = new ArrayList<>();
		          
		          clef_suppression.add("-------");
		          
		          
		          int compteur =0;
		          
		          
		          // ERREUR JY SUIS PRESQUE
		        
		          for (int q=0; q<2*nb_thread-1 ; q++) { 		        	  
		        	  List<String> chaine = new ArrayList<>(); // sous-liste
		        	  System.out.println("thread");
		        	  
		        		  
		        	  for (int u=intervales.get(q) ; u<intervales.get(q+1)+1; u++) { // on se place dans le premier intervalle
		        		  
		        		  
		        		  
		        		  if(u<words.size()) {
		        			  
		        		  chaine.add(String.valueOf(words.get(u))); // PB est ici, word va jusqu'à 100 et intervales va jusq'à 114
		        		  compteur ++;
		        			  
		        		  
		        		  }
		        	  
	        		 
		        	  }
		        	  System.out.println(chaine);
		        	  System.out.println(compteur);
		        	  chaines.add(chaine);
		        	       	 
		        		 
		          }
		          
		          System.out.println(chaines);

		          // code trouvé sur Internet qui permet de remove 1 mot sur 2 (index impair)
		          int i[] = {1,3,5,7,9,11,13,15};

		          Iterator<List<String>> itr = chaines.iterator();
		          int pos = 0;
		          int index = 0;
		          while( itr.hasNext() ){
		              itr.next();
		              if( pos >= i.length ){
		                  break;
		              }
		              if( i[pos] == index ){
		                  itr.remove();
		                  pos++;
		              } 

		              index++;
		          }
		          
		          // fin du code trouvé sur internet
		          
	      System.out.println(chaines);
		        	 
		          }
		          
		          
		          
		          
		          
		          
		          
		          
		          
		          
		       
   
		   }


	

