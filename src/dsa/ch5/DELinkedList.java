package dsa.ch5;

/**
 * Double Ended Linked List * Sorted
 * 
 * @author ender
 */
public class DELinkedList<T extends Comparable<T>> extends LinkedList<T> {

	protected Link<T> last;

	public DELinkedList() {
		super(true);
	}

	@Override
	protected void postInsert(Link<T> link, Link<T> pre, Link<T> curr) {
		last = (first == link) ? link : (link.next == null) ? link : last;
		super.postInsert(link, pre, curr);
	}

	@Override
	protected void postDelete(T data, Link<T> pre, Link<T> curr) {
		last = pre;
		super.postDelete(data, pre, curr);
	}

	@Override
	public String display() {
		return super.display() + " [Last: " + last + "]";
	}

	public static void main(String[] args) {
		DELinkedList<Integer> list = new DELinkedList<>();
		list.insert(10);
		list.insert(30);
		list.insert(20);
		list.insert(15);
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(8);
		list.insert(80);
		list.insert(90);
		list.insert(7);
		list.insert(6);
		list.insert(60);
		list.delete(10);
		list.delete(1);
		list.delete(20);
	}

}
