package dsa.ch5;

import java.util.ArrayList;
import java.util.List;

/**
 * Linked List implementation that supports sorting.
 * 
 * @author ender
 */
public class LinkedList<T extends Comparable<T>> {

	public static class Link<E extends Comparable<E>> {
		E data;
		Link<E> next;

		public Link(E data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	protected Link<T> first;
	protected final boolean sorted;

	public LinkedList() {
		sorted = false;
	}

	public LinkedList(boolean sorted) {
		this.sorted = sorted;
	}

	public void insert(T data) {
		Link<T> link = new Link<>(data);
		Link<T> pre, curr;
		pre = curr = first;
		if (first == null) {
			first = link;
		} else {
			while (curr != null && sorted(curr, data)) {
				pre = curr;
				curr = curr.next;
			}
			if (first == curr) {
				first = link;
			} else {
				pre.next = link;
			}
			link.next = curr;
		}
		postInsert(link, pre, curr);
	}

	public List<T> delete(T data) {
		Link<T> pre = first;
		Link<T> curr = first;
		List<T> list = new ArrayList<>();
		while (curr != null) {
			if (curr.data.equals(data)) {
				pre.next = curr.next;
				if (curr == first) {
					first = curr.next;
				}
				list.add(curr.data);
			} else {
				pre = curr;
			}
			curr = curr.next;
		}
		postDelete(data, pre, curr);
		return list;
	}

	private boolean sorted(Link<T> curr, T data) {
		return !sorted || curr.data.compareTo(data) <= 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public boolean isSorted() {
		return sorted;
	}

	public String display() {
		Link<T> link = first;
		StringBuilder str = new StringBuilder();
		while (link != null) {
			str.append(link.data).append(" > ");
			link = link.next;
		}
		return str.toString();
	}

	protected void postInsert(Link<T> link, Link<T> pre, Link<T> curr) {
		System.out.println(display());
	}

	protected void postDelete(T data, Link<T> pre, Link<T> curr) {
		System.out.println(display());
	}

	// Insert, alternative implementation
	protected void insert2(T data) {
		Link<T> link = new Link<T>(data);
		if (first == null) {
			first = link;
			return;
		}
		link.next = first;
		Link<T> cur = link;
		while (cur.next != null && cur.next.data.compareTo(data) <= 0) {
			cur = cur.next;
		}
		link.next = cur.next;
		if (link.next == first) {
			first = link;
		} else {
			cur.next = link;
		}
		System.out.println(display());
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>(true);
		list.insert(10);
		list.insert(30);
		list.insert(20);
		list.insert(15);
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(8);
		list.insert(7);
		list.insert(6);
		list.insert(60);
		list.delete(10);
		list.delete(1);
		list.delete(20);
	}

}
