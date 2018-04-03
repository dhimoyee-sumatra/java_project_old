/** 
 * SelectionSorter class implements the Sorter interface.
 * @author 
 **/
public class SelectionSorter implements Sorter {

	/** 
	 * Constructor
	 */
	public SelectionSorter() { 
		// nothing needs to be done
	}
	
	/**
	 * Uses the selection sort algorithm to modifies the passed-in 
	 * array so that its elements are in ascending, sorted order.
	 * Assumes that the passed-in array is an array of int elements.
	 **/
	public void sortArrayInPlace(int[] array) {
		for(int i=0; i<array.length; i++)
		{
			// declare and initialize two variables
			int z= array [i];
			int a= i;
			for (int j=i; j<array.length; j++)// loop to run through the array
			{
				if(array[j]<z)// compares the value of the element with z and if is smaller
				{
					z=array[j];//updates the value of the variables
					a=j;
				}
			}
			int b= array[i];//saves the variable
			array[i]=z;// then update the array with the smallest element
			array[a]=b;// exchanges the values
		
		}
	}
	



}
