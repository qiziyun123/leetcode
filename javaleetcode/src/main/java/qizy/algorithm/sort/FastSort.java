package qizy.algorithm.sort;

public class FastSort {
	public static void main(String[] args) {
		int[] a = {5,3,4,8,2,7,1,9,11,6,5};

		quickSort(a,0,a.length-1);
		SortUtil.print(a);
	}



	private static void quickSort(int[] a, int low, int high) {
		if(low>high) {
			return;
		}
		int temp = a[low];
		int i =low;
		int j =high;
		while(i<j) {
			while(i<j&&a[j]>=temp) {
				j--;
			}
			while(i<j&&a[i]<=temp) {
				i++;
			}
			if(i<j) {
				SortUtil.swap(i, j, a);
			}
		}
		SortUtil.swap(low, i, a);

		quickSort(a,low,i-1);
		quickSort(a,i+1,high);
		
	}
}
