/*
Object: universal class type
        (you can store any type of value in a Object variable)
        
Object o = "hello";

double d = 5; // auto-converts to 5.0
int i = 5.0;

type hierarchy: 
double
  float
  long
    int
      char

With primitive types, the value gets converted to the variable's type as you store it.

With class types, the value of the instance NEVER changes

Object
  - String
  - int[]
  - Object[]
  - Student
  - Exception - run-time error
    - NullPointerException
    - ArrayIndexOutOfBoundsException
    - (and many more...)
*/

public class Lesson3 {
    
    public static void main(String[] args) throws TriangleException {
        int i = (int)5.0;
        try {
            int[] array = new int[]{1, 2, 3};
            System.out.println(array[0]); 
            
            int[] array2 = null; // no instance 
            System.out.println(array2[0]);
            
            
        }
        // this catches Exception (and all subtypes of Exception)
        catch(Exception e) {
            
            e.printStackTrace(); // print out the red text
            System.out.println("disaster averted");
        }
        
        try {
            Triangle t = new Triangle(1, 1, 100);
        } catch(TriangleException e) {
            System.out.println("bad triangle!");
        }
        
        
        Triangle t2 = new Triangle(3, 4, 5);
    }
    
    // 1, 1, 100000000
    // sum of any 2 sides must be greater than the 3rd
    static class Triangle {
        double a, b, c;
        
        // this function can potentially throw TriangleException
        // whoever calls this function MUST handle the exception
        Triangle(double a, double b, double c) throws TriangleException {
            this.a = a;
            this.b = b;
            this.c = c;
            
            if(a + b <= c || a + c <= b || b + c <= a) {
                // throw an Exception!
                throw new TriangleException();
            }
        }
    }
    
    // by extending Exception, we make this class a subtype of Exception
    // everything we can do with Exception can also be done with a TriangleException
    static class TriangleException extends Exception {
        
    }
}






