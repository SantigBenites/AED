
public class DequeueList {

	public Node[] lista;
	public int inicialSize = 8;
	public int current;
	
	public class Node{
		public Object item;
		public Node next;
		
		/*this method creates a node that can be put inside a DequeueList
		 * 
		 * requires item this is the Object that is going to be put inside the node
		 * requires next this is a reference to the next node in the DequeueList
		 * 
		 */
		public Node(Object item , Node next) {
			this.item = item;
			this.next = next;
		}
	}
	/*this method creates DequeueList of size inicial size
	 * 
	 */
	public DequeueList() {
		lista = new Node[inicialSize];
		current = 0;
	}
	
	/*this method adds a node to the begining of a DequeueList
	 * 
	 * requires e this is the Object that is going to be added to the DequeueList
	 */
	public void addFirst(Object e) {
		
		Node temp;
		
		if(current+1>=lista.length) {
			grow();
		}
		if(lista[1]!=null) {
			temp = new Node( e , lista[1]);
		}else{
			temp = new Node( e , null);
		}
		for(int i=current-1;i>=0;i--) {
			lista[i+1]=lista[i];
		}
		
		lista[0]=temp;
		current++;
	}
	
	/*this returns the first node of a DequeueList
	 * 
	 * returns the first node of a DequeueList if !DequeueList.Empty else it returns null
	 */
	public Node getFirst() {
		if(lista[0]!= null) {
			return lista[0];
		}
		return null;
	}
	
	/*removes the first member of a DequeueList, if the !DequeueList.Empty
	 *
	 */
	public void removeFirst() {
		if(lista[0]!= null) {
			lista[0]=null;
			for(int i = 0;i < current;i++) {
				lista[i]=lista[i+1];
			}
		current--;
		}
	}
	
	/*this method adds a node to the end of a DequeueList
	 * 
	 * requires e this is the Object that is going to be added to the DequeueList
	 */
	public void addLast(Object e) {
		
		Node temp;
		
		if(current+1>=lista.length) {
			grow();
		}
		if(lista[current]!=null) {
			temp = new Node( e , lista[current]);
		}else{
			temp = new Node( e , null);
		}
		lista[current]=temp;
		current++;
	}
	
	/*this returns the last node of a DequeueList
	 * 
	 * returns the last node of a DequeueList if !DequeueList.Empty else it returns null
	 */
	public Node getLast() {
		if(lista[current-1]!= null) {
			return lista[current-1];
		}
		return null;
	}
	
	/*removes the last member of a DequeueList, if the !DequeueList.Empty
	 *
	 */
	public void removeLast() {
		if(lista[current]!= null) {
			lista[current]=null;
			current--;
		}
	}
	
	/*returns the size of a DequeueList
	 *
	 */
	public int size() {
		return current;
	}
	
	/*returns a boolean which represent if a DequeueList is Empty
	 * 
	 * 
	 */
	public boolean isEmpty() {
		return (lista[0]==null);
	}
	
	/* this method is called in the function AddLast(e) and AddFirst(e), it is used when DequeueList doesn't 
	 * have space to new Node to be added to it, it make that the size of DequeueList be equal to size*2
	 */
	public void grow() {
		
		Node[] newStack = new Node[this.lista.length *2];
		for(int i=0;i<this.lista.length;i++) {
			newStack[i] = this.lista[i];
		}
		this.lista = newStack;
	}
	
}
