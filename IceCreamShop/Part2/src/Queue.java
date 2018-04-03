
public interface Queue<T> {
	
	public boolean isEmpty();
	
	public T peek();
	
	public T dequeue();
	
	public void enqueue (T data);
	
	public String toString();

}
