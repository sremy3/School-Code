/**
 * Node class for the Doubly Linked List
 */
public class Node<E> {
	
	private E data;
	private Node<E> next;
	private Node<E> prev;
	
	public Node(E data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		String theString = (this.data).toString();
		return theString;
	}
	
	public E getData() {
		return this.data;
	}
	public Node<E> getNext() {
		return this.next;
	}
	public Node<E> getPrev() {
		return this.prev;
	}
	public void setNext(Node<E> newNext) {
		this.next = newNext;
	}
	public void setPrev(Node<E> newPrev) {
		this.prev = newPrev;
	}
}