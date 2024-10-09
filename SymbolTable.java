import java.util.TreeMap;


public class SymbolTable<E> {
	
	private TreeMap<E, E> symTable;
	
	int size = 0;
	
	public SymbolTable() {
		symTable = new TreeMap<E, E>();
	}
	
	public E max() {
		return symTable.lastKey();
	}
	
	public E min() {
		return symTable.firstKey();
	}
	
	public E get(E key) {
		return symTable.get(key);
	}
	
	public void put(E key, E value) {
		if (value.equals(-1)) symTable.remove(key);
		else 			 symTable.put(key, value);
		size++;
	}
	
	public void delete(E key) {
		symTable.remove(key);
	}
	
	public boolean contains(E key) {
		return get(key) != null;
	}
	
	public Iterable<E> keys() {
		return symTable.keySet();
	}
}
