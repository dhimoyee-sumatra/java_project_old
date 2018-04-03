
public class DefaultBinarySearchTree<T extends Comparable<T>> extends DefaultBinaryTree<T> implements BinarySearchTree<T> {

	public DefaultBinarySearchTree() {
		super(); 
	}

	/**
	 * its returns the root 
	 */
	@Override
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * it sets the root 
	 */
	@Override
	public void setRoot(BinaryTreeNode<T> root) {
		this.root=root;

	}

	/**
	 * checks whether the binary search tree was true
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
	 *its calls the recursive method and passes it a linkedlist and the root
	 */
	@Override
	public LinkedList<T> inorderTraversal() {
		LinkedList<T> traversal= new LinkedList<T>();
		BinaryTreeNode<T> node=root;
		inorderTraversal(node, traversal);
		return traversal;
	}
	
	/**
	 * its the recursive method 
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
		LinkedList<T> list= inorderTraversal();
		String str= list.toString();
		return str;
	}

	/**
	 * it creates a new node and set it a data 
	 * it calls a recursive method and pass it the root, the data to be entered and a new node
	 */
	@Override
	public void insert(T data) {
		BinaryTreeNode<T> node= root;
		BinaryTreeNode<T> newNode= new DefaultBinaryTreeNode<T>();
		insert(node, data, newNode);

	}
	
	/**
	 * its the recursive method
	 * @param node
	 * @param data
	 * @param newNode
	 */
	private void insert(BinaryTreeNode<T> node, T data, BinaryTreeNode<T> newNode)
	{
		/**
		 * if the root is null
		 * it sets the root to the new data
		 */
		if(root==null)
		{
			newNode.setData(data);
			root=newNode;
		}
		/**
		 * checks if the data is greater than root's data
		 */
		else if(data.compareTo(node.getData())>0)
		{
			/**
			 * checks if the node has a right child
			 */
			if(node.getRightChild()==null)
			{
				newNode.setData(data);
				node.setRightChild(newNode);
			}
			/**
			 * if not it calls the recursive method  and passes it the right child
			 */
			else
			{
				insert(node.getRightChild(), data, newNode);
			}
		}
		/**
		 * checks if the data is lesser than root's data
		 */
		else if(data.compareTo(node.getData())<0)
		{
			/**
			 * checks if the node has a left child
			 */
			if(node.getLeftChild()==null)
			{
				newNode.setData(data);
				node.setLeftChild(newNode);
			}
			/**
			 * if not it calls the recursive method  and passes it the left child
			 */
			else
			{
				insert(node.getLeftChild(), data, newNode);
			}
		}
	}

	/**
	 * its calls the recursive search method 
	 * it passes it a new node and data
	 */
	@Override
	public BinaryTreeNode<T> search(T data) {
		
		BinaryTreeNode<T> node= root;
		BinaryTreeNode<T> newNode= search(node, data);
		return newNode;
	}
	
	/**
	 * its the recursive method for search the specific data
	 * @param node
	 * @param data
	 * @return
	 */
	private BinaryTreeNode<T> search(BinaryTreeNode<T> node, T data )
	{
		/**
		 * when the node is null
		 * it return null
		 */
		if(node==null)
		{
			return null;
		}
		/**
		 * if the data equals to the node's data
		 * it returns the node
		 */
		if(data.equals(node.getData()))
		{
			return node;
		}
		/**
		 * if the data is greater than node's data
		 * calls the recursive method on the right child
		 */
		if(data.compareTo(node.getData())>0)
		{
				return search(node.getRightChild(), data);
			
		}
		/**
		 * if the data is lesser than node's data
		 * calls the recursive method on the left child
		 */
		if(data.compareTo(node.getData())<0)
		{
			
				return search(node.getLeftChild(), data);
		}
		/**
		 * it returns null if it doesnt match all the rest
		 */
		else
		{
			return node=null;
		}
	}

	/**
	 * it calls the recursive method to find the min element
	 * and passes it the root and null data
	 */
	@Override
	public T minElement() {
		BinaryTreeNode<T> node=root;
		T data= null;
		data= minElement(node, data);
		return data;
	}
	
	private T minElement(BinaryTreeNode<T> node, T data){
		/**
		 * if the node is null
		 * it return null
		 */
		if(node==null)
		{
			return null;
		}
		/**
		 * if the left child is null
		 * return the data for the node
		 */
		if(node.getLeftChild()==null)
		{
			data= node.getData();
			return data;
		}
		/**
		 * or else call the method recursively
		 */
		else
		{
			return minElement(node.getLeftChild(), data);
		}
	}

	/**
	 * it calls the recursive method and passes it a node and a null data
	 */
	@Override
	public T maxElement() {
		BinaryTreeNode<T> node=root;
		T data= null;
		data=maxElement(node, data);
		return data;
	}
	
	/**
	 * it finds the max element by recursive running through the binary tree
	 * @param node
	 * @param data
	 * @return
	 */
	private T maxElement(BinaryTreeNode<T> node, T data){
		/**
		 * if the node is null
		 * it returns null
		 */
		if(node==null)
		{
			return null;
		}
		/**
		 * if the right child is null
		 * it returns the data for the node
		 */
		if(node.getRightChild()==null)
		{
			data= node.getData();
			return data;
		}
		/**
		 * or else it calls the function recursively
		 */
		else
		{
			return maxElement(node.getRightChild(), data);
		}
	}

}
