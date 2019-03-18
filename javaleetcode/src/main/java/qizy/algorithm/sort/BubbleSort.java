package qizy.algorithm.sort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] a = {5,3,4,8,2,7,1,9,11,6,5};
		bubblesort(a);
		SortUtil.print(a);
	}

	private static void bubblesort(int[] a) {
		for(int i=0; i<a.length-1;i++) {
			for(int j=0;j<a.length-1-i;j++) {
				if(a[j]>=a[j+1]) {
					SortUtil.swap(j,j+1,a);
				}
			}
		}
		
	}

	

	
}
