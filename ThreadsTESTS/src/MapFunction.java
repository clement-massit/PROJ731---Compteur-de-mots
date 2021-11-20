import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class MapFunction {
	
	
	public static Map<String, Integer> mapGenerator(List liste) throws IOException {

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
    	System.out.println(map);
    	
    	return map;
            
	    	
	}
	
	
	/*public static void main(String[] arg)  throws java.io.IOException {
		
		String[] liste = {"changing", "all", "over", "the", "world"};
		mapGenerator(liste);
	
		
	}*/
		
        
	
	
	
	

}
