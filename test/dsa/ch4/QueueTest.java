package dsa.ch4;

import junit.framework.TestCase;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class QueueTest extends TestCase {

	@Test
	@Ignore
	public void test() {
		Queue<Integer> q = new Queue<>(Integer.class);
		q.insert(10);
		q.insert(20);
		q.insert(30);
		q.insert(15);
		q.insert(50);
		q.insert(60);
		q.insert(70);
		q.insert(80);
		System.out.println("Full ? " + q.isFull());
		q.insert(90);
		System.out.println("Full ? " + q.isFull());
		q.insert(100);
		System.out.println("Full ? " + q.isFull());
		System.out.println(q.remove());
		q.insert(110);
		System.out.println("Full ? " + q.isFull());
		System.out.println(q.remove());
	}

	@Test
	public void testPriorityQueue() {
		PriorityQ<Integer> q = new PriorityQ<>(Integer.class);

		for (int i = 10; i >= 0; i--) {
			q.insert(i);
		}
		for (int i = 0; i <= 10; i++) {
			assertEquals(q.remove(), new Integer(i));
		}
	}

}
