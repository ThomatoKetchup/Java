package algo.avancé;
import java.util.Arrays;
import java.util.Iterator;

public class StringArrayList implements Iterable<String>{
	private String[] data = new String[10];
	private int size = 0;

	public boolean add(String element) {
		this.ensureCapacity(this.size+1);
		this.data[this.size++]=element;
		return true;
	}

	//Inserts the specified element at the specified position in this list. 
	public void add(int index, String element) {
		this.ensureCapacity(this.size+1);
		if (index>=0 && index <=this.size) {
			for (int i =this.size; i>index;i-- ) {
				this.data[i]=this.data[i-1];
			}
			this.data[index]=element;
			this.size++;
		}
	}
	
	
	// Returns true if this list contains the specified element.
	public boolean	contains(String s) {
		for(int i=0;i<this.size;i++) {
			if (s.equals(this.data[i])){
				return true;
			}
		}
		return false;
	}
	
	// Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at least the number of elements specified by the minimum capacity argument.
	public void ensureCapacity(int minCapacity) {
		if (this.data.length>=minCapacity) 
			return; 
		int newLength = this.data.length*2;
		while (newLength <minCapacity) {
			newLength*=2;
		}
		String [] newData =Arrays.copyOf(this.data, newLength);
		this.data = newData;	
	}
	
	// Returns the element at the specified position in this list.	
	public String get(int index) {
		return this.data[index];
	}
	
	
	// Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
	public int indexOf(String s) {
		for(int i=0;i<this.size;i++) {
			if (s.equals(this.data[i])){
				return i;
			}
		}
		return -1;
	}
	
	//	Returns true if this list contains no elements.
	public boolean isEmpty() {
		return this.size==0; 
	}
	
	// Removes the element at the specified position in this list.
	public String remove(int index) {
		if (index>=0 && index <=this.size) {
			String s = this.data[index];
			for (int i=index;i<this.size;i++) {
				this.data[i]=this.data[i+1];
			}
			this.size--;
			return s;
		}
		return "";
	}
	
	
	// Replaces the element at the specified position in this list with the specified element.
	public String set(int index, String element) {
		String old = this.data[index];
		this.data[index] = element;
		return old;
	}
	
	// Returns the number of elements in this list.
	public int size() {
		return this.size;
	}
	
	// Returns an iterator over the elements in this list (in proper sequence).
	public Iterator<String> iterator(){
		return new LocalIterator(this);
	}
	
	private class LocalIterator implements Iterator<String>{
		String[] data;
		int position=0;
		int size; 
		
		public LocalIterator(StringArrayList c) {
			this.data = c.data;
			this.size = c.size;
		}
		public boolean hasNext() {
			return this.position<this.size;
		}

		@Override
		public String next() {
			return this.data[this.position++];
		}
		
	}
	

}