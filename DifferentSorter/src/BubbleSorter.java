/** 
 * BubbleSorter class implements the Sorter interface.
 **/
public class BubbleSorter implements Sorter {

	/** 
	 * Constructor
	 */
	public BubbleSorter() { 
		// nothing needs to be done
	}
	
	/**
	 * Uses the bubble sort algorithm to modify the passed-in array
	 * so that its elements are in ascending, sorted order.
	 * Assumes that the passed-in array is an array of int elements.
	 **/
	public void sortArrayInPlace(int[] array) {

		while (!whetherSorted(array))
		{

		

			for (int j=0; j<array.length-1; j++)
				{
					if (array[j]>array[j+1])// checks if the element i
						{
							//swipes the values
							int z=array[j];
							array[j]=array[j+1];
							array[j+1]=z;
						}
				}

		}
		
		// NEEDS TO BE IMPLEMENTED
		
	}
	// helper method for checking whether the sorting is done
	
	public boolean whetherSorted(int[] array){
		for (int i=0; i<array.length-1; i++)
		{
			if(array[i]>array[i+1])// checks if the array is in ascending order
			{
				return false; // if not return false
			}
		}
		return true;
	}


}
