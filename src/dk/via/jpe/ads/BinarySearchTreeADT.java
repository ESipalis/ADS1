/**
 * An implementation of the binary search tree ADT (reworked from Lewis&Chase)
 * 
 * 10-09-2017 Edited
 * 28.02.2016 Original version
 */

package dk.via.jpe.ads;


/**
 * Interface defining the operations of the binary searchtree abstract data type 
 *
 * @param <T> the generic type of elements stored in the tree
 */

public interface BinarySearchTreeADT<T extends Comparable<T>> 
	extends BinaryTreeADT<T>
{
	/**
	 * Adds an element to the binary search tree
	 * 
	 * @param element The element to be added
	 */
	
	public void addElement( T element );
	
	/**
	 * Removes an element from the binary search tree. Removes the first found element, where compareTo returns 0.
	 * 
	 * @param element The element to remove
	 * 
	 * @return The removed element
	 * 
	 * @throws ElementNotFoundException Thrown if the element isn't found
	 */
	
	public T removeElement( T element ) throws ElementNotFoundException;
	
	/**
	 * Removes all occurences of an element from the binary search tree. Removes all elements found, where compareTo returns 0.
	 * 
	 * @param element The element to remove
	 * 
	 * @throws ElementNotFoundException Thrown if no elements equal to element are found
	 */
	
	public void removeAllOccurrences( T element ) throws ElementNotFoundException;
	
	/**
	 * Removes the minimum element from the tree
	 * 
	 * @return The removed element
	 * 
	 * @throws EmptyCollectionException Throw if the tree is empty
	 */
	
	public T removeMin() throws EmptyCollectionException;
	
	/**
	 * Removes the maximum element from the tree
	 * 
	 * @return The removed element
	 * 
	 * @throws EmptyCollectionException Throw if the tree is empty
	 */
	
	public T removeMax() throws EmptyCollectionException;
	
	/**
	 * Finds the minimum element of the tree
	 * 
	 * @return The minimum element
	 * 
	 * @throws EmptyCollectionException Throw if the tree is empty
	 */
	
	public T findMin() throws EmptyCollectionException;
	
	/**
	 * Finds the maximum element of the tree
	 * 
	 * @return The maximum element
	 * 
	 * @throws EmptyCollectionException Throw if the tree is empty
	 */
	
	public T findMax() throws EmptyCollectionException;
}
