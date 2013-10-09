package dsa.ch4;

import java.lang.reflect.Array;

public class Queue<T> {

	protected T[] queue;
	protected int front = -1;
	protected int rear = -1;
	protected int count = 0;

	@SuppressWarnings("unchecked")
	public Queue(Class<T> cls) {
		this.queue = (T[]) Array.newInstance(cls, 20);
	}

	public synchronized void insert(T item) {
		int idx = next(rear);
		if (queue[idx] != null) {
			throw new RuntimeException("Queue is full !");
		}
		queue[rear = idx] = item;
		count++;
	}

	public synchronized T remove() {
		int idx = next(front);
		if (queue[idx] == null) {
			throw new RuntimeException("Queue is empty !");
		}
		T t = queue[front = idx];
		queue[idx] = null;
		count--;
		return t;
	}

	protected int next(int i) {
		return i + 1 == queue.length ? 0 : i + 1;
	}

	protected int pre(int i) {
		return i == 0 ? queue.length - 1 : i - 1;
	}

	public T peek() {
		return queue[front];
	}

	public boolean isFull() {
		return count == queue.length;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int size() {
		return count;
	}

}
