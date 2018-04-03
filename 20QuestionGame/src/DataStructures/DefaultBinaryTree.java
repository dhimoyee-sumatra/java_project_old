package DataStructures;


public class DefaultBinaryTree<T> implements BinaryTree<T> {

	protected BinaryTreeNode<T> root;
	
	public DefaultBinaryTree() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * gets the roots for the tree
	 */
	@Override
	public BinaryTreeNode<T> getRoot() {
		
		return root;
	}

	/**
	 * sets the root for the tree
	 */
	@Override
	public void setRoot(BinaryTreeNode<T> root) {
		
		this.root=root;

	}

	/**
	 * checks whether the tree is empty or not
	 */
	@Override
	public boolean isEmpty() {
		
		if(root==null)
		{
			return true;
		}
		return false;
	}

	/**
	 * the method calls the recursive inorderTraversal and pass it the root and linkedList traversal
	 * it returns the traversal
	 */
	@Override
	public LinkedList<T> inorderTraversal() {
		LinkedList<T> traversal= new LinkedList<T>();
		BinaryTreeNode<T> node=root;
		inorderTraversal(node, traversal);
		return traversal;
	}
	
	/**
	 * its the recursive inordertraversal method
	 * @param node
	 * @param traversal
	 */
	private void inorderTraversal(BinaryTreeNode<T> node, LinkedList<T>traversal)
	{
		/**
		 * if the node is null, that is, the tree is empty it doesn't not execute anything
		 */
		if(node==null)
		{
			return;
		}
		
		/**
		 * it inserts the data into the linked list if the node does not have any child 
		 */
		else if(node.isLeaf())
		{
			traversal.insertLast(node.getData());
		}
		/**
		 * it returns the data in the order from left, root to right
		 */
		else
		{
			inorderTraversal(node.getLeftChild(), traversal);
			traversal.insertLast(node.getData());
			inorderTraversal(node.getRightChild(), traversal);
		}
	}

	/**
	 * the method calls the recursive preorderTraversal and pass it the root and linkedList traversal
	 * it returns the traversal
	 */
	@Override
	public LinkedList<T> preorderTraversal() {
		LinkedList<T> traversal= new LinkedList<T>();
		BinaryTreeNode<T> node=root;
		preorderTraversal(node, traversal);
		return traversal;
	}
	
	/**
	 * its the recursive preordertraversal method
	 * @param node
	 * @param traversal
	 */
	private void preorderTraversal(BinaryTreeNode<T> node, LinkedList<T>traversal)
	{
		/**
		 * if the node is null, that is, the empty the tree is empty
		 * it returns nothing
		 */
		if(node==null)
		{
			return;
		}
		/**
		 * it inserts the data into the linked list if the node does not have any child 
		 */
		else if(node.isLeaf())
		{
			traversal.insertLast(node.getData());
		}
		/**
		 * it returns the data in the order from root, left to right
		 */
		else
		{
			traversal.insertLast(node.getData());
			preorderTraversal(node.getLeftChild(), traversal);
			preorderTraversal(node.getRightChild(), traversal);
		}
	}
	

	/**
	 * the method calls the recursive postorderTraversal and pass it the root and linkedList traversal
	 * it returns the traversal
	 */
	@Override
	public LinkedList<T> postorderTraversal() {
		
		LinkedList<T> traversal= new LinkedList<T>();
		BinaryTreeNode<T> node=root;
		postorderTraversal(node, traversal);
		return traversal;
	}
	
	/**
	 * its the recursive postordertraversal
	 * @param node
	 * @param traversal
	 */
	private void postorderTraversal(BinaryTreeNode<T> node, LinkedList<T>traversal)
	{
		/**
		 * if the node is null, that is, the empty the tree is empty
		 * it returns nothing
		 */
		if(node==null)
		{
			return;
		}
		/**
		 * it inserts the data into the linked list if the node does not have any child 
		 */
		else if(node.isLeaf())
		{
			traversal.insertLast(node.getData());
		}
		/**
		 * it returns the data in the order from root, left to right
		 */
		else
		{
			postorderTraversal(node.getLeftChild(), traversal);
			postorderTraversal(node.getRightChild(), traversal);
			traversal.insertLast(node.getData());
		}
	}

	/**
	 * it converts the inorder traversal linked into string
	 */
	@Override
	public String inorderString() {
		LinkedList<T> list= inorderTraversal();
		String str= list.toString();
		return str;
	}

	/**
	 * it converts the preordertraversal linkedlist into string
	 */
	@Override
	public String preorderString() {
		LinkedList<T> list= preorderTraversal();
		String str= list.toString();
		return str;
	}

	/**
	 * it converts the postordertraversal linkedlist into string
	 */
	@Override
	public String postorderString() {
		LinkedList<T> list= postorderTraversal();
		String str= list.toString();
		return str;
	}
	
	/**
	 * the main creates a binary tree step by step and call the pre, in and post order traversals with their respective string methods
	 *  to print the linked lists
	 * @param args
	 */
	public static void main(String [] args)
	{
		DefaultBinaryTree<String> tree= new DefaultBinaryTree<String>();
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
		
		System.out.println(tree.preorderString());
		System.out.println(tree.inorderString());
		System.out.println(tree.postorderString());
	}

}
