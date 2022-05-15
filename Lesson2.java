
public class Lesson2 {
    /*
    class types:
    - created with "new" keyword
    - "new" creates a new instance
    - class type variables store references to instances
    
    Java has a universal class type: Object
    an variable of type Object can store instances
    */
    public static void main(String[] args) {
        Point a = new Point(3, 4);
        Point b = a;
        
        a.x = 0;
        System.out.println(b.x);
        
        Object o = "hello";
        Object o2 = new int[]{1, 2, 3};
        Object o3 = new Point(5, 2);
        // Object is the only type where you can set it to an array of its type
        Object o4 = new Object[]{o, o2, o3};
        
        // data type of variables does not have to be the same as the data type of instances
        System.out.println(o);
        
        // the only things you can do with Object variables are things that you can do with any type
        System.out.println(o2);
        System.out.println(String.format("Hello my name is %s and I am %d", "Chi Bong", 30));
        System.out.println(sum(2, 6, 8, 3, 12, 6));
    }
    
    static int sum(int... values) {
        int sum = 0;
        for(int i: values) {
            sum += i;
        }
        return sum;
    }
    
    static class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }
}
