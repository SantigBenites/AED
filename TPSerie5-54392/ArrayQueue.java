import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue <E> implements Cloneable, Iterable<E> {
	/* The length of initial array . */
	private static final int DEFAULT_CAPACITY = 4;
	
	/* The elements on the queue . */
	private E [] q;
	
	/* The index of the element at the front of the queue ,
	* that is , the first element to exit the queue .
	*/
	private int head;
	
	/* The index of the rear of the queue , that is ,
	* the index where the next element will be added ;
	*/
	private int tail;
	
	/* The number of elements in the queue . */
	private int size;
	
	/**
	* Construct an empty queue .
	*/
	public ArrayQueue(){
		q = (E[]) new Object [DEFAULT_CAPACITY];
		head = 0;
		size = DEFAULT_CAPACITY;
		tail = 0;
	}
	
	public void enqueue(E item){
		if(head+1 >= size) {
			reallocate();
			size = size*2;
		}
		for(int i=head;1<=i;i--) {
			q[i]=q[i-1];
		}
		q[0] = item;
		head++;
	}
	
	public boolean isEmpty(){
		return q[0] == null;
	}
	
	public E front(){
		return q[head-1];
	}
	
	public void dequeue(){
		q[head-1]=null;
		head--;
	}
	
	/*
	* Move the elements in the array to a larger array .
	*/
	private void reallocate(){
		E[] arrayInicial = q;
		E[] arrayFinal = (E[]) new Object [size*2];
		for(int i=0;i<=q.length-1;i++) {
			arrayFinal[i] = arrayInicial[i];
		}
		q = arrayFinal;
	}
	
	/**
	 * Ex 2 b)
	 * 
	 * 
	**/
	/**
	private void reallocate2(){
		E[] arrayInicial = q;
		E[] arrayFinal = (E[]) new Object [size*2];
		System.arraycopy(arrayInicial, 0, arrayFinal, 0, q.length);
		q = arrayFinal;
	}
	**/
	
	/**
	* The textual representation of this queue ,
	* in the form " <a, b, c, <".
	*/
	public String toString(){
		StringBuilder strB = new StringBuilder();
		strB.append('<');
		for(int i=0;i<=head-1;i++) {
			strB.append(q[i]);
			strB.append(", ");
		}
		strB.append('<');
		return strB.toString();
	}
	
	/**
	* Is this queue equal to a given object ?
	* @param other The object .
	*/
	public boolean equals (Object other){
		return q.equals(other);	
	}
	
	public ArrayQueue<E> clone (){
		ArrayQueue<E> clone = new ArrayQueue<E>();
		clone.q = q;
		clone.size = size;
		clone.head = head;
		clone.tail = tail;
		return clone;
	}

	@Override
	public Iterator<E> iterator() {
		return  new arrayIterator<E>(q);
	}
	
	public class arrayIterator<E> implements Iterator<E>{

		int indexPosition = 0;
		E[] internalarray;
		
		public arrayIterator(E[] internalarray) {
			this.internalarray=internalarray;
		}
		
		public boolean hasNext() {
			if(internalarray[indexPosition+1] == null) {
				return false;
			}else {
				return true;
			}
		}

		public E next() {
			if(internalarray[indexPosition+1] == null) {
				throw new NoSuchElementException();
			}
			E result = internalarray[indexPosition+1];
			indexPosition = indexPosition + 1;
			return result;
		}
		
	}
}
