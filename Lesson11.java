// 3959601

/*
abstract class can contain abstract methods
- abstract methods only have function header, its definition is left up to the subclass


*/

// interfaces
import java.util.*;

public class Lesson11 {
    public static void main(String[] args) {
        Comparator<Integer> c = (Integer a, Integer b) -> a - b;
        System.out.println(c.compare(3, 5)); // -2
        
        Executable hg = new HomeworkGrader();
        hg.execute(); 
         Counter counter = new Counter();
         counter.run();
        
         new Thread(new Counter()).start();
         new Thread(new Counter()).start();
        
        String[] words = {"loops", "recursion", "class", "interface"};
        int[] numbers = {3, 5, 1, 2, 6};
        Arrays.sort(words); // sorts using dictionary order (ASCII values)
        Arrays.sort(numbers);
        
        System.out.println(Arrays.toString(words));
        System.out.println(Arrays.toString(numbers));
        
        Person[] people = new Person[]{new Person("Chi Bong", "Ho"), new Person("George", "Washington"), new Person("Curry", "Haskell")};
        
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
    }
    
    static class Person implements Comparable<Person> {
        String last, first;
        
        public Person(String last, String first) {
            this.last = last;
            this.first = first;
        }
        
        public String toString() {
            return first + " " + last;
        }
        
        // (int a, int b) -> a - b
        
        public int compareTo(Person other) {
            // compare by last name first, then by first name
            int diff = this.last.compareTo(other.last);
            if(diff == 0) {
                diff = this.first.compareTo(other.first);
            }
            
            return diff;
        }
    }
    
    // count the number of seconds
    static class Counter implements Runnable {
        int count = 0;
        
        public void run() {
            try {
                System.out.println(count);
                Thread.sleep(1000); // do nothing for 1000ms 
                count++;
                run(); // recursion
            } catch(Exception ex) {
                // whatever
            }
        }
    }
    
    // interfaces vs abstract classes
    // - interfaces can ONLY have function headers
    // - a class can only be a subclass of ONE other class, but it can implement
    //   multiiple interfaces
    //    (you CANNOT have a class extend multiple classes because the superclasses
    //     might have conflicting definitions)
    // interface methods are public by default
    
    // interfaces can ONLY contain function headers
    //  
    static interface Executable {
        void execute();
    }
    
    static class HomeworkGrader implements Executable {
        public void execute() {
            System.out.println("Homework graded!");
        }
    }
}