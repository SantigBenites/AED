import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.LinkedList;


public class HashtableChain <K , V > implements Iterable<K>{
	
	/** The array holding the elements in the table . */
	public LinkedList < Entry <K , V > >[] table ;
	
	 /** The number of keys in this table . */
	private int numKeys ;
	
	 /** The initial capacity of this table . */
	private static final int INITIAL_CAPACITY = 13;
	
	 /** The maximum load factor for this table . */
	private static final double LOAD_THRESHOLD = 3.0;
	
	 /** The key - value pairs for a hash table . */
	
	@SuppressWarnings("unchecked")
	public HashtableChain() {
		table = (LinkedList<Entry<K, V>>[]) Array.newInstance(LinkedList.class, INITIAL_CAPACITY);
	}
	
	private static class Entry <K , V > {
		private K key ;
		private V value ;
		private Entry ( K key , V value ) {
			this . key = key ;
			this . value = value ;
		}
	 }
	
	
	public V get(K key) {
		int index = key.hashCode();
		if(index>=table.length) {
			index = index%table.length;
		}
		if (table[index] != null) {
			// Search the list at table[index] to find the key.
			for (Entry<K, V> nextItem : table[index]) {
				if (nextItem.key.equals(key))
					return nextItem.value;
			}
		}
		// key is not in the table.
		return null;
		}
	
	public void remove(K key) {
		int starterIndex = key.hashCode();
		int index = key.hashCode();
		if(index>=table.length) {
			index = index%table.length;
		}
		if (table[index] != null) {
			// Search the list at table[index] to find the key.
			for (int i=0;i<table[index].size();i++) {
				// key found
				if (table[index].get(i).key.equals(key))
					//remove key
					table[index].remove(i);
			}
		}
		// key is not in the table remove nothing
		}

	public void put(K key, V value) {
		int index = key.hashCode();
		if(index>=table.length) {
			index = index%table.length;
		}
		if (table[index] == null) {
			table[index] = new LinkedList<Entry<K, V>>();
		}
		/**
		for (Entry<K, V> nextItem : table[index]) {
			if (nextItem.key.equals(key)) {
				nextItem.value = value;
				return;
			}
		}
		**/
		table[index].addFirst(new Entry<K, V>(key, value));
		numKeys++;
		double loadFactor = (double) numKeys / table.length;
		if (loadFactor > LOAD_THRESHOLD) {
		rehash();
		}
	}
	
	public void rehash() {
		LinkedList < Entry <K , V > >[] newTable = (LinkedList<Entry<K, V>>[]) Array.newInstance(LinkedList.class, table.length*2);
		for(int i=0;i<=table.length-1;i++) {
			if(table[i]!=null) {
			newTable[i]=table[i];
			}
		}
		this.table = newTable;
	}
	
	public String toString() {
		StringBuilder strB = new StringBuilder();
		for(int i=0;i<=table.length-1;i++) {
			if(table[i]!=null) {
				for(int j=0;j<=table[i].size()-1;j++) {
					strB.append(table[i].get(j).value + " ");
				}
				strB.append("\n");
			}else {
				strB.append("Linha Vazia" + "\n");
			}
		}
		return strB.toString();
	}
	
	
	@Override
	public Iterator<K> iterator() {
		return new Iter();
	}

	private class Iter implements Iterator<K> {
		
		LinkedList < Entry <K , V > >[] internalTable = table; 
		int value = 0;

		@Override
		public boolean hasNext() {
			return table[value] !=null;
		}
		
		@Override
		public K next() {
			if(this.hasNext()) {
				K val = table[value].get(0).key;
				value++;
				return val;
			}else {
				value++;
				return null;
			}
		}
		
		
	}
	
	
}
