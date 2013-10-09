package dsa.ch2;

import java.util.Arrays;

public class Array {

	private static int MAX = 30;
	private Integer[] arr = new Integer[MAX];
	private int idx = 0;

	public Array(int size) {
		checkSize();
	}

	public void insert(int val) {
		checkSize();
		int index = findBinary(val, 0, idx, true);
		shift(index, true);
		arr[index] = val;
		idx++;
		//
		System.out.println(Arrays.toString(arr));
	}

	public void delete(int val) {
		int index = find(val);
		if (index == -1) {
			return;
		}
		shift(index, false);
		idx--;
		//
		System.out.println(Arrays.toString(arr));
	}

	public void shift(int index, boolean forward) {
		int start = forward ? idx : index;
		int end = forward ? index : idx;
		int inc = forward ? -1 : 1;
		for (int i = start; forward ? i > end : i < end; i += inc) {
			arr[i] = arr[i + inc];
		}
		arr[forward ? index : idx] = null;
	}

	public int find(int val) {
		return findBinary(val, 0, idx, false);
	}

	private int findBinary(int val, int low, int up, boolean index) {
		Integer sel = (up + low) / 2;
		Integer curr = arr[sel];
		// System.out.printf("Sel %d, Curr %d, Low %d, Up %d\n", sel, curr, low,
		// up);
		if (curr == null || idx == 0 || low > up) {
			return index ? low : -1;
		} else if (curr == val) {
			return sel;
		}
		low = curr < val ? sel + 1 : low;
		up = curr > val ? sel - 1 : up;
		return findBinary(val, low, up, index);
	}

	private void checkSize() {
		if (idx + 1 > MAX) {
			throw new RuntimeException("Size can not exceed [" + MAX + "] !");
		}
	}

}
