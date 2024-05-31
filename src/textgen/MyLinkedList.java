package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head=new LLNode<E>(null);
		tail=new LLNode<E>(null);
		head.next=tail;
		tail.prev=head;
		size=0;
	
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null)
			throw new NullPointerException("add null to linked List");
		else
		{
			LLNode<E> newNode=new LLNode<E>(null);
			newNode.data=element;
			// prev node point to new node
			tail.prev.next=newNode;
			// newNode prev points to prev
			newNode.prev=tail.prev;
			//newNode next points to tail
			newNode.next=tail;
			//tail prev points to newNode
			tail.prev=newNode;
			size++;
			return true;
		}
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index<0 || index >= size )
			throw new IndexOutOfBoundsException( "Linked List get() index out of bounds");
		else
		{
			int n=0;
			LLNode<E> cur =head;
			while(cur.next != null)
			{
				if (n == index)
				{
					return cur.next.data;
				}
				cur=cur.next;
				n++;
			}
			
		}
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		
				if(element == null)
					throw new NullPointerException("add null to linked List");
				else
				{
					if(index<0 || index > size )
						throw new IndexOutOfBoundsException( "Linked List get() index out of bounds");
					LLNode<E> targetIndexNode=head.next;
					for(int j=0;j<index;j++)
					{
						targetIndexNode=targetIndexNode.next;
					}
					LLNode<E> newNode=new LLNode<E>(null);
					newNode.data=element;
					// prev node point to new node
					targetIndexNode.prev.next=newNode;
					// newNode prev points to prev
					newNode.prev=targetIndexNode.prev;
					//newNode next points to tail
					newNode.next=targetIndexNode;
					//tail prev points to newNode
					targetIndexNode.prev=newNode;
					size++;
				}
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		
			if(index<0 || index >= size )
				throw new IndexOutOfBoundsException( "Linked List get() index out of bounds");
			LLNode<E> targetIndexNode=head.next;
			for(int j=0;j<index;j++)
			{
				targetIndexNode=targetIndexNode.next;
			}
			targetIndexNode.next.prev=targetIndexNode.prev;
			targetIndexNode.prev.next=targetIndexNode.next;
			size--;
			return targetIndexNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if(element == null)
			throw new NullPointerException("add null to linked List");
		else
		{
			if(index<0 || index >= size )
				throw new IndexOutOfBoundsException( "Linked List get() index out of bounds");
			LLNode<E> targetIndexNode=head.next;
			for(int j=0;j<index;j++)
			{
				targetIndexNode=targetIndexNode.next;
			}
			E oldData=targetIndexNode.data;
			targetIndexNode.data=element;
			return oldData;
		}  
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
