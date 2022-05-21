package main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

class HashTest {
	
    //===================begin - Set<Map.Entry<K,V>>entrySet()====================
	@Test
	void entrySetEquals() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(5);
		hashTable.put(0,0);
		hashTable.put(1,1);
		hashTable.put(2,2);
		
		HashTableEntry<Integer,Integer> data1 = new HashTableEntry<>(0,0);
		HashTableEntry<Integer,Integer> data2 = new HashTableEntry<>(1,1);
		HashTableEntry<Integer,Integer> data3 = new HashTableEntry<>(2,2);
		Set<HashTableEntry<Integer, Integer>> set = new HashSet<>();
		set.add(data1);
		set.add(data2);
		set.add(data3);
		
		System.out.println(hashTable.entrySet().toArray().length);
		for(int i = 0 ; i< hashTable.size(); i++) {
			assertEquals(hashTable.entrySet().toArray()[i], set.toArray()[i]);
		}
		assertEquals(hashTable.entrySet().size(), 3);
		
	}
	
    //===================end - Set<Map.Entry<K,V>>entrySet()====================

    //===================begin - containsValue()====================

	@Test 
	void containsValueMethodTrue() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(5);
		hashTable.put(0,0);
		hashTable.put(1,1);
		hashTable.put(2,2);
		
		assertTrue(hashTable.containsValue(2));
		
		
	}
	@Test 
	void containsValueMethodFalse() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(5);
		hashTable.put(0,0);
		hashTable.put(1,1);
		hashTable.put(2,2);
		
		assertFalse(hashTable.containsValue(3));
	}
	
	@Test
	void containsValueMethodStringTrue() {
		LinearProbingHashTable<String,String> hashTable = new LinearProbingHashTable<>();
		hashTable.put("hey","hi");
		assertTrue(hashTable.containsValue("hi"));

	}
	@Test
	void containsValueMethodStringFalse() {
		LinearProbingHashTable<String,String> hashTable = new LinearProbingHashTable<>();
		hashTable.put("hey","hi");
		assertFalse(hashTable.containsValue("no"));

	}
	
    //===================end - containsValue()====================

    //===================begin - void clear() ====================

	@Test 
	public void clearMethod() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(5);
		hashTable.put(0,0);
		hashTable.put(1,1);
		hashTable.put(2,2);
		hashTable.clear();
		
		assertEquals( hashTable.values().toArray().length, 0 );
	}
	
    //===================end - void clear() ====================

	
    //===================begin - Collection<V> values====================
	@Test
	public void collectionValuesReturnNormalValues() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(5);
		hashTable.put(0,0);
		hashTable.put(1,1);
		hashTable.put(2,2);
		
		assertEquals( hashTable.values().toArray()[0],0 );
		assertEquals( hashTable.values().toArray()[1],1 );
		assertEquals( hashTable.values().toArray()[2],2 );
		assertEquals( hashTable.values().toArray().length, 3);
	}
	
	@Test
	public void collectionValuesReturnNullValues() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(5);
		hashTable.put(0,null);
		hashTable.put(1,null);
		hashTable.put(2,null);
		
		assertEquals( hashTable.values().toArray().length, 0 );

	}
	
	@Test
	public void collectionValuesReturnMixedValues() {
		LinearProbingHashTable<Integer,Integer> hashTable = new LinearProbingHashTable<>(5);
		hashTable.put(0,0);
		hashTable.put(1,null);
		hashTable.put(2,2);
		hashTable.put(3, null);
		
		assertEquals( hashTable.values().toArray()[0],0 );
		assertEquals( hashTable.values().toArray()[1],2);
		assertEquals( hashTable.values().toArray().length, 2);
		
	}
	
	@Test
	public void collectionValuesReturnString() {
		LinearProbingHashTable<String,String> hashTable = new LinearProbingHashTable<>();
		hashTable.put("hey","hi");
		
		assertEquals( hashTable.values().toArray()[0],"hi" );
		assertEquals( hashTable.values().toArray().length, 1);
		
		
	}
    //===================end - test Collection<V> values====================

	
}
