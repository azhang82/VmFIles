// Collections / Data Structures (List, Set, Map)
// 3959601

/*
Object
  List
    ArrayList

*/

import java.util.*;

public class Lesson8 {
    public static void main(String[] args) {
        // re-sizable array
        List<String> list = new ArrayList<>();
        list.add("Michael");
        list.add("James");
        list.add("Aaron");
        
        System.out.println(list); 
        System.out.println(list.get(0)); // array[0]
        list.set(0, "Alicia"); // array[0] = "Alicia";
        System.out.println(list.size()); // 3
        for(int i = 0; i < list.size(); i++) {
            System.out.println("hello " + list.get(i));
        }
        
        for(String name : list) {
            System.out.println("hola " + name);
        }
        
        list.add(0, "Alex");
        list.remove("James"); // can also pass in an index
        System.out.println(list); // Alex, Alicia Aaron
        // list.get(0) -> Alex
        // list.get(1) -> Alicia
        // list.get(2) -> Aaron
        System.out.println(list.contains("Aaron")); // true
        
        // Set
        // - elements are unique and un-ordered
        // - good for checking whether a value exists in a set
        
        // TreeSet sorts its elements
        // HashSet stores elements in random order
        Set<String> set = new HashSet<>();
        set.add("cherry");
        set.add("apple");
        set.add("orange");
        
        // Strings are sorted alphabetically (ASCII values in dictionary order)
        System.out.println(set); // apple, cherry, orange 
        
        // .contains() is very efficient on a Set
        if(set.contains("orange")) {
            System.out.println("yay!");
        }
        
        for(String fruit : set) {
            System.out.println("I ate " + fruit);
        }
        
        // sets are more efficient wit .contains()
        // (only noticeable when you have > 1000 elements)
   
       // Map -       f(0) = 4 f(1) = 1000, f(2) = -29
       // maps a each key in a Set to a corresponding value (of any type)
        
        Map<String, String> dict = new TreeMap<>();
        dict.put("orange", "a fruit or a color"); //adds a mapping to key of value
        dict.put("hamburger","a meat patty, style oringinated  from Hamburg");
        
        System.out.println(dict); // "hamburger": ........ "orange": ......
        
        Set<String> keys = dict.keySet();
        for(String key : keys) {
        	String value = dict.get(key);
        	System.out.println(key + ":" + value);
        }
        
        String[] ballots = {"Bob", "Jimmy", "Sarah", "Jimmy", "Joe", "Joe"};
        
        Map<String,Integer> tally = new TreeMap<>();		
        for(String person: ballots) {
        	if(tally.containsKey(person)) {
        		int votes = tally.get(person);
        		tally.put(person, votes + 1);
        	}
        	else {
        		tally.put(person, 1);
        	}
        }
        
        System.out.println(tally); // Bob: 1, Jimmy: 2, Sarah: 1, Joe: 2
      }
}



