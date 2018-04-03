public class BinarySearch
{
	/** 
	 * Searches the sorted array for the test int. 
	 * Assumes the array is sorted in increasing order (smallest at index 0).
	 * If test is found, returns its index; otherwise, returns -1.
	 **/
	public static int binarySearch( int[] sorted, int test )
	{
		// start the recursion between first and last indices
		return binarySearch( sorted, test, 0, sorted.length -1 );
	}

	/** 
	 * Searches the sorted array for the test number between loIndex and hiIndex, inclusive. 
	 * Assumes the array is sorted in increasing order (smallest at index 0).
	 * If test is found, returns its index; otherwise, returns -1.
	 **/
	private static int binarySearch( int[] sorted, int test, int loIndex, int hiIndex )
	{
		int mid;
		mid=(loIndex+hiIndex)/2;
		
		if (hiIndex<loIndex)
		{
			return -1;
		}

		else if (test== sorted [mid])
		{
			return mid;
		}

		else if (test< sorted [mid])
		{
			hiIndex=mid-1;
			return binarySearch(sorted,test,loIndex,hiIndex);
		}	

		else
		{
			loIndex=mid+1;
			return binarySearch(sorted,test,loIndex,hiIndex);
		}
		
	}

	public static void main ( String [] args)
	{
		int x=1;
		int [] oddNumber= new int [100];
		for (int i=0; i<100; i++)
		{
			oddNumber[i]=x;
			x=x+2;
		}
		int [] testerValue= {26, 78 ,100, 186, 13, 99, 101, 177};
		for (int j=0; j<testerValue.length; j++)
		{
			int returnedValue= binarySearch(oddNumber, testerValue[j] );
			System.out.println (" Searching for" + testerValue [j] + ":" + returnedValue );
		}
	}
}