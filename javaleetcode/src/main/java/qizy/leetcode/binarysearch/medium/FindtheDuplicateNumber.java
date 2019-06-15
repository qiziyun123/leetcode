package qizy.leetcode.binarysearch.medium;

public class FindtheDuplicateNumber {

	public static void main(String[] args) {
		// two methods
		
		//Input: [1,3,4,2,1]
		//Output: 1

	}

	public int findDuplicate(int[] nums) {
        // 由于此题数据范围是1-n
		// 所以如果没有重复则满足一个定律， 若设置一个分割点，分割点对应下标，假设下标是2，则一定满足 所有元素小于等于2的数量正好是2
		// 如果小于2了，则证明重复数据在小于2的范围，反之在另一半
		// 所以此问题可以理解为，对数组下标的二分查找
		
		int low =1;
		int high = nums.length-1;
		
		while(low<high) {
			int mid = (high-low)/2+low;
			int t=0;
			for(int i=0;i<nums.length;i++) {
				if(nums[i]<=mid) {
					t++;
				}
			}
			if(t<=mid) {
				low = mid + 1;
			}else {
				high = mid;
			}
		}
		return low;
    }
}
