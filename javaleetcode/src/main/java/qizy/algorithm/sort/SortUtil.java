package qizy.algorithm.sort;

public class SortUtil {

	public static void print(int[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
	}

	public static void swap(int j, int i, int[] a) {
		int t = a[j];
		a[j]= a[i];
		a[i]=t;
		
	}
}
