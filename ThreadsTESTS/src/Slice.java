import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Slice {
	String txtfile = "test.txt";
	String word;
	int cpt = 0;
	String line;
	StringTokenizer st;
	
	public int count() throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(txtfile))) { 
			while ((line = br.readLine()) != null) {
				
				st = new StringTokenizer(line, " ,.;:_-+/*\\.;\n\"'{}()=><\t!?#");
				while (st.hasMoreTokens()) {
					word = st.nextToken();
					//System.out.println(word);
					cpt++;
					
				}
				
				
			}
			
			
		}
		
		return cpt;
	}
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		Slice s = new Slice();
		System.out.println(s.count());
		
		 
		String[] result = "this is a test".split("\\s");
	    for (int x=0; x<result.length; x++) {
	    	 System.out.println(result[x]);
	    	
	    }
	        
	}

}
