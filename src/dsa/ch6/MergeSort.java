package dsa.ch6;

import java.util.Arrays;

public class MergeSort {

	private int[] array;
	private int count = 0;

	public enum Sort {
		MERGE;
	}

	public MergeSort(int[] arr) {
		this.array = arr;
		count = arr.length;
	}

	public MergeSort(int size) {
		array = new int[size];
	}

	public void insert(int val) {
		array[count++] = val;
	}

	public int get(int idx) {
		return array[idx];
	}

	public int[] sort(Sort type) {
		int[] arr = Arrays.copyOf(array, array.length);
		switch (type) {
		case MERGE:
			return merge(arr);
		}
		return null;
	}

	private int[] merge(int[] arr) {
		recMerge(arr, 0, count - 1);
		return arr;
	}

	private void recMerge(int[] temp, int low, int up) {
		System.out.println(String.format("RM  low: %d up: %d", low, up));
		if (low == up) {
			return;
		}
		int mid = (low + up) / 2;
		recMerge(temp, low, mid);
		recMerge(temp, mid + 1, up);
		merge(temp, low, mid + 1, up);
	}

	private void merge(int[] temp, int _low, int _high, int _up) {
		int j = 0;
		int lower = _low;
		int mid = _high - 1;
		int n = _up - _low + 1;

		while (_low <= mid && _high <= _up) {
			if (array[_low] < array[_high]) {
				temp[j++] = array[_low++];
			} else {
				temp[j++] = array[_high++];
			}
		}
		while (_low <= mid) {
			temp[j++] = array[_low++];
		}
		while (_high <= _up) {
			temp[j++] = array[_high++];
		}
		for (j = 0; j < n; j++) {
			array[lower + j] = temp[j];
		}
		System.out.println("Temp: " + Arrays.toString(temp));
		System.out.println("Arr : " + Arrays.toString(array));
	}

	public static void main(String[] args) {
		MergeSort sort = new MergeSort(new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 });
		System.out.println(Arrays.toString(sort.sort(Sort.MERGE)));

	}
}
