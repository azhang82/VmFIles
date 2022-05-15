import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.Unirest;

public class Lesson9 {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> tally = new TreeMap<>();
        tally.put("John", 10);
        tally.put("Johanna", 10);
        tally.put("Chi Bong", 2);
        
        System.out.println(tally); 
        
        Gson gson = new Gson();
        System.out.println(gson.toJson(tally));
        
        String json = "{\"Chi Bong\":2000,\"John\":10,\"Johanna\":10}";
        
        Map<String,Integer> tally2 = gson.fromJson(json, new TypeToken<Map<String,Integer>>() {}.getType());
        System.out.println(tally2);
        
        
        // iterate-and-remove pattern
        // you CANNOT remove elements in a for-each loop
        List<String> candidates = new ArrayList<>(tally2.keySet());
        // for(String c : candidates) {
        //     candidates.remove(c);
        // }
        
        // iterator allows us to iterate-and-remove
        
        // when using an Iterator, do EVERYTHING through the iterator
        // (DO NOT touch the underlying data structure)
        Iterator<String> iter = candidates.iterator();
        while(iter.hasNext()) {
            String c = iter.next(); // returns the "next" element, increments the "index"
            System.out.println(c); 
            
            if(c.startsWith("J")) {
                iter.remove(); // removes the element returned by the latest .next() call
            }
        }
        
        // iterator functions DO NOT TAKE IN INPUTS
        
        System.out.println(candidates); // ["Chi Bong"]
        
        
        json = Unirest.get("https://static.ktbyte.com/org.json").asString().getBody();
        Map<String,List<String>> org = gson.fromJson(json, new TypeToken<Map<String,List<String>>>() {}.getType());
        
        System.out.println(org);
        
        System.out.println(getAllReports("Lydia", org));
    }
    
    // get all direct and indirect reports of the specified employee
    static List<String> getAllReports(String employee, Map<String,List<String>> org) {
        List<String> allReports = new ArrayList<>();
        
        List<String> directReports = org.get(employee);
        for(String direct : directReports) {
            allReports.add(direct);
            allReports.addAll(getAllReports(direct, org));
        }
        
        return allReports;
    }
    
}