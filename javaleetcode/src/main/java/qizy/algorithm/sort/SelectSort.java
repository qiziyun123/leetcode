package qizy.algorithm.sort;

public class SelectSort {
	public static void main(String[] args) {
		int[] a = { 5, 3, 4, 8, 2, 7, 1, 9, 11, 6, 5 };

		selectsort(a);
		SortUtil.print(a);
	}

	private static void selectsort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			int k = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < min) {
					k = j;
					min = a[j];
				}
			}
			SortUtil.swap(k, i, a);
		}

	}
}
