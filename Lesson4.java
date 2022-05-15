// extends

/*
Class type hierarchy:
Object
- String
- ArrayList
- Exception
  - NullPointerException
  - ArrayIndexOutOfBoundsException
  - MyCustomException
- Place
  - Restaurant
  
Exception e = new NullPointerException();

A class either extends another class explicitly, or it extends Object implicitly


*/

public class Lesson4 extends Object {
    
    public static void main(String[] args) {
        Place p = new Place("KTBYTE", "2 Militia Dr", 90, -100);
        System.out.println(p); // gibberish by default (but we can change this!)
        System.out.println(p.name);
        
        Restaurant p2 = new Restaurant("Chi Bong's Diner", "123 Main St", 0, 0, "breakfast", 1, "bagals and eggs");
        
        System.out.println(p.getDirectionTo(p2));
        System.out.println(p2.getDirectionTo(p));
        
        System.out.println(String.format("Hi my name is %s and I'm %d", "Chi Bong", 30));
        
        // Object type contains things universal to all class types
        
        System.out.println(p2);
    }
    
    // Restaurant inherits everything that Place class has
    // Place is the "super" class, Restaurant is the "sub" class
    static class Restaurant extends Place {
        
        String foodType;
        int priciness; // 1-4 
        String menu;
        
        // subclass constructors MUST call a super class constructor
        // if we don't specify a super constructor to call, it calls super() (with no inputs)
        public Restaurant(String name, String address, double lat, double lng, String foodType, int priciness, String menu) {
            super(name, address, lat, lng);
            
            this.foodType = foodType;
            this.priciness = priciness;
            this.menu = menu;
        }
        
        public String toString() {
        	return super.toString() + "." + foodType + ", priciness:" + priciness + ". Menu: " + menu;
        }
    }
    
    // A place on a map
    static class Place extends Object {
        String name;
        String address;
        double lat, lng;
        
        public Place(String name, String address, double lat, double lng) {
            this.name = name;
            this.address = address;
            this.lat = lat;
            this.lng = lng;
        }
        
        String getDirectionTo(Place destination) {
            return "go left, go right, then go left and right again";
        }
        
        // We override the ToString() inherited from the Object class 
        // so that we can the Place instance pretty -printed
        public String toString() {
            return name + ", " + address + ": (" + lat + ", " + lng + ")";
        }
    }
}