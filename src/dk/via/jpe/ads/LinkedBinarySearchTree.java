/**
 * Linked implementation of the binary search tree abstract data type
 * 
 * 10.09.2017 equals replaced by compareTo
 * 28.02.2016 Original version
 */


package dk.via.jpe.ads;

/**
 * Linked implementation of the binary search tree ADT
 *
 * @param <T> Generic type for the values stored in the tree
 */

public class LinkedBinarySearchTree<T extends Comparable<T>>
	extends LinkedBinaryTree<T>
	implements BinarySearchTreeADT<T>
{

	@Override
	public void addElement( T element )
	{
		BinaryTreeNode<T> node = new BinaryTreeNode<T>( element );
		++count;
		
		if( root == null )
			root = node;
		else {
			BinaryTreeNode<T> current = root;
			for(;;)
				if( element.compareTo( current.getElement() ) < 0 ) {
					if( current.getLeft() == null ) {
						current.setLeft( node );
						break;
					} else
						current = current.getLeft();
				} else {
					if( current.getRight() == null ) {
						current.setRight( node );
						break;
					} else
						current = current.getRight();
				}
		}
	}
	

	@Override
	public T removeElement( T element )
		throws ElementNotFoundException
	{
		BinaryTreeNode<T> parent = null;
		BinaryTreeNode<T> current = root;
		
		while( current != null ) {
			int compareResult = element.compareTo( current.getElement() );
			if( compareResult != 0 ) {
				parent = current;
				current = compareResult < 0 ? current.getLeft() : current.getRight();
			} else {
				if( parent == null )
					root = removeNode( current );
				else if( current == parent.getLeft() )
					parent.setLeft( removeNode( current ) );
				else
					parent.setRight( removeNode( current ) );
				
				count--;
				return current.getElement();
			}
		}
		
		throw new ElementNotFoundException( "LinkedBinarySearchTree.removeElement" );
	}
	
	
	private BinaryTreeNode<T> removeNode( BinaryTreeNode<T> node )
	{
		if( node.getLeft() == null )
			return node.getRight();
		else if( node.getRight() == null )
			return node.getLeft();
		else {
			BinaryTreeNode<T> parent = node;
			BinaryTreeNode<T> current = node.getRight();
			
			while( current.getLeft() != null ) {
				parent = current;
				current = current.getLeft();
			}
			
			if( current == parent.getLeft() )
				parent.setLeft( current.getRight() );
			else
				parent.setRight( current.getRight() );
			
			current.setLeft( node.getLeft() );
			current.setRight( node.getRight() );
			
			return current;
		}
	}
	

	@Override
	public void removeAllOccurrences( T element )
		throws ElementNotFoundException
	{
		removeElement( element );
		
		try {
			for(;;)
				removeElement( element );
		} catch( ElementNotFoundException ex ) {
		}
	}
	

	@Override
	public T removeMin()
		throws EmptyCollectionException
	{
		T result = findMin();
		
		try {
			removeElement( result );
		} catch( ElementNotFoundException ex ) {
		}
		
		return result;
	}
	

	@Override
	public T removeMax()
		throws EmptyCollectionException
	{
		T result = findMax();
		
		try {
			removeElement( result );
		} catch( ElementNotFoundException ex ) {
		}
		
		return result;
	}

	@Override
	public T findMin()
		throws EmptyCollectionException
	{
		if( size() == 0 )
			throw new EmptyCollectionException( "LinkedBinarySearchTree.findMin()" );
		
		BinaryTreeNode<T> current = root;
		while( current.getLeft() != null )
			current = current.getLeft();
		
		return current.getElement();
	}
	

	@Override
	public T findMax()
		throws EmptyCollectionException
	{
		if( size() == 0 )
			throw new EmptyCollectionException( "LinkedBinarySearchTree.findMin()" );
		
		BinaryTreeNode<T> current = root;
		while( current.getRight() != null )
			current = current.getRight();
		
		return current.getElement();
	}	
	
	
	@Override
	protected BinaryTreeNode<T> findNode( BinaryTreeNode<T> current, T element )
	{
		if( current == null )
			return null;
		else {
			int compareResult = element.compareTo( current.getElement() );

			if( compareResult == 0 )
				return current;
			else if( compareResult < 0 )
				return findNode( current.getLeft(), element );
			else
				return findNode( current.getRight(), element );
		}
	}

	private static <T>BinaryTreeNode<T> rotateLeft(BinaryTreeNode<T> node){
		throw new UnsupportedOperationException();
	}
}
