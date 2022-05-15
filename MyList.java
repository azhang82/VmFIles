import Lesson10.MyList;

public class MyList<T> {
		T[] array;
		int size; //how many values are in the list right now
						 // (this is NOT the same as array.length)
		MyList() {
			array = (T[])new Object[10]; 
			size = 0;
		}
		
		// .add()
		// .size()
		
		void add(T element) {
			if(size < array.length) {
				array[size] = element;
				size++;
			}
			else {
				T[] newArray = (T[]) new Object[array.length * 2];
				for(int i = 0; i < array.length; i++) {
					newArray[i] = array[i];
				}
				array = newArray; // this makes "array refer to the same instance as newArra
				array[size] = element;
				size++;
			}
		}
		int size() {
			return size;
		}
		
		public String toString() {
			String ret = "";
			for(int i = 0; i < size; i++) {
				ret += array[i] + " ";
			}
			
			return ret;
		}
		
		public static void main(String[] args) {
			MyList<String> list = new MyList<>();
			list.add("hello");
			list.add("123");
			System.out.println(list);
		}
	}