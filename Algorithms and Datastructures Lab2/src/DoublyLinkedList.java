import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data:
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 *
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

	/**
	 * private class DLLNode: implements a *generic* Doubly Linked List node.
	 */
	private class DLLNode
	{
		public final T data; // this field should never be updated. It gets its
		// value once from the constructor DLLNode.
		public DLLNode next;
		public DLLNode prev;

		/**
		 * Constructor
		 * @param theData : data of type T, to be stored in the node
		 * @param prevNode : the previous Node in the Doubly Linked List
		 * @param nextNode : the next Node in the Doubly Linked List
		 * @return DLLNode
		 */
		public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode)
		{
			data = theData;
			prev = prevNode;
			next = nextNode;
		}
	}

	// Fields head and tail point to the first and last nodes of the list.
	private DLLNode head, tail;

	/**
	 * Constructor of an empty DLL
	 * @return DoublyLinkedList
	 */
	public DoublyLinkedList()
	{
		head = null;
		tail = null;
	}

	public int getSize()
	{
		int size = 0;
		DLLNode temp = head;
		while(temp != null)
		{
			temp = temp.next;
			size++;
		}

		return size;
	}





	/**
	 * Tests if the doubly linked list is empty
	 * @return true if list is empty, and false otherwise
	 *
	 * Worst-case asymptotic running time cost: Theta(1)
	 *
	 * Justification:
	 *  This function just checks if the linked list is empty or not by checking if the head is null which is an 
	 *  operation that takes Theta(1) running time.
	 *  
	 */
	public boolean isEmpty()
	{
		if(head == null )
		{
			return true;
		}

		return false;
	}

	/**
	 * Inserts an element in the doubly linked list
	 * @param pos : The integer location at which the new data should be
	 *      inserted in the list. We assume that the first position in the list
	 *      is 0 (zero). If pos is less than 0 then add to the head of the list.
	 *      If pos is greater or equal to the size of the list then add the
	 *      element at the end of the list.
	 * @param data : The new data of class T that needs to be added to the list
	 * @return none
	 *
	 * Worst-case asymptotic running time cost: Theta(N)
	 *
	 * Justification:The for-loop will always iterate over all n elements of the list, and
	          		 therefore the total cost of this method will be( n*Theta(1)) = Theta(n).
	  
	 */

	public void insertBefore(int pos, T data)
	{

		if (isEmpty())
		{
			DLLNode node= new DLLNode(data, null, null);
			head = node;
			tail = node;
		}

		else if (pos <= 0)
		{
			DLLNode node = new DLLNode(data, null, head);
			head.prev = node;
			head = node;
		}
		else if ((pos > 0) && (pos < getSize()))
		{
			DLLNode node;

			if(pos == 1 && getSize() == 2)
			{
				node = head.next;
				DLLNode newNode = new DLLNode(data, head, head.next);
				head.next.prev = newNode;
				head.next = newNode;

			}
			else
			{
				node = head;

				for(int i=0; i<pos; i++)
				{
					node = node.next;
				}
				DLLNode newNode = new DLLNode(data, node.prev, node);
				node.prev.next = newNode;
				node.prev = newNode;
			}
		}
		else if ((pos >= getSize()))
		{
			DLLNode node = new DLLNode(data, tail, null);
			tail.next = node;
			tail = tail.next;
		}

	}






	/**
	 * Returns the data stored at a particular position
	 * @param pos : the position
	 * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
	 *
	 * Worst-case asymptotic running time cost: Theta(N)
	 *
	 * Justification:
	 *  The for-loop will always iterate over all n elements of the list, and
	    therefore the total cost of this method will be( n*Theta(1)) = Theta(n).
	 *
	 */
	public T get(int pos)
	{
		//TODO
		if(isEmpty())
		{
			return null;
		}
		else if(pos > getSize() || pos == getSize())
		{
			return null;
		}
		else if(pos < 0)
		{
			return null;
		}
		else 
		{
			DLLNode node = head;
			for(int i=0; i< pos; i++)
			{
				node = node.next;
			}
			return node.data;
		}

	}

	/**
	 * Deletes the element of the list at position pos.
	 * First element in the list has position 0. If pos points outside the
	 * elements of the list then no modification happens to the list.
	 * @param pos : the position to delete in the list.
	 * @return true : on successful deletion, false : list has not been modified.
	 *
	 * Worst-case asymptotic running time cost: Theta(n)
	 *
	 * Justification:The for-loop will always iterate over all n elements of the list, and
	    therefore the total cost of this method will be( n*Theta(1)) = Theta(n).
	 *  
	 */
	public boolean deleteAt(int pos)
	{

		DLLNode node;
		if(isEmpty())
		{
			return false;
		}
		else if(pos == 0 && getSize() != 1)
		{
			node = head.next;
			head.next = null;
			head = node;
			node.prev = null;
			return true;
		}

		else if(pos == 0 && getSize() == 1)
		{
			head = null;
			tail = null;
			return true;
		}
		else if(pos < 0)
		{
			return false;
		}
		else if(pos >= getSize())
		{
			return false;
		}
		else if(pos == 1 && getSize() == 2)
		{
			//			if(head!=null && head.next != null && head.next.next != null)
			//			{
			//				head.next = head.next.next;
			//				head.next.prev = head;
			//			}
			if(head.next.next == null)
			{
				head.next.prev = head;
				head.next = null;
			}
			return true;
		}
		else
		{
			node = head;
			for(int i=0; i< pos ; i++)
			{
				if(node.next != null)
				{
					node = node.next;
				}
			}
			if(node != null)
			{
				if(node.prev != null && node.next != null)
				{	
					node.next.prev = node.prev;
					node.prev.next = node.next;
				}
				node = null;
				return true;
			}
		}
		return false;
		//TODO




	}

	/**
	 * Reverses the list.
	 * If the list contains "A", "B", "C", "D" before the method is called
	 * Then it should contain "D", "C", "B", "A" after it returns.
	 *
	 * Worst-case asymptotic running time cost: Theta(n)
	 *
	 * Justification:
	 *  The for-loop will always iterate over all n elements of the list, and
	    therefore the total cost of this method will be( n*Theta(1)) = Theta(n).
	 */
	public void reverse()
	{
		DLLNode temp = null;
		DLLNode node = head;
		while(node!=null)
		{
			temp = node.prev;
			node.prev = node.next;
			node.next=temp;
			node= node.prev;
		}
		if(temp!=null)
		{
			head = temp.prev;
		}
	}



	//TODO


	/**
	 * Removes all duplicate elements from the list.
	 * The method should remove the _least_number_ of elements to make all elements uniqueue.
	 * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
	 * Then it should contain "A", "B", "C", "D" after it returns.
	 * The relative order of elements in the resulting list should be the same as the starting list.
	 *
	 * Worst-case asymptotic running time cost: Theta(N^2) N squared*
	 *
	 * Justification:
	 *  The while-loop will always iterate over all n elements of the list, and
	 *  therefore the total cost of this method will be( n*Theta(1)) =  Theta(n).
	 *  Since we have two while loops it would take another(n*Theta(1)=Theta(N) times
	 *  Therefore it takes (Theta(N^2)) times.
	 */
	public void makeUnique()
	{
		DLLNode temp = null;
		DLLNode firstNode =null;
		firstNode = head;
		DLLNode anotherNode =null;
		System.out.println(this.toString());
		while((firstNode!=null)&&(firstNode.next!=null))
		{
			temp=firstNode;
			while(temp.next!=null)
			{

				if(firstNode.data==temp.next.data)
				{
					anotherNode =temp.next;
					temp.next=temp.next.next;

				}
				else
				{
					temp = temp.next;
				}
			}
			firstNode=firstNode.next;
		}







	}
	//TODO



	/*----------------------- STACK API
	 * If only the push and pop methods are called the data structure should behave like a stack.
	 */

	/**
	 * This method adds an element to the data structure.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @param item : the item to push on the stack
	 *
	 * Worst-case asymptotic running time cost: Theta(1)
	 *
	 * Justification:
	 *  This function pushes an item at the top of the stack and we assume that all other methods
	 *  execute theta(1) times.
	 */
	public void push(T item)
	{
		insertBefore(0,item);

	}

	/**
	 * This method returns and removes the element that was most recently added by the push method.
	 * @return the last item inserted with a push; or null when the list is empty.
	 *
	 * Worst-case asymptotic running time cost: Theta(1)
	 *
	 * Justification:
	 *  This function pops an item off of the top of the stack and we assume that all other methods
	 *  execute theta(1) times
	 */
	public T pop()
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			DLLNode temp=head;
			T data = temp.data;
			head=temp.next;
			return data;
		}
	}



	/*----------------------- QUEUE API
	 * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
	 */

	/**
	 * This method adds an element to the data structure.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @param item : the item to be enqueued to the stack
	 *
	 * Worst-case asymptotic running time cost: theta(1)
	 *
	 * Justification:
	 *  This function inserts an item at the tail.There is no iteration so therefore it executes
	 *  at constant time
	 */
	public void enqueue(T item)
	{

		insertBefore(0,item);
	}

	/**
	 * This method returns and removes the element that was least recently added by the enqueue method.
	 * @return the earliest item inserted with an equeue; or null when the list is empty.
	 *
	 * Worst-case asymptotic running time cost: theta(1)
	 *
	 * Justification: This function pops the value at head.There is no iteration so therefore it executes
	 *            	  at constant time.
	 *  
	 */
	public T dequeue()
	{
		DLLNode temp=tail;
		if(isEmpty())
		{
			return null;
		}
		else if(getSize() == 1)
		{
			T data = temp.data;
			tail= temp.prev;
			tail = null;
			head = null;
			return data;
		}
		else
		{
			T data = temp.data;
			tail= temp.prev;
			tail.next = null;
			return data;

		}

	}


	/**
	 * @return a string with the elements of the list as a comma-separated
	 * list, from beginning to end
	 *
	 * Worst-case asymptotic running time cost:   Theta(n)
	 *
	 * Justification:
	 *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
	 *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
	 *  Thus, every one iteration of the for-loop will have cost Theta(1).
	 *  Suppose the doubly-linked list has 'n' elements.
	 *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
	 *    
	 */

	public String toString()
	{
		StringBuilder s = new StringBuilder();
		boolean isFirst = true;

		// iterate over the list, starting from the head
		for (DLLNode iter = head; iter != null; iter = iter.next)
		{
			if (!isFirst)
			{
				s.append(",");
			} else {
				isFirst = false;
			}
			s.append(iter.data.toString());
		}

		return s.toString();
	}


}
