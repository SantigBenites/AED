import java.util.LinkedList;

public class SLLQueue<E> {

	LinkedList lista;
	NO First;
	NO Last;
	
	private class NO{
		
		private NO next;
		private E item;
		
		private NO(E item){
			this.next = next;
			this.item = item;
		}
		
	}
	
	public SLLQueue(){
		lista = new LinkedList();
	}
	
	public void enqueue ( E e ) {
		NO node = new NO( e );
		if(!lista.isEmpty()) {
			NO nodeAfter = (SLLQueue<E>.NO) lista.removeLast();
			node.next = nodeAfter;
			lista.addLast(nodeAfter);	
		}
		lista.addLast(node);
	}
	
	public void dequeue () {
		if(lista.isEmpty()) {
			return;
		}
		lista.removeFirst();
		if(!lista.isEmpty()) {
		NO node = (SLLQueue<E>.NO) lista.getFirst();
		node.next = null;
		}
	}
	
	public E front() {
		NO node = (SLLQueue<E>.NO) lista.getFirst();
		return node.item;
	}
	
	public boolean IsEmpty() {
		return lista.isEmpty();
	}
	
}
