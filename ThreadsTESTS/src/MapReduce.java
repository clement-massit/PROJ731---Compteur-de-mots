import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MapReduce {
	final static String outputFilePath = "results.txt";
	// new file object
	static File file = new File(outputFilePath);

	static BufferedWriter bf = null;

	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException{ 

		String path = "big.txt";
		List<List<String>> slicedTxt = Slice.sliceTxt(path); // le texte découpée en sous-listes
		ArrayList<Map<String, Integer>> mappedTxtList = new ArrayList<>(); // liste des textes mappés
		Map<String, Integer> results = new HashMap<String, Integer>();

		// EXECUTION DU MAPPAGE

		for(List<String> texte : slicedTxt) {

			MappingTask tache = new MappingTask(texte);
			Thread thread = new Thread(tache, "thread");
			thread.start();

			tache.getMappedText();

			mappedTxtList.add(tache.getMappedText());	

		}

		System.out.println(mappedTxtList); // On a bien stocké les données de notre mapping dans une liste qu'on pourra utiliser dans notre Reduce


		// EXECUTION DU REDUCE

		for(Map<String, Integer> map : mappedTxtList) {

			map.forEach((k, v) -> results.merge(k, v, Integer::sum));

		}

		System.out.println(results);

		// Ecriture du résultat dans un fichier texte
		bf = new BufferedWriter(new FileWriter(file));
		bf.write(results.toString());
		bf.flush();
		bf.close();


	}
}






