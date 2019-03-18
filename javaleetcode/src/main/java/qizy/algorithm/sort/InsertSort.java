package qizy.algorithm.sort;

public class InsertSort {
	public static void main(String[] args) {
		int[] a = {5,3,4,8,2,7,1,9,11,6,5};
		insertSort(a);
		SortUtil.print(a);
	}

	private static void insertSort(int[] a) {
		// TODO Auto-generated method stub
		for(int i =1;i<a.length;i++) {
			int k = a[i];
			int j = i;
			while(j>0&& k<a[j-1]) {
				a[j]=a[j-1];
				j--;
			}
			a[j]=k;
		}
	}
}
