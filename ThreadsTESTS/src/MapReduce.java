import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapReduce {
	
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException{ 
		
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("THREAD " + currentThreadName + " COMMENCE");
		
		String path = "C:\\Users\\zied\\Desktop\\big.txt";
		
		List<List<String>> slicedTxt = Slice.sliceTxt(path); // le texte découpée en sous-listes
		
		ArrayList<Map<String, Integer>> mappedTxtList = new ArrayList<>(); // liste des textes mappés
		
		
		
		
		for(List<String> texte : slicedTxt) {
			
			MappingTask tache = new MappingTask(texte, 1000);
			Thread thread = new Thread(tache, "thread");
			thread.start();
		
		tache.getMappedText();
		
		mappedTxtList.add(tache.getMappedText());	
		
		}
		
		System.out.println(mappedTxtList);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	//	System.out.println("nb de mots : " + Slice.nbWords("test.txt"));
		//System.out.println("nb de threads : " + Slice.nbThreads(Slice.nbWords("test.txt")));
		
//		System.out.println("découpage du texte : " + Slice.sliceTxt("test.txt"));
		
	/*
	  		Slice.executeThreads(Slice.nbThreads(Slice.nbWords("test.txt")));
	

			
			List<List<String>> whole_list = Slice.sliceTxt("test.txt");
			ArrayList<Map<String, Integer>> listeResults = new ArrayList<>();
			
			
			for (List<String> liste : whole_list) {
				
				(new Thread(new MultiThreads(liste, listeResults))).start();
				
			}
		
 */
		
		
	}

}
