package dsa.ch3;

import java.util.Arrays;

public class SimpleSort {

	private int[] array;
	private int index = 0;

	public enum Sort {
		BUBBLE, SELECTION, INSERTION;
	}

	public SimpleSort(int[] arr) {
		this.array = arr;
	}

	public SimpleSort(int size) {
		array = new int[size];
	}

	public void insert(int val) {
		array[index++] = val;
	}

	public int get(int idx) {
		return array[idx];
	}

	public int[] sort(Sort type) {
		int[] arr = Arrays.copyOf(array, array.length);
		System.out.println(Arrays.toString(arr));
		switch (type) {
		case BUBBLE:
			return bubble(arr);
		case SELECTION:
			return selection(arr);
		case INSERTION:
			return insertion(arr);
		}
		return null;
	}

	private int[] bubble(int[] arr) {
		int limit = arr.length - 1;
		while (limit > 0) {
			for (int i = 0; i < limit; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
			System.out.println(Arrays.toString(arr));
			limit--;
		}
		return arr;
	}

	private int[] selection(int[] arr) {
		int limit = 0;
		while (limit < arr.length) {
			int min = limit;
			for (int i = limit; i < arr.length; i++) {
				if (arr[i] < arr[min]) {
					min = i;
				}
			}
			swap(arr, min, limit);
			System.out.println(Arrays.toString(arr));
			limit++;
		}
		return arr;
	}

	private int[] insertion(int[] arr) {
		int temp = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				temp = arr[i];
				int j = i;
				for (; j > 0; j--) {
					if (temp < arr[j - 1]) {
						arr[j] = arr[j - 1];
					} else {
						break;
					}
				}
				arr[j] = temp;
				System.out.println(Arrays.toString(arr));
			}
		}
		return arr;
	}

	private void swap(int[] arr, int x, int y) {
		int temp = arr[y];
		arr[y] = arr[x];
		arr[x] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 3, 8, 7, 2, 1, 9, 6, 4, 5 };
		SimpleSort sort = new SimpleSort(arr);
		System.out.println();
		System.out.println(Arrays.toString(sort.sort(Sort.BUBBLE)));
		System.out.println("---------------------------------------");
		System.out.println(Arrays.toString(sort.sort(Sort.SELECTION)));
		System.out.println("---------------------------------------");
		System.out.println(Arrays.toString(sort.sort(Sort.INSERTION)));

	}
}
