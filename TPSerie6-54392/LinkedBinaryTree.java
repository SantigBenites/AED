
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;


public class LinkedBinaryTree<E> implements Iterable<E>{


	private static class Node<E> {
		private final E data;
		private final Node<E> left;
		private final Node<E> right;

		
		private Node(E data, Node<E> left, Node<E> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	} 
	

	private final Node<E> root;
		

	public int size1() {
		return size(root);
		
	}

	
	
	private int size(Node<E> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + size(node.left) + size(node.right); 
		}
		
	}
	
	public int size;

	public int size() {
		return size;
	}
	
	public boolean isPerfect() {
		return isPerfect(root);
	}

	private boolean isPerfect(Node<E> node) {
		return (node == null||(height(node.left) == height(node.right) &&isPerfect(node.left) && isPerfect(node.right)));			
	}
	

	public boolean isPerfect2() {
		return this.size == (int) Math.pow(2, height()) -1;
	}
	
	public boolean isComplete () {
		return isComplete (root);
	}

	private boolean isComplete (Node<E> node) {
		return (node == null)||(height (node.left) == height (node.right) && isPerfect(node.left) && isComplete(node.right))||height (node.left) == height (node.right) + 1 && isComplete(node.left) && isPerfect(node.right);			
	}
	
	

	@Override
	public String toString () {
		StringBuilder builder = new StringBuilder ("\n");
		ToStringInternal(root, 0, builder);
		return builder.toString();
	}

	private void ToStringInternal(Node<E> node, int depth, StringBuilder builder) {
		spaces(depth, builder);
		if (node == null) {
			builder.append ("Vazia\n");
		}else {
			builder.append (node.data == null ? "Vazia" : node.data.toString());
			builder.append ('\n');
			ToStringInternal (node.left, depth + 1, builder);
			ToStringInternal (node.right, depth + 1, builder);
		}
	}

	private void spaces (int depth, StringBuilder builder) {
		for (int i = 0; i < depth; i++)
			builder.append(' ');
	}

	
	public Iterator<E> iterator() {
		return new PrefixIterator();
	}
	
	private class PrefixIterator implements Iterator<E> {

	
		private Stack<Node<E>> stack;

	
		private PrefixIterator() {
			stack = new Stack<Node<E>>();
			if (root != null)
				stack.push(root);
		}
		
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		public E next() {
			if (stack.isEmpty()) 
				throw new NoSuchElementException();
			
			Node<E> node = stack.peek();
			stack.pop();
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
			return node.data;
		}

	}
	
	private LinkedBinaryTree(Node<E> root) {
		this.root = root; 
	}

	public LinkedBinaryTree() {
		this((Node<E>)null);
		size = 0;
	}

	public LinkedBinaryTree (E data, LinkedBinaryTree<E> left,
			LinkedBinaryTree<E> right) {
		this(new Node<E>(data, left.root, right.root));
		size = 1 + left.size + right.size;
	}


	public LinkedBinaryTree (E data) {
		this(new Node<E>(data, null, null));
		size = 1;
	}


	public boolean isEmpty() {
		return root == null;
	}

	public E data() {
		return root.data;
	}

	public LinkedBinaryTree<E> leftSubtree() {
		return new LinkedBinaryTree<E> (root.left);
	}

	public LinkedBinaryTree<E> rightSubtree() {
		return new LinkedBinaryTree<E> (root.right);
	}

	public boolean isLeaf() {
		return root != null && root.left == null && root.right == null;
	}

	public int height() {
		return height(root);
	}

	private int height (Node<E> node) {
		return node == null?
				0 : 1 + Math.max(height(node.left), height(node.right));
	}

	public int occurrences(E element) {
		return occurrences(element, root);
	}

	private int occurrences(E element, Node<E> node) {
		if (node == null)
			return 0;
		else if (equalReferences(element, node.data))
			return 1 + occurrences(element, node.left) 
					+ occurrences(element, node.right);
		else
			return occurrences(element, node.left) 
					+ occurrences(element, node.right);
	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

	private boolean isBalanced(Node<E> node) {
		return
				node == null
				||
				isBalanced(node.left) && isBalanced(node.right) &&
				Math.abs(height(node.left) - height(node.right)) <= 1;
	}


	
	@SuppressWarnings("unchecked")
	public boolean equals(Object other) {
		return this == other ||
				other instanceof LinkedBinaryTree &&
				equalTrees(this.root, ((LinkedBinaryTree<E>) other).root);
	}

	private boolean equalTrees(Node<E> one, Node<E> other) {
		return
				one == other
				||
				one != null && other != null &&
				equalReferences(one.data, other.data) &&
				equalTrees(one.left, other.left) &&
				equalTrees(one.right, other.right);
	}

	private static boolean equalReferences(Object one, Object other) {
		return one == null ? other == null : one.equals(other);
	}

	public int indexOf(E element) {
		int i = 0;
		for (E e : this)
			if (equalReferences(e, element))
				return i;
			else
				i++;
		return -1;			
	}

	
	public Iterator<E> infixIterator() {
		return new InfixIterator();
	}
	
	
	private class InfixIterator implements Iterator<E> {

		
		private Stack<Node<E>> stack;
		private Node<E> current;
		private InfixIterator() {
			stack = new Stack<Node<E>>();
			current = root;
		}

		public boolean hasNext() {
			return (!stack.isEmpty() || current != null);
		}

		public E next() {
			if (stack.isEmpty() && current == null) 
				throw new NoSuchElementException();

			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			current = stack.peek();
			stack.pop();
			Node<E> node = current;
			current = current.right;

			return node.data;
		}

	}

	public Iterator<E> breadthIterator () {
		return new BreadthIterator<E> (root);
	}

	private static class BreadthIterator<F> implements Iterator<F> {

		private LinkedList<Node<F>> queue;

		public BreadthIterator(Node<F> root) {
			queue = new LinkedList<Node<F>>();
			if (root != null)
				queue.offer(root);
		}

		public boolean hasNext() {
			return !queue.isEmpty();
		}


		public F next() {
			if (queue.isEmpty()) 
				throw new NoSuchElementException();
			Node<F> node = queue.element();
			queue.remove();
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			return node.data;
		}

	}
	
	
	public Iterator<E> sufixIterator () {
		return new SufixIterator();
	}

	
	private class SufixIterator implements Iterator<E> {
	

		private Stack<Node<E>> stack;

		public SufixIterator() {
			stack = new Stack<Node<E>>();
			Node<E> current = root;
			while (current != null) {
				stack.push(current);
				if (current.left != null)
					current = current.left;
				else
					current = current.right;
			}
		}
	
		public boolean hasNext() {
			return !stack.isEmpty();
		}
	
		public E next() {
			if (stack.isEmpty()) 
				throw new NoSuchElementException();

			Node<E> current = stack.peek();
			stack.pop();
			Node<E> node = current;
			if (!stack.isEmpty()){
				Node<E> parent = stack.peek();
				if (current == parent.left) {
					current = parent.right;
					while (current != null){
						stack.push(current);
						if (current.left != null)
							current = current.left;
						else 
							current = current.right;
					}
				}
			}
			return node.data;
		}
	
	}
	


}
