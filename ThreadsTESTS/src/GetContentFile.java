import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class GetContentFile {
	
	public static void main(String[] arg)  throws java.io.IOException {
		String file = "big.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(file))) 
        {
            String line;
            Map<String, Integer> map = new HashMap<>();
            StringTokenizer st;
            String word;
            int nbc;
            
            
            while ((line = br.readLine()) != null) {
            	
            	st = new StringTokenizer(line, " ,.;:_-+*/\\.;\n\"'{}()=><\t!?");
            	while(st.hasMoreTokens()) {
            		word = st.nextToken();
            		if (map.containsKey(word)) {
            			nbc = (map.get(word)).intValue();
            			nbc++;
            		}
            		else nbc = 1;
            		map.put(word.toLowerCase(), nbc);
            		
        	    }
            	
                
            }
            
            for(Map.Entry<String, Integer> entry : map.entrySet() ) {
            	   System.out.println( entry.getKey() + "=" + entry.getValue() );
            } 
            

            
           
        
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
	
	
	
	

}
