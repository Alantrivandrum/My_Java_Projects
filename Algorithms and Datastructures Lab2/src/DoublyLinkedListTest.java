import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author Alan Abraham  
 *  
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }
    
    @Test
    public void testGet()
    {
    	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	 testDLL.insertBefore(0,1);
         testDLL.insertBefore(1,2);
         testDLL.insertBefore(2,3);
         testDLL.insertBefore(3,222);
         
    	 
         assertEquals("", "2", testDLL.get(1).toString());
         assertEquals("", "222", testDLL.get(3).toString());
         assertEquals("", null, testDLL.get(-2));
         DoublyLinkedList<Integer> testDLL3 = new DoublyLinkedList<Integer>();
         testDLL3.insertBefore(0,1);
         assertEquals("", null, testDLL3.get(1));
         DoublyLinkedList<Integer>testDLL2 = new DoublyLinkedList<Integer>();
         assertEquals("Checking get() function to check if it returns null for an empty linked list ",null, testDLL2.get(0));
         
         
         
    }
    
    
    @Test
    public void testDeleteAt()
    {
    	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	 DoublyLinkedList<Integer> testDLL2 = new DoublyLinkedList<Integer>();
    	 DoublyLinkedList<Integer> testDLL3 = new DoublyLinkedList<Integer>();
    	 DoublyLinkedList<Integer> testDLL4 = new DoublyLinkedList<Integer>();
    	 DoublyLinkedList<Integer> testDLL5 = new DoublyLinkedList<Integer>();
    	 DoublyLinkedList<Integer> testDLL6 = new DoublyLinkedList<Integer>();
    	 
    	 testDLL5.insertBefore(0,1);
         testDLL5.insertBefore(1,2);
         testDLL5.insertBefore(2,3);
         testDLL5.insertBefore(3,1);
         testDLL5.insertBefore(4,2);
         testDLL5.insertBefore(5,3);
         assertTrue(testDLL5.deleteAt(4));
         
    	 
    	 
    	 
    	 
    	 assertFalse(testDLL4.deleteAt(1));
    	 testDLL3.insertBefore(0,1);
         testDLL3.insertBefore(1,2);
    	 assertTrue(testDLL3.deleteAt(0));
    	 assertEquals("2",testDLL3.toString());
    	 testDLL.insertBefore(0,1);
         testDLL.insertBefore(1,2);
         testDLL.insertBefore(2,3);
         testDLL.insertBefore(3,0);
         testDLL2.insertBefore(0,1);
         
         assertTrue(testDLL.deleteAt(0));
         assertFalse(testDLL.deleteAt(3));
         assertFalse(testDLL.deleteAt(5));
         testDLL.insertBefore(5,null);
         assertFalse(testDLL.deleteAt(5));
         assertFalse(testDLL.deleteAt(21));
         assertTrue(testDLL.deleteAt(1));
         assertFalse(testDLL.deleteAt(-2));
         assertTrue(testDLL2.deleteAt(0));
         assertEquals("",testDLL2.toString());
         
         testDLL6.push(1);
         testDLL6.push(3);
         assertEquals(true, testDLL6.deleteAt(1));
    }
    
    @Test
    public void testReverse()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.reverse();
        assertEquals("3,2,1",testDLL.toString());
    }
    
    @Test
    public void testMakeUnique()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	DoublyLinkedList<Integer> testDLL1 = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,3);
        testDLL1.insertBefore(0,2);
        testDLL1.insertBefore(1,2);
        testDLL1.insertBefore(2,2);
        testDLL1.insertBefore(3,1);
        testDLL1.insertBefore(4,1);
        testDLL1.insertBefore(5,1);
        
        testDLL.makeUnique();
        testDLL1.makeUnique();
        testDLL1.insertBefore(1,3);
        
        assertEquals("2,3,1",testDLL1.toString());
        assertEquals("1,2,3",testDLL.toString());
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,2);
        testDLL.insertBefore(1,1);
        testDLL.insertBefore(2,2);
        testDLL.insertBefore(3,1);
        testDLL.insertBefore(4,1);
        testDLL.insertBefore(5,2);
        testDLL.insertBefore(6,1);
        // 2,1,2,1,1,2,1
        testDLL.makeUnique();
        assertEquals("2,1",testDLL.toString());
        
    }
    
    
    @Test
    public void testPush()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(1);
    	assertEquals("1",testDLL.toString());
    }
    
    @Test
    public void testPop()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(1);
    	assertEquals("1",testDLL.pop().toString());
    	assertEquals(null, testDLL.pop());
    	
    }
    
    @Test
    public void testEnqueue()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.enqueue(1);
    	assertEquals("1",testDLL.toString());
    }
    
    @Test
    public void testDequeue()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.enqueue(300);
    	testDLL.enqueue(200);
    	testDLL.enqueue(100);
    	DoublyLinkedList<Integer> testDLL1 = new DoublyLinkedList<Integer>();
    	assertEquals(null,testDLL1.dequeue());
    	testDLL1.enqueue(100);
    	assertEquals("100",testDLL1.dequeue().toString());
    	
    	assertEquals("300", testDLL.dequeue().toString());
    	assertEquals("100,200",testDLL.toString());
    }
    

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.

}
