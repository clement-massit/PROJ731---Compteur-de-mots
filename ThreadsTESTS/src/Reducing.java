import java.util.HashMap;
import java.util.Map;

public class Reducing {
	
	
	
    public static Map<String, Integer> reducing(Map<String, Integer> map){

        Map<String, Integer> results = new HashMap<String, Integer>();

        map.forEach((k, v) -> results.merge(k, v, Integer::sum));


        System.out.println(results);
        return(results);

    }

}
