import java.util.Iterator;

/** A class that implements a binary search tree .
*
* @param <E> the type of elements ;
* required to be comparable .
**/
public class BinarySearchTree<E> implements Comparable <E>, Cloneable , Iterable <E > {

	/** The root of the binary tree */
	public Node <E> root ;

	private BinarySearchTree ( Node <E> root ) {
		this . root = root ;
	}	

	public BinarySearchTree(){
		this ( null ); 
	}
	
	public Boolean isEmpty() {
		return this.root.data == null;
	}
	
	public Boolean isEmpty(Node<E> e) {
		return e.equals(null);
	}
	
	public Node <E> rootGet(){
		return this.root;
	}
	
	public Boolean treeSearch( Node <E> T, E item) {
		if(isEmpty(T)) {
			return false;
		}else if( item == T.data) {
			return true;
		}else if((int)item <= (int)T.data) {
			if(T.left!=null) {
			return treeSearch(T.left,item);
			}else {
				return false;
			}
		}else {
			if(T.right!=null) {
			return treeSearch(T.right,item);
			}else {
				return false;
			}
		}
	}

	/**
	 * Does a given element is in this tree ?
	 * @param target The Comparable object being sought
	 * @return true , if found , otherwise false
	 * @requires target != null
	 */
	public boolean search(E target) {
		return treeSearch(this.root,target);
	}
	
	public Node <E> addInt( Node <E> T, E item) {
		if (T == null) {
			return new Node<E>(item);
		}	
		int compResult = ((Comparable<E>) item).compareTo(T.data);
		if (compResult == 0) {
			return T;
		} else if (compResult < 0) {
			T.left = addInt(T.left, item);
			return T;
		} else { 
			T.right = addInt(T.right, item);
			return T;
		}
	}

	/**
	 * Add an element to this tree
	 * @param target The object being inserted
	 * @requires target != null
	 */
	public void add(E target) {
		 root = addInt(root, target);
	}

	/**
	 * Delete an element from this tree
	 * @param target The object to be deleted
	 * @requires target != null
	 */

	public void delete(E target){

	}
	
	@SuppressWarnings("unchecked")
	public Node<E> largerThanInt(Node<E> root ,E e){
		if (root == null)
			return null;
		if (((Comparable<E>) root.data).compareTo(e) < 0)
			return largerThanInt(root.right, e);
		else
			return new Node<E>(	root.data, largerThanInt(root.left, e),root.right);

	}
	
	/**
	 * returns a BinarySearchTree with all the elements bigger than e
	 * 
	 * @param e value that the BinarySearchTree is bigger
	 * @return BinarySearchTree which all elements are bigger than e
	 */
	
	public BinarySearchTree<E> largerThan(E e){
		if(!treeSearch(root,e)) {
			return null;
		}else {
			return new BinarySearchTree<E>(largerThanInt(root ,e));
		}
	}

	/**
	 * A class describing a tree node
	 */
	private static class Node <E> implements Comparable<E> {

		public E data ;
		public Node <E > left ;
		public Node <E > right ;

		/**
		 * Construct a node with given data and no children .
		 * @param data The data to store in this node
		 */
		private Node ( E data ) { this ( data , null , null ); }

		/**
		 * Construct a node with given data and two children .
		 * @param data The data to store in this node
		 * @param left The left child
		 * @param right The right child
		 */
		private Node ( E data , Node <E > left , Node <E > right ) {
			this . data = data ;
			this . left = left ;
			this . right = right ;
		}

		@Override
		public int compareTo(E o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(E o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

