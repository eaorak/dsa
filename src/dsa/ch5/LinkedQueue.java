package dsa.ch5;

/**
 * Queue implementation based on LinkedList.
 * 
 * @author ender
 */
public class LinkedQueue<T extends Comparable<T>> extends LinkedList<T> {

	public LinkedQueue() {
		super(false);
	}

	protected LinkedQueue(boolean sorted) {
		super(sorted);
	}

	public T remove() {
		if (isEmpty()) {
			return null;
		}
		T data = first.data;
		first = first.next;
		System.out.println(display());
		return data;
	}

	public static void main(String[] args) {
		LinkedQueue<Integer> queue = new LinkedQueue<>();
		queue.insert(5);
		queue.insert(13);
		queue.insert(7);
		queue.insert(193);
		queue.insert(77);
		queue.insert(32);
		queue.insert(7);

		System.out.println(queue.delete(7));

		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();

	}

}
