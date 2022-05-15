/* 
		Class type heirarchy:
		Object
		- String
		-ArrayList
		-Exception
			-NullPointerException	
			- ArrayIndexOutOfBoundsException
			- MyCustomException
		-Place
			-Restaurant
		Exception e = new NulPointerException();
		A class either extends another class explicitly, or it extends Object implicitly
		*/
import java.util.Arrays;
public class Lesson5 {
	
	// static: NOT tied to any instances. no need for making an instance to access it
	
	// public: accessible from outside the class
	// private: only accessible from within the class (NOT even from subclasses)
	
    public static void main(String[] args) {
    	// polymorphism 
    	Shape[] shapes = {new Circle(5), new Rect(3, 4)};
        
    	for(Shape s : shapes) {
    		System.out.println(s);
    	}
    	
    	// if PI were not static:
    	// Math m = new Math();
    	// m.PI
    	
    	Object o = "hello";
        Object o2 = new int[]{1, 2, 3};
        Object o3 = new Object[]{o, o2, new int[][]{{1, 2, 3}, {4, 5, 6}}};
        smartPrint(o, o2, o3);
    }
    
    static void smartPrint(Object... objs) {
    	for(Object o :objs) {
    		if(o instanceof int[]) {
    			System.out.println(Arrays.toString((int[])o));
    		}
    		// for this function to work totally, we need 8 if statements
    		// for arrays of the 8 primitive data types
    		else if(o instanceof Object[]) {
    			// this catches every class type array
    			// (String[], Shape[], int[][], )
    			for(Object o2 : (Object[])o) {
    				smartPrint(o2); // recursion
    			}
    		} else {
    			System.out.println(o);
    		}
    	}
    }
    
    static class Circle extends Shape {
        
        double radius;
        
        public Circle(double radius) {
            super(0);
            this.radius = radius;
        }
        
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }
        
        public double getArea() {
            return Math.PI * radius * radius;
        }
    }
    
    static class Rect extends Shape {
    	double w, h;
    	
    	public Rect(double w, double h) {
    		super(4);
    	this.w = w;
    	this.h = h;
    }

		@Override
		public double getPerimeter() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getArea() {
			// TODO Auto-generated method stub
			return 0;
		}
    }
    
    static abstract class Shape {
        int numSides;
        
        public Shape(int numSides) {
            this.numSides = numSides;
        }
        
        // any (non-abstract) subclass MUST provide definitions for these 2 abstract functions
        public abstract double getPerimeter();
        
        public abstract double getArea();
        public String toString() {
        	return getClass().getSimpleName() + "sides: " + numSides+ ", perimeter: " + getPerimeter() + ", area: " + getArea();
        }
    }
}