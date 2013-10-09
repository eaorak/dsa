package dsa.ch2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import dsa.ch2.Array;

@RunWith(JUnit4.class)
public class ArrayTests {

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Test
	/* (expected = RuntimeException.class) */
	public void test() {
		Array arr = new Array(20);

		ex.expect(RuntimeException.class);

		while (true) {
			arr.insert(20);
			arr.insert(18);
			arr.insert(19);
			arr.insert(17);
			arr.insert(16);
			arr.insert(15);
			arr.insert(14);
			arr.insert(13);
			arr.insert(12);
			arr.insert(11);
			arr.insert(10);
			arr.insert(1);
			arr.insert(2);
			arr.insert(3);
			arr.insert(4);
			arr.insert(5);
			arr.insert(6);
			arr.insert(7);
			arr.insert(8);
			arr.insert(9);
			arr.delete(1);
			arr.delete(2);
			arr.delete(3);
			arr.delete(4);
			arr.delete(5);
			arr.delete(6);
			arr.delete(7);
			arr.delete(8);
			arr.delete(9);
		}
	}

}
