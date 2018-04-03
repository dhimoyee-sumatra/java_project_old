package DataStructures;


public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T> {

	private T data;
	BinaryTreeNode<T> leftNode;
	BinaryTreeNode<T> rightNode;
	
	public DefaultBinaryTreeNode() {
		
	}

	/**
	 * it returns the data of the node
	 */
	@Override
	public T getData() {
		return data;
	}

	/**
	 * it sets the data for the node
	 */
	@Override
	public void setData(T data) {
		
		this.data=data;

	}

	/**
	 * it gets the left node for the current node
	 */
	@Override
	public BinaryTreeNode<T> getLeftChild() {
		
		return leftNode;
	}

	/**
	 * it gets the right child for the current node
	 */
	@Override
	public BinaryTreeNode<T> getRightChild() {
		
		return rightNode;
	}

	/**
	 * it sets the left child for the current node
	 */
	@Override
	public void setLeftChild(BinaryTreeNode<T> left) {
		
		this.leftNode= left;

	}

	/**
	 * it sets the right child for the current node
	 */
	@Override
	public void setRightChild(BinaryTreeNode<T> right) {
		
		this.rightNode= right;

	}

	/** 
	 * it checks whether it has any child nodes
	 * returns true if it has no child nodes
	 */
	@Override
	public boolean isLeaf() {
		if(leftNode==null && rightNode==null)
		{
			return true;
		}
		return false;
	}
	
	

}
