package test;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Linked List made to emulate behavior of java.util.LinkedList perfectly
 * @author Zach Kaplan
 * @version 1.0
 * @param <E> Type of data in List
 */
public class LinkedList<E> 
extends AbstractSequentialList<E> 
implements List<E>, Deque<E>, Serializable, Cloneable {
	
	private static final long serialVersionUID = 6174471095411103558L;
	private int size = 0;
	private Node firstNode = null, lastNode = null;
	
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		for(int i=0; i<5; i++) l.add(i);
		l.offerLast(5);
		l.offerFirst(-1);
		l.removeFirstOccurrence(3);
		System.out.println(l);
		System.out.println(l.size());
		
		/*
		ListIterator<Integer> i = l.listIterator();
		while(i.hasNext()) {
			int a = i.next();
			System.out.println(a);
			if(a % 2 == 0) i.remove();
			else {
				i.set(2*a);
				i.add(4*a);
				while(i.hasPrevious()) {
					System.out.println(i.previous());
				}
			}
		}
		System.out.println(l);
		*/
	}
	
	public LinkedList() {
		super(); //default - in case serial ID's are set here and such
	}
	
	public LinkedList(Collection<? extends E> c) {
		super(); //default - in case serial ID's are set here and such
		Iterator<? extends E> i = c.iterator();
		while(i.hasNext()) {
			add(i.next());
		}
		size = c.size();
	}
	
	public void addFirst(E element) {
		add(0, element);
	}

	public void addLast(E element) {
		add(element);
	}

	public Iterator<E> descendingIterator() {
		return new LinkedListIterator(true);
	}

	public E element() throws NoSuchElementException {
		if(size == 0) throw new NoSuchElementException("Empty List");
		return firstNode.data;
	}
	
	public E getFirst() throws NoSuchElementException {
		return element();
	}

	public E getLast() throws NoSuchElementException {
		if(size == 0) throw new NoSuchElementException("Empty List");
		return lastNode.data;
	}

	public boolean offer(E element) {
		add(element);
		return true;
	}

	public boolean offerFirst(E element) {
		addFirst(element);
		return true;
	}

	public boolean offerLast(E element) {
		addLast(element);
		return true;
	}

	public E peek() {
		if(size == 0) return null;
		return element();
	}

	public E peekFirst() {
		if(size == 0) return null;
		return getFirst();
	}

	public E peekLast() {
		if(size == 0) return null;
		return getLast();
	}

	public E poll() {
		if(size == 0) return null;
		return remove();
	}

	public E pollFirst() {
		if(size == 0) return null;
		return removeFirst();
	}

	public E pollLast() {
		if(size == 0) return null;
		return removeLast();
	}

	public E pop() throws NoSuchElementException {
		return removeFirst();
	}

	public void push(E element) {
		addFirst(element);
	}
	
	public E remove() throws NoSuchElementException {
		if(size == 0) throw new NoSuchElementException("Empty List");
		return remove(0);
	}

	public E removeFirst() {
		return remove();
	}

	public boolean removeFirstOccurrence(Object o) {
		Iterator<E> i = iterator();
		while(i.hasNext()) {
			E e = i.next();
			//if both null or equals returns true
			if(o == null ? e == null : o.equals(e)) {
				i.remove();
				return true;
			}
		}
		return false;
	}

	public E removeLast() throws NoSuchElementException {
		if(size == 0) throw new NoSuchElementException("Empty List");
		return remove(size-1);
	}

	public boolean removeLastOccurrence(Object o) {
		Iterator<E> i = descendingIterator();
		while(i.hasNext()) {
			E e = i.next();
			//if both null or equals returns true
			if(o == null ? e == null : o.equals(e)) {
				i.remove();
				return true;
			}
		}
		return false;
	}

	public ListIterator<E> listIterator(int index) {
		return new LinkedListIterator(index);
	}
	
	public int size() {
		return size;
	}
	
	private class Node {
		
		public E data = null;
		private Node next = null, prev = null;
		
		public Node(E data) {
			this.data = data;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node n) {
			next = n;
		}
		
		public Node getPrev() {
			return prev;
		}
		
		public void setPrev(Node n) {
			prev = n;
		}
		
		public String toString() {
			return data.toString();
		}
		
		
	}
	
	private class LinkedListIterator implements ListIterator<E> {
		
		private Node last, current;
		private int index = 0;
		private boolean canRemove = false, canSet = false, reversed = false;
		
		public LinkedListIterator(boolean reversed) {
			if(reversed) {
				current = null;
				index = size; //start at end
				this.reversed = true; //set all next methods to trigger previous methods
			} else {
				current = firstNode;
			}
		}
		
		public LinkedListIterator(int index) throws IndexOutOfBoundsException {
			if(index > size || index < 0) throw new IndexOutOfBoundsException("Index: " + index);
			this.index = index; //see declaration of index
			if(index < size/2) { //since list is bidirectional, this is more efficient
				current = firstNode;
				for(int i=0; i<index; i++) {
					current = current.getNext();
				}
			} else {
				current = lastNode;
				for(int i=size-1; i>index; i++) {
					current = current.getPrev();
				}
			}
		}
		
		public boolean hasNext() {
			if(reversed) return hasPrevious();
			return index < size;
		}

		public E next() throws NoSuchElementException {
			if(reversed) return previous();
			if(!hasNext()) throw new NoSuchElementException("End Of List");
			last = current;
			current = current.getNext();
			index++;
			canRemove = canSet = true;
			return last.data;
		}

		public void remove() throws IllegalStateException {
			if(!canRemove) throw new IllegalStateException();
			canRemove = canSet = false;
			Node next = last.getNext(), prev = last.getPrev();
			if(last == firstNode) {
				firstNode = next;
			} else {
				prev.setNext(next);
			}
			if(last == lastNode) {
				lastNode = prev;
			} else {
				next.setPrev(prev);
			}
			if(current == next) { //if removing after .next(), then must decrease index
				index--;
			}
			last = null;
			size--;
		}

		public void add(E element) {
			canRemove = canSet = false;
			Node add = new Node(element);
			if(size == 0) {
				firstNode = lastNode = add;
				current = null;
			} else if (index == size) {
				lastNode.setNext(add);
				add.setPrev(lastNode);
				lastNode = add;
				current = null;
			} else if (index == 0) {
				add.setNext(firstNode);
				firstNode.setPrev(add);
				firstNode = add;
				current = add.getNext();
			} else {
				current.getPrev().setNext(add);
				add.setPrev(current.getPrev());
				add.setNext(current);
				current.setPrev(add);
			}
			size++;
			index++;
		}

		public boolean hasPrevious() {
			return index > 0;
		}

		public int nextIndex() {
			if(reversed) return previousIndex();
			return index;
		}

		public E previous() throws NoSuchElementException {
			if(!hasPrevious()) throw new NoSuchElementException("Start of List");
			if(index == size) {
				last = current = lastNode;
			} else {
				last = current = current.getPrev();
			}
			index--;
			canRemove = canSet = true;
			return last.data;
		}

		public int previousIndex() {
			return index-1;
		}

		public void set(E element) throws IllegalStateException{
			if(!canSet) throw new IllegalStateException();
			canSet = false;
			last.data = element;
		}
		
	}

}
