import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MapForAFile {
	
	
	public static Map<String, Integer> mapGenerator(String chaine) throws IOException {
		
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
	
	
	public static void main(String[] arg)  throws java.io.IOException {
		String file = "chaine hotel cameroune Hotel";
		mapGenerator(file);
	
		
	}
		
        
	
	
	
	

}
