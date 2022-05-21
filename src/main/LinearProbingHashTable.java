package main;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinearProbingHashTable<K, V> implements GradableMap<K, V> {
	final static int DEFAULT_LENGTH =  11;
	final static double DEFAULT_MAXLOAD = .75;
	private HashTableEntry<K,V>[] data;
	private int size;
	private double maxLoad;
	/**
	 * Default constructor that takes in no values. Sets the
	 * capacity of array to 11, size to 0, maxload to .75
	 */
	public LinearProbingHashTable(){
		this(DEFAULT_LENGTH);
	}
	
	/**
	 * Constructor that sets the capacity of array .
	 * Max load is .75 and size is 0. 
	 * @param capacity  the length of array
	 */
	public LinearProbingHashTable(int capacity){
		this(capacity, DEFAULT_MAXLOAD);
		
	}
	/**
	 * Constructor that sets the capacity of array , and load factor
	 * size is 0. 
	 * @param capacity
	 * @param loadFactor
	 */
	public LinearProbingHashTable(int capacity, double loadFactor){
		this.data = new HashTableEntry[capacity];
		this.size = 0;
		this.maxLoad = loadFactor;
	}
	/**
	 * Method sets the size to 0 and the entries array to an empty array
	 */
	@Override
	public void clear() {
		this.size = 0;
		for(int i = 0; i < data.length; i++) {
			data[i]=null;
		}
		
	}

	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub after put
		K target = (K) arg0;
		int targetHashcode = target.hashCode();
		int targetLocation = targetHashcode % size;
		if(targetHashcode == data[targetLocation].getKey().hashCode()) {
			return true;
		}
		
		
		return false;
	}
	
	/**
	 * Method iterates through the hash table for the value. 
	 * @return returns true if value is found and returns false if values is not found.
	 */
	@Override
	public boolean containsValue(Object arg0) {
		for(int i = 0; i < data.length; i++) {
			if(data[i] == null) {
				continue;
			}
			if(data[i].getValue().equals(arg0)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Method 
	 */
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<>();
		for(int i = 0; i < data.length; i++) {
			if(data[i] == null) {
				continue;
			}
			if(data[i] != null) {
				set.add(data[i]);
			
			}
		}
		return set;
	}

	@Override
	public V get(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) throws NullPointerException {
		// TODO Auto-generated method stub
		try {
			if(key == null) { //if key is null, throw exception
				throw new NullPointerException("Key is null");
			}
			
			
			HashTableEntry<K,V> newEntry = new HashTableEntry(key,value);
			int targetIndex = key.hashCode() % data.length;
		
			//if key is not null and was not previously in
			//add key. 
				System.out.println("hey");
				data[targetIndex] = newEntry;
			size++;
			
			
			
		}catch(NullPointerException e) {
			e.printStackTrace();
			System.out.println("Key is null");
			return null;
		}
		//if the key is not null and not previously in table. 
		//add entry and return null
		
		return value;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> otherMap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		ArrayList<V> allValues = new ArrayList<>();
		for(int i = 0; i < data.length; i++) {
			if(data[i] != null && data[i].getValue() != null) {
				allValues.add(data[i].getValue());
			}
		}
		return allValues;
	}

	@Override
	public HashTableEntry<K, V>[] getArray() {		
		return data;
	}

	@Override
	public void setArray(HashTableEntry<K, V>[] array) {
		for(int i = 0; i < array.length; i++) {
			data[i] = array[i];
		}
		
	}

	@Override
	public void setSize(int size) {
		this.size = size;
		
	}
	public void run() {
		for(int i = 0 ; i< data.length; i++) {
			System.out.println(data[i]);
		}
	}
	public static void main(String args[]) {
	//	LinearProbingHashTable<String,Integer> how = new LinearProbingHashTable<>(6);
	//	how.put("hey",5);
	//	how.run();
		
	}

}