import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class MapFunction {
	/*
	 * Algorithme de mappage pour compter le nombre de mots dans
	 * une liste de chaines de caracteres. 
	 * On crée pour cela une map avec le mot associé
	 * à son occurence dans la liste de string
	 */


	public static Map<String, Integer> mapGenerator(List<String> liste) throws IOException {
		/*
		 * fonction Map :
		 * paramètre : List<String> liste, liste d'une chaine de caractère 
		 * 
		 * return : Map<String, Integer> , une map dont la clé est un String, et la valeur
		 * est un entier
		 */

		String chaine = "";
		for (String element : (List<String>) liste) {
			chaine += element + " ";
		}

		Map<String, Integer> map = new HashMap<>();
		String word;
		int nbc;
		StringTokenizer tokenizer = new StringTokenizer(chaine, " ,.;:_-+/*\\.;\n\"'{}()=><\t!?#");


		while(tokenizer.hasMoreTokens()) {
			word = tokenizer.nextToken();
			
			if (map.containsKey(word.toLowerCase())) {
				nbc = (map.get(word.toLowerCase())).intValue();
				word = word.toLowerCase();
				map.put(word, nbc + 1);
			}

			else {
				nbc = 1;
				map.put(word.toLowerCase(), nbc);
			}
		}	
		return map;
	}


}
