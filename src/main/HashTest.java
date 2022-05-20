package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashTest {
	
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
