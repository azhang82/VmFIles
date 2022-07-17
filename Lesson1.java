

// open Eclipse IDE (Integrated Development Environment)

// this is a class
// - a class contains methods, fields and constructors
import java.util.Arrays;

public class Lesson1 {
    public static void main(String[] args) {
        System.out.println("hello");
        
        // write a loop to count from 0 to 9
        for(int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        
        greet("Elmo");
        
        // "new" creates a new instance/object
        // a instance is a chunk in the computer memory with its own data
        int[] a1 = new int[]{1, 2, 3}; // set a1 to a new instance
        System.out.println(Arrays.toString(a1)); // ?????
        
        int[] a2 = new int[]{1, 2, 3}; // set a2 to a new instan
        
        System.out.println(a1 == a2); // false (checks whether they are the same array)
        
        int[] a3 = a2;
        // 3 int[] variables
        // 2 int[] instances (only used "new" 2 times)
        
        a3[0] = 10; // change the value inside the instance
        System.out.println(a3[0]); // 10
        System.out.println(a2[0]); // 10
    }
    
    static void greet(String name) {
        System.out.println("hello " + name);
    }
}
