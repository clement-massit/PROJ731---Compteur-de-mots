import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MapForAFile {
	private String file;
	
	public static Map<String, Integer> mapgen(String file) {
		
		String line;
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st;
        String word;
        int nbc;
	
		try(BufferedReader br = new BufferedReader(new FileReader(file))) 
        {           
            
            PrintWriter writer = new PrintWriter("map.txt", "UTF-8");
            
            while ((line = br.readLine()) != null) {
            	
            	st = new StringTokenizer(line, " ,.;:_-+/*\\.;\n\"'{}()=><\t!?#");
            	while(st.hasMoreTokens()) {
            		word = st.nextToken();
            		
            		
            		if (map.containsKey(word.toLowerCase())) {
            			nbc = (map.get(word.toLowerCase())).intValue();
            			map.put(word, nbc + 1);
            		}
            		
            		else {
            			nbc = 1;
            			
            			map.put(word.toLowerCase(), nbc);
            		}
            		
        	    }	
                
            }
            writer.print(map);
            writer.close();
            
            
            /*int c = 0;
            for(Map.Entry<String, Integer> entry : map.entrySet() ) {
            	   System.out.println( entry.getKey() + "=" + entry.getValue() );
            	   c++;
            } */
           
 
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    
		return map;
		
	}
	
	public static void main(String[] arg)  throws java.io.IOException {
		String file = "big.txt";
		System.out.println(mapgen(file).size());
		
	}
		
        
	
	
	
	

}
