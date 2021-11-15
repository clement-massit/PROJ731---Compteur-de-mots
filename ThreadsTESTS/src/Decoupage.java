

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Decoupage {
	   
	  
	
		public static List<List<String>> decoupage_texte(String path) throws FileNotFoundException, IOException{ 
		String line;
		StringTokenizer st;
		String word;
		Integer cpt = 0;
		ArrayList<String> words = new ArrayList<String>();
		// path : C:\\Users\\zied\\Desktop\\big.txt
		        try(BufferedReader br = new BufferedReader(new FileReader(path))) { 
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
		        int   nb_thread_int = get_nb_thread(cpt);
	      
		      // D�coupage du fichier texte en liste de textes � donner � chaque thread
		      
		          long nb_mots_par_thread = Math.round(cpt/nb_thread_int);
		          
		          //System.out.println("mots par thread: " + nb_mots_par_thread);
		          
		       // Cr�ation des intervales
		          ArrayList<Integer> intervales = new ArrayList<>();
		          
		          int a = 0;
		          int b = -1;
		          
		          
		          for (int i=0; i<nb_thread_int; i++ ) {
		        	  
		        	  intervales.add((int) (i*nb_mots_par_thread + a));
		        	  intervales.add((int) (i*nb_mots_par_thread + nb_mots_par_thread + b));
		        	  
		        	  b ++;
		        	  a = i;
		        	  
		          }
		          
		         /* System.out.println("intervales: " + intervales);
		          System.out.println("taille intervales: " + intervales.size());
		          System.out.println("dernier �l�ment liste: " + intervales.get(intervales.size()-1));
		          */
		          // Cr�ation des chaines de caract�res (parties de textes que chaque thread va traiter)
		          
		          List<List<String>> chaines = new ArrayList<List<String>>(); // Liste principale, contenant les sous-listes 'chaine'
		          
		          List<String> clef_suppression = new ArrayList<>();
		          
		          clef_suppression.add("-------");
		          
		          
		          
		          
		          
		          // ERREUR JY SUIS PRESQUE
		        
		          intervales.set(intervales.size()-1, words.size());
		        // System.out.println("intervales mis � jour : " + intervales);
		          
		         
		         
		          for (int q=0; q<intervales.size()-1 ; q++) { 
		        	  
		        	  if (intervales.get(q+1)-intervales.get(q)>1) {
		        	  
		        	  //System.out.println("thread num�ro :" + q);
		        	  
		        	  
		        		  List<String> chaine = new ArrayList<>(); 
		        		  
		        	  for (int u=intervales.get(q) ; u<intervales.get(q+1)+1; u++) { 
		        		  
		        		  
		        		  if(u<words.size()) { 
		        			  
		        		  chaine.add(String.valueOf(words.get(u)));
		        		  
		        		  }
	 
		        	  }
		        	 
		        	  //System.out.println(chaine);
		        	 
		        	  chaines.add(chaine);
		        	       	 
		        	  }	 
		          }
		                    
	      //System.out.println(chaines);
		return chaines;
		        	 
		          }
		
		public static int getNbWord(String file) throws FileNotFoundException, IOException {
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
		          
		          
		          
		public static int get_nb_thread(int cpt) {
			//D�termination du nombre de threads
			double nb_thread = Math.log(cpt);
			
			int nb_thread_int = (int) Math.round(nb_thread);
			
			//System.out.println("nombre de threads � cr�er: " + Math.round(nb_thread));
			return nb_thread_int;
	
		}
		
		public static void executeThreads (int nbr) throws FileNotFoundException, IOException {
			/*
			 * mettre les parties de textes dans la boucle for 
			 */
			
			List<List<String>> whole_list = decoupage_texte("test.txt");
			
			
			
			
			for (List<String> liste : whole_list) {
				
				(new Thread(new MultiThreads(liste))).start();
				
			}
					
			}
		
		
		
		          
		          
		          
		public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException{ 
			//System.out.println(decoupage_texte("chaine.txt"));
			//System.out.println(get_nb_thread(9));
			executeThreads(get_nb_thread(getNbWord("test.txt")));
			
   
		}



		


}

