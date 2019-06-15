package qizy.leetcode.kth.medium;

import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {

	public static void main(String[] args) {
		// matrix = [
//		   [ 1,  5,  9],
//		   [10, 11, 13],
//		   [12, 13, 15]
//		],
//		k = 8,
//
//		return 13.

	}

	public static int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
        PriorityQueue<Point> queue = new PriorityQueue<Point>();
        for(int i=0;i<matrix.length;i++) {
        	int[] sub = matrix[i];
        	Point p = new Point(i,0,sub[0]);
        	queue.offer(p);
        }
        while(k>0) {
        	Point temp = queue.poll();
        	if(temp.y==n-1) {
        		continue;
        	}
        	queue.offer(new Point(temp.x,temp.y+1,matrix[temp.x][temp.y+1]));
        	k--;
        }
        return queue.poll().val;
    }
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int val;
		public Point(int x,int y,int val) {
			this.x=x;
			this.y=y;
			this.val=val;
		}
		@Override
		public int compareTo(Point that) {
			
			return this.val-that.val;
		}
	}
}
