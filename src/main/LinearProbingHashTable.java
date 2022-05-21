package main;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
	/**
	 * Method checks the hash table for key.
	 * @return boolean representation whether the key is present or not. 
	 */
	@Override
	public boolean containsKey(Object arg0) {
		
		// TODO Auto-generated method stub after put
		
			int targetIndex = arg0.hashCode() % data.length;
			int runner = targetIndex;
		
			do {
				if(data[runner]==null) {
					return false;
				}
				
				if(data[runner].isAvailable()) {
					runner = runner==data.length ?runner=0:runner+1;
					continue;
				}
				
				if(data[runner].getKey().hashCode() == arg0.hashCode() && !data[runner].isAvailable()) {
					return true;
				}
				runner = runner==data.length ?runner=0:runner+1;
			}while(data[runner]!= null);
		
		
		
		return false;
	}
	
	/**
	 * Method iterates through the hash table for the value. 
	 * @param arg0 the value
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
	 * Method adds all the hash table entries into set.
	 * @return a set of hash table entries.
	 */
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<>();
		for(int i = 0; i < data.length; i++) {
			if(data[i] == null) {
				continue;
			}
			if(data[i] != null && !data[i].isAvailable()) {
				set.add(data[i]);
			
			}
		}
		return set;
	}
	/**
	 * Method retrieves the value by key. Hashes the key to find the index in 
	 * which the value could possibly be. If the hashed key value index location 
	 * is empty, returns null. If the hashed key value index location is available, go to the 
	 * next index to check if the element was moved. If the hashed key value is equal to the key 
	 * in the entry, it will return the value. 
	 * 
	 * @return The data representational of the value retrieved by key. 
	 */
	@Override
	public V get(Object arg0) throws NullPointerException {
		
		try {
			if(arg0==null) {
				throw new NullPointerException("null key");
			}
			int targetIndex = arg0.hashCode() % data.length;
			
			
			int runner = targetIndex == data.length - 1? 0: targetIndex;
			
			do {
				if(data[runner] == null) {
					return null;
				}
				if(data[runner].isAvailable()) {
					runner = runner==data.length ?runner=0:runner+1;
					continue;
				}
				if(data[runner].getKey().hashCode() == arg0.hashCode() && !data[runner].isAvailable()) {
					return data[runner].getValue();
				}
				runner = runner==data.length ?runner=0:runner+1;

			
			}while(data[runner]!= null);
		
		}catch(NullPointerException e) {
			e.printStackTrace();
			System.out.println("Key is null");
			return null;
		}
		return null;
	}
	/**
	 *  Method checks if the hash table is empty
	 *  @return boolean value representation if the table is empty. 
	 */
	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		Set<K> set = new HashSet<>();
		for(int i = 0; i < data.length; i++) {
			if(data[i] == null) {
				continue;
			}
			if(data[i] != null && !data[i].isAvailable()) {
				set.add(data[i].getKey());
			
			}
		}
		return set;
	}
	/**
	 * Method puts in the hash table entry into the table by hashing the key. 
	 * The hashed key is then moduled by the length of array in order to 
	 * determine the index.
	 * 
	 * Method takes in consideration of collisions and it performs linear
	 * probing in order to find free space. 
	 * 
	 * @return the old value that is replaced or null if not replacing a number. 
	 */
	@Override
	public V put(K key, V value) throws NullPointerException {
		boolean returnValue = false;
		try {
			if(key == null) { //if key is null, throw exception
				throw new NullPointerException("Key is null");
			}
			
			
			HashTableEntry<K,V> newEntry = new HashTableEntry(key,value);
			
			int targetIndex = key.hashCode() % data.length;
			
			int runner = targetIndex == data.length - 1? 0: targetIndex;
			
			do {
				
				if(data[runner] == null) { 
					data[runner] = newEntry;
					this.size++;
					break;
				}
				
				if(data[runner].isAvailable()) {
					data[runner] = newEntry;
					data[runner].setAvailable(false);
					this.size++;
					break;
				}
				
				if(data[runner].getKey().hashCode() == key.hashCode()) {
					V oldvalue= data[runner].getValue();
					data[runner] = newEntry;
					returnValue = true;
					break;
				}
				
				runner = runner==data.length ?runner=0:runner+1;
				
			}while(targetIndex != runner);
			
			
			double currentLoadFactor = (double)size / (double)data.length;
			
			if(currentLoadFactor > this.maxLoad) {
				HashTableEntry<K,V>[] newArray = new HashTableEntry[2*data.length];
				for(int i = 0; i < data.length; i++) {
					newArray[i] = data[i];
				}
				this.data = newArray;
			}
			
			
		}catch(NullPointerException e) {
			e.printStackTrace();
			System.out.println("Key is null");
			return null;
		}
		//if the key is not null and not previously in table. 
		//add entry and return null
		if(returnValue) {
			return value;
		}else {
			return null;
		}
		
	}
	/**
	 * Method puts all of the entries from othermap onto 
	 * the current hash table. 
	 */
	@Override
	public void putAll(Map<? extends K, ? extends V> otherMap) {
		// TODO Auto-generated method stub
		for (Entry<? extends K, ? extends V> entry : otherMap.entrySet()){
			this.put(entry.getKey(), entry.getValue());
		}
	}
	/**
	 * Method removes the hash entry with the same hash code as keyl
	 * If the method does not find the key, it performs linear probing
	 * if it detects the index was overwritten. 
	 * @return representation of the removed key
	 */
	@Override
	public V remove(Object key) throws NullPointerException{
		// TODO Auto-generated method stub
		try {

			int targetIndex = key.hashCode() % data.length;
			int runner = targetIndex;
			
			do {
				if(data[runner]==null) {
					throw new NullPointerException("No");
				}
				
				if(data[runner].isAvailable()) {
					runner = runner==data.length ?runner=0:runner+1;
					continue;
				}
				if(data[runner].getKey().hashCode() == key.hashCode() && !data[runner].isAvailable()) {
					data[runner].setAvailable(true);
					return data[runner].getValue();
				}
				runner = runner==data.length ?runner=0:runner+1;

			
			}while(data[runner]!= null);
		
		}catch(NullPointerException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	/**
	 * Method that returns the number of entries in the hash table. 
	 * @return integer representing the number of entries in the hash table. 
	 */
	@Override
	public int size() {
		return size;
	}
	/**
	 * Returns a collection of all the values in the hash table
	 * @return arrayList of values
	 */
	@Override
	public Collection<V> values() {
		ArrayList<V> allValues = new ArrayList<>();
		for(int i = 0; i < data.length; i++) {
			if(data[i] != null && data[i].getValue() != null) {
				allValues.add(data[i].getValue());
			}
		}
		return allValues;
	}
	/**
	 * Method returns a reference to the array containing the hash
	 * table entries. 
	 */
	@Override
	public HashTableEntry<K, V>[] getArray() {		
		return data;
	}
	/**
	 * Method deep copies the parameter array into the current array
	 * 
	 */
	@Override
	public void setArray(HashTableEntry<K, V>[] array) {
		for(int i = 0; i < array.length; i++) {
			data[i] = array[i];
		}
		
	}
	/**
	 * Methods sets the size of the hash table which represents 
	 * the number of elements in the data strucuture. 
	 */
	@Override
	public void setSize(int size) {
		this.size = size;
		
	}
	public void run() {
		for(int i = 0 ; i< data.length; i++) {
			if(data[i] != null) {
				System.out.println("key: "+data[i].getKey() + " value:"+data[i].getValue()+ " isAvailable: " +data[i].isAvailable());
			}
			if(data[i] == null) {
				System.out.println("null space");
			}
		}
	}
	public static void main(String args[]) {
	//	LinearProbingHashTable<String,Integer> how = new LinearProbingHashTable<>(6);
	//	how.put("hey",5);
	//	how.run();
		
	}

}