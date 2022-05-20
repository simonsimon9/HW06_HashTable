package main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

class HashTest {

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
	public void test2() {
		assertEquals(true,true);
	}
}
