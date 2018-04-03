
public class LinkedListNode<T> {
	T data;
	LinkedListNode<T> node;

	/**
	 * Set the data stored at this node.
	 **/
	public void setData( T data )
	{
		this.data= data;
	}
	 
	/**
	 * Get the data stored at this node.
	 **/
	public T getData()
	{
		return data;
	}
	 
	/**
	 * Set the next pointer to passed node.
	 **/
	public void setNext( LinkedListNode<T> node )
	{
		this.node= node;
	}
	 
	/**
	 * Get (pointer to) next node.
	 **/
	public LinkedListNode<T> getNext()
	{
		return node;
	}
	 
	/**
	 * Returns a String representation of this node.
	 **/
	public String toString()
	{
		return getData().toString();
		
	}
	
}
