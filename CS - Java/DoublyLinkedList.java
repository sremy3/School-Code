import java.util.Iterator;
/**
 * This is a Doubly LinkedList that has both a head an tail pointer.
 */

public class DoublyLinkedList<T> implements LinkedListInterface<T>, Iterable<T> {

	private Node<T> head = null;
	private Node<T> tail = null;
	private int size;

	@Override
	public boolean add(int index, T data) {
		if (index < 0 || index > size) {
			return false;
		} else {
			Node<T> curNode = head;
			if (index == size) {
				Node<T> newNode = new Node<T>(data);
				if (size >= 1) {
				    tail.setNext(newNode);
				    newNode.setPrev(tail);
				    newNode.setNext(null);
				    tail = newNode;
				} else if (size == 0) {
					head = newNode;
					tail = newNode;
					newNode.setNext(null);
					newNode.setPrev(null);
				}
				size++;
				return true;
			}
			for (int i = 0; i < size; i++) {
				if (i == index) {
					Node<T> newNode = new Node<T>(data);
					newNode.setNext(curNode);
					if (index == 0) {
						newNode.setPrev(null);
						curNode.setPrev(newNode);
						head = newNode;
						size++;
						return true;
					}
					curNode.getPrev().setNext(newNode);
					newNode.setPrev(curNode.getPrev());
					curNode.setPrev(newNode);
					size++;
					return true;
				}
				curNode = curNode.getNext();
			}
		}
		return true;
	}
	
	@Override
	public void clear() {
		head = null;
		tail = head;
		size = 0;
	}
	
	@Override
	public boolean contains(Object o) {
		Node<T> node = head;
		for (int i = 0; i < size; i++) {
			if ((node.getData()).equals(o)) {
				return true;
			}
			node = node.getNext();
		}
		return false;
	}
	
	@Override
	public T get(int index) {
		Node<T> current = head;
		if (index < 0 || index >= size) {
			return null;
		}
		for (int i = 0; i < size; i++) {
			if (i == index) {
				return current.getData();
			}
			current = current.getNext();
		}
		return null;
	}
	
	@Override
	public int indexOf(T data) {
		Node<T> node = head;
		for (int i = 0; i < size; i++) {
			if ((node.getData()).equals(data)) {
				return i;
			}
			node = node.getNext();
		}
		int notFound = -1;
		return notFound;
	}
	
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}
	
	@Override
	public T remove(Object o) {
		if (size == 0) {
			throw new IllegalStateException("Can't remove on empty list.");
		}
		Node<T> current = head;
		if (size == 1) {
			if ((current.getData()).equals(o)) {
				T data = current.getData();
				head = null;
				tail = head;
				size = 0;
				return data;
			}
		}
		for (int i = 0; i < size; i++) {
			if ((current.getData()).equals(o)) {
				if (i == 0) {
					Node<T> afterNode = current.getNext();
					afterNode.setPrev(null);
					head = afterNode;
					T data = current.getData();
					size--;
					return data;
				}
				if (i == (size - 1)) {
					Node<T> beforeNode = current.getPrev();
					beforeNode.setNext(null);
					tail = beforeNode;
					T data = current.getData();
					size--;
					return data;
				}
				Node<T> beforeNode = current.getPrev();
				Node<T> afterNode = current.getNext();
				beforeNode.setNext(afterNode);
				afterNode.setPrev(beforeNode);
				T data = current.getData();
				size--;
				return data;
			}
			current = current.getNext();
		}
		return null;
	}
	
	@Override
	public T remove(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		if (size == 0) {
			throw new IllegalStateException("Can't remove on empty list.");
		}
		Node<T> current = head;
		if (size == 1) {
			T data = head.getData();
			head = null;
			head = tail;
			size--;
			return data;
		}
		if (index == 0) {
			T data = head.getData();
			head = head.getNext();
			head.setPrev(null);
			size--;
			return data;
		}
		if (index == (size - 1)) {
			T data = tail.getData();
			current = tail.getPrev();
			current.setNext(null);
			tail = current;
			size--;
			return data;
		}
		for (int i = 0; i < size; i++) {
			if (index == i) {
				Node<T> beforeNode = current.getPrev();
				Node<T> afterNode = current.getNext();
				beforeNode.setNext(afterNode);
				afterNode.setPrev(beforeNode);
				T data = current.getData();
				size--;
				return data;
			}
			current = current.getNext();
		}
		return null;
	}
	
	@Override
	public T replace(int index, T data) {
		if (index < 0 || index >= size) {
			return null;
		}
		if (index > 0 && index < (size - 1)) {
		    Node<T> node = head;
		    for (int i = 0; i != index; i++) {
			    node = node.getNext();
		    }
		    Node<T> beforeNode = node.getPrev();
		    Node<T> afterNode = node.getNext();
		    Node<T> newItem = new Node<T>(data);
		    newItem.setNext(afterNode);
		    newItem.setPrev(beforeNode);
		    beforeNode.setNext(newItem);
		    afterNode.setPrev(newItem);
		    T replacedNode = node.getData();
		    return replacedNode;
		}
		if (index == 0) {
		    Node<T> node = head;
		    Node<T> afterNode = node.getNext();
		    Node<T> newItem = new Node<T>(data);
		    newItem.setNext(afterNode);
		    afterNode.setPrev(newItem);
		    head = newItem;
		    T replacedNode = node.getData();
		    return replacedNode;
		}
		if (index == (size - 1)) {
			Node<T> node = tail;
		    Node<T> beforeNode = node.getPrev();
		    Node<T> newItem = new Node<T>(data);
		    newItem.setPrev(beforeNode);
		    beforeNode.setNext(newItem);
		    tail = newItem;
		    T replacedNode = node.getData();
		    return replacedNode;
		}
		return null;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public Node<T> getHead() {
		return head;
	}
	
	@Override
	public void reverseList() {
		if (size > 0) {
		Node<T> current = head;
		for (int i = 0; i < size; i++) {
			Node<T> oldNext = current.getNext();
			Node<T> oldPrev = current.getPrev();
			current.setNext(oldPrev);
			current.setPrev(oldNext);
			current = current.getPrev();
		}
		Node<T> oldHead = head;
		Node<T> oldTail = tail;
		head = oldTail;
		tail = oldHead;
		System.out.println("The list was reversed.");
		} else if (size == 0) {
			System.out.println("Can't reverse an empty list.");
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>();
	}
	@SuppressWarnings({ "hiding", "rawtypes" })
	private class MyIterator<T> implements java.util.Iterator {
		private Node<T> node;
		@SuppressWarnings("unchecked")
		private MyIterator() {
			node = (Node<T>) head;
		}
		public boolean hasNext() {
			return (node != null);
		}
		public T next() {
			if (hasNext()) {
				T data = (T) node.getData();
				node = node.getNext();
				return data;
			} else {
				throw new java.util.NoSuchElementException("Doesn't have next.");
			}
		}
		public void remove() {
			throw new UnsupportedOperationException("Remove not supported.");
		}
	}
	
}