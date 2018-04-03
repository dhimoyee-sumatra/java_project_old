
public class StackLL<T> implements Stack<T> {
	
	private LinkedList<T> list;
	
	public StackLL()
	{
		list= new LinkedList<T>();
	}

	
	public boolean isEmpty() 
	{
		return list.isEmpty();
	}

	public T peek() 
	{
		return list.getFirst();
	}

	public T pop() 
	{
		T poppedData= list.getFirst();
		list.deleteFirst();
		return poppedData;
	}

	public void push(T data) 
	{
		list.insertFirst(data);
	}

	public String toString()
	{
		return list.toString();
	}
}
