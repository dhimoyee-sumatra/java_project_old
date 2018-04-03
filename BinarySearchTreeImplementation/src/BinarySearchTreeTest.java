import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
 
public class BinarySearchTreeTest
{
	public static final int NUM_ELEMENTS = 500;
	private Integer[] randomArray;
 
	private BinarySearchTree<Integer> randomBST;
 
	@Before
	public void setUp() throws Exception
	{
		setupRandomArray();
	}
 
	private void setupRandomArray()
	{
		randomArray = new Integer[NUM_ELEMENTS]; // random integers
		for (int i = 0; i < randomArray.length; i++)
			randomArray[i] = new Integer((int) (Math.random() * 10000) + 1);
 
		randomBST = new DefaultBinarySearchTree<Integer>();
		for (int i = 0; i < randomArray.length; i++)
			randomBST.insert(randomArray[i]);
 
		System.out.println("random inorder traversal is: " + randomBST.inorderString());
	}
 
 
	public void testpreTraversal()
	{
		DefaultBinarySearchTree<String> tree= new DefaultBinarySearchTree<String>();
		DefaultBinaryTreeNode<String> dwarf1= new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> dwarf2= new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> dwarf3= new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> dwarf4= new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> dwarf5= new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> dwarf6= new DefaultBinaryTreeNode<String>();
		
		dwarf1.setData("Happy");
		dwarf2.setData("Doc");
		dwarf3.setData("Sleepy");
		dwarf4.setData("Bashful");
		dwarf5.setData("Grumpy");
		dwarf6.setData("Sneezy");
		
		dwarf1.setLeftChild(dwarf2);
		dwarf1.setRightChild(dwarf3);
		
		dwarf2.setLeftChild(dwarf4);
		dwarf2.setRightChild(dwarf5);
		
		dwarf3.setRightChild(dwarf6);
		
		tree.setRoot(dwarf1);
		
		assertEquals("preoder traversal: ", "Happy -> Doc -> Bashful -> Grumpy -> Sleepy -> Sneezy", tree.preorderString());
	}
	
	public void testpostTraversal()
	{
		DefaultBinarySearchTree<String> tree= new DefaultBinarySearchTree<String>();
		DefaultBinaryTreeNode<String> dwarf1= new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> dwarf2= new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> dwarf3= new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> dwarf4= new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> dwarf5= new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> dwarf6= new DefaultBinaryTreeNode<String>();
		
		dwarf1.setData("Happy");
		dwarf2.setData("Doc");
		dwarf3.setData("Sleepy");
		dwarf4.setData("Bashful");
		dwarf5.setData("Grumpy");
		dwarf6.setData("Sneezy");
		
		dwarf1.setLeftChild(dwarf2);
		dwarf1.setRightChild(dwarf3);
		
		dwarf2.setLeftChild(dwarf4);
		dwarf2.setRightChild(dwarf5);
		
		dwarf3.setRightChild(dwarf6);
		
		tree.setRoot(dwarf1);
		
		assertEquals("preoder traversal: ", "Happy -> Doc -> Bashful -> Grumpy -> Sleepy -> Sneezy", tree.postorderString());
	}
 
	@Test
	public void testTraversal()
	{
		LinkedList<Integer> inorderTraversal = randomBST.inorderTraversal();
 
		// check that it's in order
		assertEquals("random BST in order", true, isOrdered(inorderTraversal));
	}
 
 
	private boolean isOrdered(LinkedList<Integer> list)
	{
		LinkedListNode<Integer> current = list.getFirstNode();
		if (current.getNext() == null)
		{
			// list has size 1, so it's ordered
			return true;
		} else
		{
			// list has size > 1
			LinkedListNode<Integer> currentNext = current.getNext();
 
			while (current.getNext() != null)
			{
				// compare the two
				if (current.getData().compareTo(currentNext.getData()) > 0)
					return false;
				// otherwise, update
				current = current.getNext();
				currentNext = currentNext.getNext();
			}
 
			// if we get here, it was ordered
			return true;
 
		}
	}
 
	@Test
	public void testEltExists()
	{
		int randomIdx = (int) Math.floor(Math.random() * randomArray.length);
		assertEquals("search for element in random tree",
				randomArray[randomIdx],
				randomBST.search(randomArray[randomIdx]).getData());
	}
 
	@Test
	public void testEltNotExist()
	{
		assertEquals("search for element not in random tree", null,
				randomBST.search(new Integer(0)));
	}
 
	@Test
	public void testMin()
	{
		System.out.println( "Min in random tree is: " + randomBST.minElement() );
		assertEquals( "Testing min in random tree", findMin(randomArray),
				randomBST.minElement() );
	}
 
 
	@Test
	public void testMax()
	{
		System.out.println( "Max in random tree is: " + randomBST.maxElement() );
		assertEquals( "Testing max in random tree", findMax(randomArray),
				randomBST.maxElement() );
	}
 
 
	private Integer findMin( Integer[] a )
	{
		// start min at first element
		Integer min = a[0];
 
		// look through the rest of the array
		for ( int i = 1; i < a.length; i++ )
			// if found something smaller
			if ( a[i].compareTo( min ) < 0 )
				// save it
				min = a[i];
 
		// return result
		return min;	
	}
 
	private Integer findMax( Integer[] a )
	{
		// start max at first element
		Integer max = a[0];
 
		// look through the rest of the array
		for ( int i = 1; i < a.length; i++ )
			// if found something smaller
			if ( a[i].compareTo( max ) > 0 )
				// save it
				max = a[i];
 
		// return result
		return max;	
	}
}