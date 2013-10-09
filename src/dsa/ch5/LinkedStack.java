package dsa.ch5;

import java.util.List;

public class LinkedStack<T extends Comparable<T>> extends LinkedList<T> {

	public LinkedStack() {
		super(false);
	}

	public void push(T data) {
		Link<T> link = new Link<>(data);
		link.next = first;
		first = link;
		System.out.println(display());
	}

	public T pop() {
		if (isEmpty()) {
			return null;
		}
		T data = first.data;
		first = first.next;
		System.out.println(display());
		return data;
	}

	@Override
	public void insert(T data) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<T> delete(T data) {
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<>();
		stack.push(30);
		stack.push(20);
		stack.push(10);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
