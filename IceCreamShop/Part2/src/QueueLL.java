

public class QueueLL<T> implements Queue<T> {
	
	private LinkedList<T> list;
	
	public QueueLL()
	{
		list= new LinkedList<T>();
	}

	@Override
	public boolean isEmpty() {
		
		return list.isEmpty();
	}

	@Override
	public T peek() {
		
		return list.getFirst();
	}

	@Override
	public T dequeue() {
		
		T dequeuedData = list.getFirst();
		list.deleteFirst();
		return dequeuedData;
	}

	@Override
	public void enqueue(T data) {
		
		list.insertLast(data);
	}
	
	public String toString(){
		
		return list.toString();
	}
	

}
