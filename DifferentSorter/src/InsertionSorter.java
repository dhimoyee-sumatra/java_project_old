/** 
 * InsertionSorter class implements the Sorter interface.
 * @author 
 **/
public class InsertionSorter implements Sorter {

	/** 
	 * Constructor
	 */
	public InsertionSorter() { 
		// nothing needs to be done
	}
	
	/**
	 * Uses the insertion sort algorithm to modify the passed-in array
	 * so that its elements are in ascending, sorted order.
	 * Assumes that the passed-in array is an array of int elements.
	 **/
	public void sortArrayInPlace(int[] array) {

		for (int i=0; i< array.length-1; i++)// loop to go through the entire array
		{
			if(array[i]>array[i+1])// compares the subsequent elements
			{
				int z= array[i+1];// saves the value of element in the variable z
				array[i+1]=array[i];// assigns the second element in the array the value of the first
				array[i]=z;// then assigns the first the value of z

				for (int j=i;j>0;j--)// loop to go through from i to the first of the array
				{
					if (array[j-1]>array[j])// compares the subsequent elements
					{
						int k=array[j];// saves the value of the element 
						array [j]=array[j-1];// exchange values
						array[j-1]=k;//assigns the second value of k
					}
				}
			}
		}
		
	
	}
	
	

}
