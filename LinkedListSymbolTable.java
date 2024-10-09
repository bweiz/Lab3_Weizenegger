import java.util.Comparator;

public class LinkedListSymbolTable<Key, Value> {
	private Node head;
	private int size;
	
	private class Node {
		private Value value;
		private Key key;
		private Node next;
		
		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public LinkedListSymbolTable() {
		head = null;
		size = 0;
	}
	
	public void put(Key key, Value val) {
		if(size == 0) {														// If empty list, create new node with given key and value and set as head
			head = new Node(key, val, head);
			size++;
		} else {
			for (Node i = head; i != null; i = i.next) {					// If not empty, check for redundancy
				if (key.equals(i.key)) {									// If redundant, replace value with latest value and return
					i.value = val;
					return;
				}
			}
			head = new Node(key, val, head);								// If not redundant, make new key-value pair head
			size++;
		}
	}
	
	public Object get(Key key) {												// Check for key in list, and return key's value if present
		for (Node i = head; i != null; i = i.next) {
			if (key.equals(i.key)) {
				return i.value;
			} 
			
		}
		return null;
	}
	
	public Boolean contains(Key key) {
		for (Node i = head; i != null; i = i.next) {						// Parse through list to find key and return true if present
			if (key.equals(i.key)) {
				return true;
			}
		}
		return false;

	}
	
	public Key min() {
		Value min = head.value;												// Create temporary keys and values until min is found
		Key minKey = head.key;
		for (Node i = head; i != null; i = i.next) {
			if (((Comparable<Key>) i.value).compareTo((Key)min) < 0) {		// Compare values to find min
				min = i.value;
				minKey = i.key;
			}
		}
		return minKey;														// Return key
	}
	
	public Key max() {
		Value max = head.value;												// Create temporary keys and values until max is found
		Key maxKey = head.key;
		for (Node i = head; i != null; i = i.next) {
			if (((Comparable<Key>) i.value).compareTo((Key)max) > 0) {		// Compare values to find max
				max = i.value;
				maxKey = i.key;
			}
		}
		return maxKey;														// Return key
	}
	
	public void delete(Key key) {
		int n=0;
		for (Node i = head; i != null; i = i.next) {						// Parse through key list to find key to be deleted
			n++;
			if (key.equals(i.key)) {
				if (n == size) {
				i.next = null;
				size--;
				} else {													// If not at end
					Node prev = head;										// Temporary previous node
					for(int x = 0; x == n-1; x++) {
						prev = prev.next;
					}
					prev.next = i.next;										// Previous now linked to key.next
					size--;
				}
			}
		}
	}
	
	public int[] keys() {
		int[] keys = new int[size];
		Node x = head;
		for(int i = 0; i<size; i++) {										// Create array of keys unordered
			keys[i] = (int) x.key;
			x = x.next;
		}
		for(int z=0; z<size; z++) {											// Order array
			for(int y=z+1; y<size; y++) {
				int hold = 0;
				if (keys[z] > keys[y]) {
					hold = keys[z];
					keys[z] = keys[y];
					keys[y] = hold;
				}
			}
		}
		return keys;														// Return ordered array
	}
}
	


