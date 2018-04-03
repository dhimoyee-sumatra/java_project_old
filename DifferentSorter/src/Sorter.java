/** 
 * Sorter is an interface. Classes that implement Sorter must
 * provide definitions for the methods declared in this interface.
 * @author ponbarry
 **/
public interface Sorter {

	
	/**
	 * Implementations of this method should modify the passed-in 
	 * int array so that its elements are in ascending, sorted order.
	 **/
	public void sortArrayInPlace( int[] array );

}
