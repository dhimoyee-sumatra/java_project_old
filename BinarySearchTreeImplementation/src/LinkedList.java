
public class LinkedList<T> {
	
	private LinkedListNode<T> head;
	
	public LinkedList()
	{
		head= null;
	}

	/**
	 * Get data stored in head node of list.
	 **/
	public T getFirst()
	{
		if(head!=null)
		{
			T firstData= head.getData();
			return firstData;
		}
		return null;
	}
	 
	/**
	 * Get the head node of the list.
	 **/
	public LinkedListNode<T> getFirstNode()
	{
		return head;
	}
	 
	/**
	 * Get data stored in tail node of list.
	 **/
	public T getLast()
	{
		LinkedListNode<T> next= head;
		T nextData= next.getData();
		while ( next != null)
		{
			nextData= next.getData();
			next= next.getNext();
		}
		
		return nextData;
	}
	 
	/**
	 * Get the tail node of the list.
	 **/
	public LinkedListNode<T> getLastNode()
	{
		LinkedListNode<T> next= head;
		while ( next != null)
		{
			if(next.getNext()==null)
			{
				return next;
			}
			
			next= next.getNext();
		}
		
		return next;
		
	}
	 
	/**
	 * Insert a new node with data at the head of the list.
	 **/
	public void insertFirst( T data )
	{
		 LinkedListNode<T> newNode= new LinkedListNode<T>();
		 newNode.setData(data);
		 newNode.setNext(head);
		 head= newNode;
	}
	 
	/**
	 * Insert a new node with data after currentNode
	 **/
	public void insertAfter( LinkedListNode<T> currentNode, T data )
	{
		LinkedListNode<T> newNode= new LinkedListNode<T>();
		newNode.setData(data);
		LinkedListNode<T> newNext= currentNode.getNext();
		newNode.setNext(newNext);
		currentNode.setNext(newNode);
	}
	
	/**
	 * Insert a new node with data at the tail of the list.
	 **/
	public void insertLast( T data )
	{
		LinkedListNode<T> newNode= new LinkedListNode<T>();
		LinkedListNode<T> next= head;
		if(head==null)
		{
			newNode.setData(data);
			head= newNode;
			return ;
		}
		while ( next != null)
		{
			if(next.getNext()==null)
			{
				next.setNext(newNode);
				newNode.setData(data);
				break;
			}
			
			next= next.getNext();
		}
		
	}
	
	/**
	 * Remove the first node
	 **/
	public void deleteFirst()
	{
		if(head!=null)
		{
			head=head.getNext();
		}
	}
	 
	/**
	 * Remove the last node
	 **/
	public void deleteLast()
	{
		LinkedListNode<T> next= head;
		while ( next != null)
		{
			if(next.getNext().getNext()==null)
			{
				next.setNext(null);
				break;
			}
			
			next= next.getNext();
		}
	}
	 
	/**
	 * Remove node following currentNode
	 * If no node exists (i.e., currentNode is the tail), do nothing
	 **/
	public void deleteNext( LinkedListNode<T> currentNode )
	{
		LinkedListNode<T> nextNode= currentNode.getNext().getNext();
		currentNode.setNext(nextNode);
	}
	
	/**
	 * Return the number of nodes in this list.
	 **/
	public int size()
	{
		int nodeCount= 0;
		LinkedListNode<T> next= head;
		while ( next.getNext() != null)
		{
			nodeCount ++;
			next= next.getNext();
		}
		return nodeCount;
	}
	
	/**
	 * Check if list is empty.
	 * @return true if list contains no items.
	 **/
	public boolean isEmpty()
	{
		if (head==null)
		{
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Return a String representation of the list.
	 **/
	public String toString()
	{
		LinkedListNode<T> next= head;
		String s= "";
		while ( next != null)
		{
			if (next.getNext()!=null)
			{
				s+= next.toString() + " -> ";
			}
			else 
			{
				s+= next.toString();
			}
			next= next.getNext();
		}
		return s;
	}
	
}
