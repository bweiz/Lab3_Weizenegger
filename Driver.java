import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		
		int x = 0;
		
		Scanner sc = new Scanner(new File("lab3in"));
		SymbolTable st = new SymbolTable();
		
		while(sc.hasNext()) {
			int key = sc.nextInt();
			int value = sc.nextInt();
			st.put(key, value);
		}
		
		if(st.contains(5)) {
			System.out.println(5 + " was found in the symbol table with value " + st.get(5));
		} else {
			System.out.println("5 was not found in symbol table");
		}
		
		st.delete(5);
		
		for (Object s:st.keys()) {
			System.out.println(s + "   " + st.get(s));
		}
		
		System.out.println("Minimum key with value is " + st.min() + ", " + st.get(st.min()));
		System.out.println("Maximum key with value is " + st.max() + ", " + st.get(st.max()));
		
		System.out.println();
		
		int n = 0;
		
		Scanner sc2 = new Scanner(new File("lab3in"));
		LinkedListSymbolTable st2 = new LinkedListSymbolTable();
		
		while(sc2.hasNext()) {
			int key = sc2.nextInt();
			int value = sc2.nextInt();
			st2.put(key, value);
		}
		
		if(st2.contains(5)) {
			System.out.println(5 + " was found in the symbol table with value " + st2.get(5));
		} else {
			System.out.println("5 was not found in symbol table");
		}
		
		st2.delete(5);
		
		for (Object s:st2.keys()) {
			System.out.println(s + "   " + st2.get(s));
		}
		
		System.out.println("Minimum key with value is " + st2.min() + ", " + st2.get(st2.min()));
		System.out.println("Maximum key with value is " + st2.max() + ", " + st2.get(st2.max()));
	}
}
