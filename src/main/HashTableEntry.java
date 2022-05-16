package main;
import java.util.Map.Entry;

public class HashTableEntry<K,V> implements Entry<K, V> {
	private K key;
	private V value;
	private boolean available;
	
	/**
	 * Constructor specifying the key and value of the entry
	 * @param key 
	 * @param value
	 */
	public HashTableEntry(K key, V value){
		this.key = key;
		this.value = value;
		this.available = false;
	}
	
	public boolean isAvailable(){
		
		return available;
	}
	
	public void setAvailable(boolean isAvailable){
		this.available = isAvailable;	
	}

	
	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}
	
	/**
	 * This method generates a hash code by by performing
	 * an XOR operation with the key hashcode and the value hashcode.
	 * //XOR example: 0101 ^ 1111 = 1010
	 * If one of the values is null, it will return the other's hashcode.
	 * If both are null, it will return 0. 
	 */
	@Override
	public int hashCode(){
		return  (getKey()==null   ? 0 : getKey().hashCode()) ^
			    (getValue()==null ? 0 : getValue().hashCode());
	}
	@Override
	public boolean equals(Object o){
		
		if(!(o instanceof HashTableEntry)) {
			System.out.println("not same class");
			return false;
		}
		
		@SuppressWarnings("unchecked")
		final HashTableEntry<K,V> object = (HashTableEntry<K, V>) o;
		if((this.getKey()==null? object.getKey() == null: this.getKey().equals(object.getKey())) &&  
				(this.getValue() == null ? object.getValue() == null : this.getValue().equals(object.getValue()))) {
			return true;
		}
		
		return false;
		
	}
	
	/*
	public static void main(String args[]) {
		HashTableEntry<String, Integer> newOne = new HashTableEntry<>("try", 5);
		HashTableEntry<String, Integer> newTwo = new HashTableEntry<>("redd", 5);
		System.out.println(newOne.hashCode());
		System.out.println(newOne.getKey().hashCode() ^ newOne.getValue().hashCode());
		System.out.println("This is the key: " + newOne.getKey());
		System.out.println("This is the key's hash code: " + newOne.getKey().hashCode());
		System.out.println("This is the value: " + newOne.getValue());
		System.out.println("This is the value's hash code: " + newOne.getValue().hashCode());
		System.out.println(newOne.equals(newTwo));
	} */
}