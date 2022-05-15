import java.util.*;
public class Lesson13 {
	public static void main(String[] args) {
		Set<Integer> a = Set.of(1,2,3,4);
		Set<Integer> b = Set.of(2,4,6);
		
		System.out.println(intersect(a, b));
		System.out.println(getMostFrequent("adsajidowqjaioeeeee"));
		StatisticalList list = new StatisticalList();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(9);
		
		System.out.println(list.getMean());
		System.out.println(list.getMedian());
		
		MyInteger[] array = {new MyInteger(4), new MyInteger(3), new MyInteger(1)};
		Arrays.parallelSort(array);;
		System.out.println(Arrays.deepToString(array));// 1,3, 4
		Arrays.parallelSort(array, new CustomComparator());
		System.out.println(Arrays.deepToString(array)); // 4,3,1
	}
	// Comparator allows us t o define a customer comparison (espicially for a data type that already implements Comparable
	static class CustomComparator implements Comparator<MyInteger> {
		public int compare(MyInteger a, MyInteger b) {
			return b.x - a.x; // reverse order comparator
		}
	}
	
	static class MyInteger implements Comparable<MyInteger> {
		int x;
		
		MyInteger(int value) {
			this.x = value;
		}
		
		public String toString() {
			return x + "";
		}
		
		// return (-) if this comes before other
		// return (+) if this comes after other
		// return (0) if this equals other
		//return the subtraction of values between "this" and "other"
		public int compareTo(MyInteger other) {
			return this.x - other.x;
		}
	}
	// Comparable
	
	static class StatisticalList extends ArrayList<Integer> implements Statistics {

		@Override
		public double getMean() {
			double sum = 0;
			for(int e : this) {
				sum += e;
			}
			
			return sum / this .size();
		}

		@Override
		// 3,1,9,5,7 -> 1, 3, 5, 7, 9
		public double getMedian() {
			ArrayList<Integer> newList = new ArrayList<>(this); // make a clone of current list
			Collections.sort(newList);
			return newList.get(newList.size() /2) + 0.0;
			// Collections.sort()
		}
		
	}
	
	static interface Statistics {
		double getMean();
		double getMedian();
	}
	
	// Map<String, Integer>
	// {"Alex": 90, "Bryce": 90, "James": 90, "Chi Bong": 0}
	
	// write a function that takes in a String and finds the most frequent character in it
	
	static char getMostFrequent(String s) {
		
		Map<Character, Integer> freq = new TreeMap<>(); //{}
		
		char mostFreqChar = 'a';
		int mostFreqCount = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			//freq.keySet().contains(c)
			if(freq.containsKey(c)) {
				int count = freq.get(c);
				freq.put(c, count + 1);
			}
			else{
				freq.put(c, 1);
			}
			int count = freq.get(c);
			if(count> mostFreqCount) {
				mostFreqChar = c;
				mostFreqCount = count;
			}
		}
		return mostFreqChar;
	}
	
	//write a function that takes in 2 Sets and returns a new Set
	// containing elements common to both (intersect)
	// A: {1,2,3,4}
	// B: {2,4,6}
	// ret: {2,4}
	 static<T> Set<T> intersect(Set<T> a, Set<T> b) {
		Set<T> ret = new HashSet<>();
		for(T e: a) {
			if(b.contains(e))  {
					ret.add(e);
				}
			}
		
			return ret;
		}
}
