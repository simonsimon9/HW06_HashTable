package main;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class LinearProbingHashTable<K, V> implements GradableMap<K, V> {
	final static int DEFAULT_LENGTH =  11;
	final static double DEFAULT_MAXLOAD = .75;
	private HashTableEntry<K,V>[] data;
	private int size;
	private double maxLoad;
	
	@SuppressWarnings("unchecked")
	public LinearProbingHashTable(){
		// TODO Auto-generated method stub
		this.data = new HashTableEntry[DEFAULT_LENGTH];
		this.size = 0;
		this.maxLoad = DEFAULT_MAXLOAD;
	}
	
	@SuppressWarnings("unchecked")
	public LinearProbingHashTable(int size){
		this();
		this.data = new HashTableEntry[size];
		this.size = size;
		
		
	}

	public LinearProbingHashTable(int size, double loadFactor){
		this(size);
		this.maxLoad = loadFactor;
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.size = 0;
		for(int i = 0; i < data.length; i++) {
			data[i]=null;
		}
		
	}

	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		K target = (K) arg0;
		int targetHashcode = target.hashCode();
		int targetLocation = targetHashcode % size;
		if(targetHashcode == data[targetLocation].getKey().hashCode()) {
			return true;
		}
		
		
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
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
			//if key is not null and was not previously in
			//add key. 
			HashTableEntry<K,V> newEntry = new HashTableEntry(key,value);
			int hashedKey = key.hashCode() % data.length;
	
			System.out.println("hey");
			data[hashedKey] = newEntry;
			
			
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
		// TODO Auto-generated method stub
		
		return data;
	}

	@Override
	public void setArray(HashTableEntry<K, V>[] array) {
		// TODO Auto-generated method stub
		
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