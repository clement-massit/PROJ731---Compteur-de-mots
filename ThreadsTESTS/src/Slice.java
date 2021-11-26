import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Slice {
	   /*
	    Classe qui gère le traitement du fichier .txt, on retrouve le découpage du texte, le calcul du nombre de mots dans le texte
	 et le calcul du nombre de threads
	    */
	  
	
		public static List<List<String>> sliceTxt(String path) throws FileNotFoundException, IOException{ 
			/*
			 * Pour découper le texte, transformer un fichier .txt en liste de chaines de caractères
			 */
			
		String line;
		StringTokenizer st;
		String word;
		Integer cpt = 0;
		ArrayList<String> words = new ArrayList<String>();
		
		// On lit le fichier texte ligne par ligne
		        try(BufferedReader br = new BufferedReader(new FileReader(path))) { 
		            while ((line = br.readLine()) != null) {
		                
		                st = new StringTokenizer(line, " ,.;:_-+/*\\.;\n\"'{}()=><\t!?#");
		                
		                while (st.hasMoreTokens()) {
		                    word = st.nextToken();
		                    words.add(word);
		                    cpt++; // nb de mots
		                }    
		            }

		        }
		        
		        int   nb_thread_int = nbThreads(cpt);
	      
		      // Découpage du fichier texte en liste de textes à donner à chaque thread
		      
		          long nb_mots_par_thread = Math.round(cpt/nb_thread_int);
		          

		          
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
		         
		          /*
		         System.out.println("intervales: " + intervales);
		         System.out.println("taille intervales: " + intervales.size());
		         */
		          
		    
		          List<List<String>> chaines = new ArrayList<List<String>>(); // Liste principale, contenant les sous-listes 'chaine'
		          
		          List<String> clef_suppression = new ArrayList<>();
		          
		          clef_suppression.add("-------");
		          
		          intervales.set(intervales.size()-1, words.size());
		        // System.out.println("intervales mis à jour : " + intervales);
		          
		         
		         
		          for (int q=0; q<intervales.size()-1 ; q++) { 
		        	  
		        	  if (intervales.get(q+1)-intervales.get(q)>1) {
		        	  
		        	  //System.out.println("thread numéro :" + q);
		        	  
		        	  
		        		  List<String> chaine = new ArrayList<>(); 
		        		  
		        	  for (int u=intervales.get(q) ; u<intervales.get(q+1)+1; u++) { 
		        		  
		        		  
		        		  if(u<words.size()) { 
		        			  
		        		  chaine.add(String.valueOf(words.get(u)));
		        		  
		        		  }
	 
		        	  }

		        	 
		        	  chaines.add(chaine);
		        	       	 
		        	  }	 
		          }
		                    
	      //System.out.println(chaines);
		return chaines;
		        	 
		          }
		
		public static int nbWords(String file) throws FileNotFoundException, IOException {
			String line;
			StringTokenizer st;
			String word;
			Integer cpt = 0;
			ArrayList<String> words = new ArrayList<String>();
			        try(BufferedReader br = new BufferedReader(new FileReader(file))) { 
			            while ((line = br.readLine()) != null) {
			                
			                st = new StringTokenizer(line, " ,.;:_-+/*\\.;\n\"'{}()=><\t!?#");
			                
			                while (st.hasMoreTokens()) {
			                    word = st.nextToken();
			                    words.add(word);
			                    cpt++; 
			                }    
			            }
			            /*System.out.println(cpt);
			            System.out.println(words);
			            System.out.println(words.size());*/
			        }
			        return cpt;
		}
		          
		          
		        
		public static int nbThreads(int nbWord) {
			
			  /* On applique un logarithme afin de trouver un nombre cohérents de threads à créer (le logarithme est pratique, si 
			par exemple on a 100 mots, on a juste à créer 2 threads
			*/
		
			double nb_thread = Math.log(nbWord);
			int nb_thread_int = (int) Math.round(nb_thread);
			
			return nb_thread_int;
	
		}
		
		
					
	


}

