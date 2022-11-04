import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.LinkedList;


public class HashtableOpen <K , V > implements Iterable<K>{

	/** The array holding the entries in this table */
	public Entry <K , V >[] table ;

	/** The number of different keys in this table */
	private int numKeys ;

	/** The number of elements deleted from this table ,
	 * since its inception or since the last
	 * rehash operation */
	private int numDeletes ;

	/** The initial capacity of this table */
	private static final int INITIAL_CAPACITY = 13;

	/** The maximum load factor allowed */
	private static final double LOAD_THRESHOLD = 0.5;

	/** A marker for a deleted entry */
	private final Entry <K , V > DELETED = new Entry <K , V >( null , null );

	/** The key - value pairs in this table */
	private static class Entry <K , V > {
		private K key ;
		private V value ;
		private Entry ( K key , V value ) {
			this . key = key ;
			this . value = value ;
		}
		
	 }

	@SuppressWarnings("unchecked")
	public HashtableOpen () {
		table = (Entry<K, V>[]) Array.newInstance(Entry.class, INITIAL_CAPACITY);
		numKeys = 0;
		numDeletes = 0;
	}

	/**
	 * The index where the entry containing a given key is ,
	 * or the index where it should be included .
	 * @param key The key being sought .
	 */
	private int hash ( K key ) {
		return ( key.hashCode() & 0x7fffffff) % table.length ;
	}
 
	/**
	 * Finds either the target key or the first empty slot
	 * in the search chain using linear probing .
	 * @param key The key of the target object
	 * @return The position of the target or the first empty
	 * slot if the target is not in the table .
	 * @ requires key != null ;
	 * @ requires numKeys + numDeletes < table . length ;
	 */
	
	private int find( K key ) {
		int index = hash ( key );
		while(table[index]!=null && !key.equals(table[index].key)) {
			index = ( index + 1) % table . length ;
		}
		return index ;
	}
	
	public void put(K key, V value) {
		int index = find (key);
		if (table[index] == null) {
			table[index] = new Entry<K, V>(key, value);
			numKeys++;
		double loadFactor = (double) (numKeys + numDeletes) / table.length;
			if (loadFactor > LOAD_THRESHOLD) {
				rehash();
			}
		}else{
			table[index].value = value;
		}
	}
	
	private void rehash() {
		@SuppressWarnings("unchecked")
		Entry <K , V >[] newTable = (Entry<K, V>[]) Array.newInstance(Entry.class, table.length*2);
		for(int i=0;i<=table.length-1;i++) {
			if(table[i]!=null) {
			newTable[i]=table[i];
			}
		}
		this.table = newTable;
	}
	
	public void remove(K key) {
		int index = find(key);
		table[index] = DELETED;
	}
	
	
	private int findWithRemove( K key ) {
		int index = hash ( key );
		while((table[index]!=null && !key.equals(table[index].key)&&(table[index]!=DELETED))) {
			index = ( index + 1) % table . length ;
		}
		return index ;
	}

	public void putWithRemove(K key, V value) {
		int index = findWithRemove (key);
		System.out.println(index);
		if (table[index] == null) {
			table[index] = new Entry<K, V>(key, value);
			numKeys++;
		double loadFactor = (double) (numKeys + numDeletes) / table.length;
			if (loadFactor > LOAD_THRESHOLD) {
				rehash();
			}
		}else if(table[index]==DELETED){
			table[index] = new Entry<K, V>(key, value);
		}else {
			table[index].value = value;
		}
	}

	
	
	public String ToString() {
		StringBuilder strB = new StringBuilder();
		for(int i=0;i<=table.length-1;i++) {
			if(table[i]!=null) {
				if(table[i]==DELETED){
					strB.append("Deleted" + "\n");
				}else {
					strB.append(table[i].value + "\n");
				}
			}else {
				strB.append("Empty" + "\n");
			}
		}
		return strB.toString();
	}
	
	@Override
	public Iterator<K> iterator() {
		return new Iter();
	}

	private class Iter implements Iterator<K> {
		
		Entry<K, V>[] internalTable = table; 
		int value = 0;

		@Override
		public boolean hasNext() {
			return table[value] !=null;
		}
		
		@Override
		public K next() {
			if(this.hasNext()) {
				K val = table[value].key;
				value++;
				return val;
			}else {
				value++;
				return null;
			}
		}
		
		
	}
}
	

