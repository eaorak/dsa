package dsa.ch4;

public class PriorityQ<T extends Comparable<T>> extends Queue<T> {

	public PriorityQ(Class<T> cls) {
		super(cls);
	}

	@Override
	public synchronized void insert(T item) {
		int idx = next(rear);
		if (queue[idx] != null) {
			throw new RuntimeException("Queue is full !");
		}
		while (idx != next(front)) {
			if (queue[pre(idx)].compareTo(item) > 0) {
				queue[idx] = queue[pre(idx)];
			} else {
				break;
			}
			idx = pre(idx);
		}
		queue[idx] = item;
		rear = next(rear);
	}

}
