package dsa.ch4;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Stack<T> {

	private static final int INC_SIZE = 20;
	private T[] stack;
	private int top = -1;

	@SuppressWarnings("unchecked")
	public Stack(Class<T> cls) {
		this.stack = (T[]) Array.newInstance(cls, INC_SIZE);
	}

	public synchronized void push(T item) {
		check();
		stack[++top] = item;
	}

	public synchronized T pop() {
		if (isEmpty()) {
			return null;
		}
		return stack[top--];
	}

	public T peek() {
		return stack[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	private void check() {
		if (top + 1 >= stack.length) {
			stack = Arrays.copyOf(stack, stack.length + INC_SIZE);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>(Integer.class);
		for (int i = 0; i < 30; i++) {
			stack.push(i);
		}
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
