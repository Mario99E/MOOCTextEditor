/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =1000; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		shortList.add("C");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check middle", "B", shortList.get(1));
		assertEquals("Check Last", "C", shortList.get(2));
		
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size: check size of short list ", 3, shortList.size());
		assertEquals("Size: check size of long list ", LONG_LIST_LENGTH, longerList.size());
		assertEquals("Size: check size of empty list ", 0, emptyList.size());
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        //add index out of bounds
		try
		{
			emptyList.add(5,33);
			fail("check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		//add null
		try
		{
			shortList.add(1,null);
			fail("check out of bounds");
		}
		catch (NullPointerException e) {
			
		}
		
		//add to empty list
		emptyList.add(0,75);
		assertEquals("Check add to empty", (Integer)75, emptyList.get(0));
		//add to short List 
		
		shortList.add(1,"X");
		assertEquals("Check add to shortlist", "X", shortList.get(1));
		//add to size
		shortList.add(4,"L");
		assertEquals("Check add to end", "L", shortList.get(4));
		
		//add in miidel
		int n=LONG_LIST_LENGTH/2;
		longerList.add(n,565);
		assertEquals("Check add to middle in long List", (Integer)565, longerList.get(n));
		assertEquals("Check size", LONG_LIST_LENGTH+1 , longerList.size());
		
		
		
		
		
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    //set out of bounds 
		try
		{
			emptyList.set(5,33);
			fail("check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		//set null
		try
		{
			shortList.set(1,null);
			fail("check out of bounds");
		}
		catch (NullPointerException e) {
			
		}
		//
		String sReturned=shortList.set(0, "Z");
		assertEquals("Check size", 3 , shortList.size());
		assertEquals("Check set data", "Z" , shortList.get(0));
		assertEquals("Check return data", "A" , sReturned);
		
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
