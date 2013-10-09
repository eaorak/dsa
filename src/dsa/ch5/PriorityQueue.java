package dsa.ch5;

/**
 * Queue implementation based on LinkQueue. Can be used as a <br>
 * priority queue.
 * 
 * @author ender
 */
public class PriorityQueue<T extends Comparable<T>> extends LinkedQueue<T> {

	public PriorityQueue() {
		super(true);
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
		PriorityQueue<Integer> queue = new PriorityQueue<>();
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
