package qizy.leetcode.array.medium;

import java.util.Random;

public class ShuffleanArray {
	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(nums);
	 * int[] param_1 = obj.reset();
	 * int[] param_2 = obj.shuffle();
	 */
	Random r;
	private int[] origindata;
	public ShuffleanArray(int[] nums) {
        r = new Random();
        origindata=nums;
    }

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return origindata;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] shuffled = origindata.clone();
		for(int i=1;i<shuffled.length;i++) {
			// nextint(n)  [0,n) 不包括n
			int rs = r.nextInt(i+1);
			swap(shuffled,rs,i);
		}
		return shuffled;
	}

	private void swap(int[] shuffled, int rs, int i) {
		int t = shuffled[rs];
		shuffled[rs]=shuffled[i];
		shuffled[i]=t;
		
	}
	
	
}
