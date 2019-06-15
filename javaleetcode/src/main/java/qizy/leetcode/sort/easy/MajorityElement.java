package qizy.leetcode.sort.easy;

public class MajorityElement {

	public static void main(String[] args) {
		//The majority element is the element that appears more than ⌊ n/2 ⌋ times
		// 较多的元素大于一半数量
		int[] a = {1,9,2,9,3,4,9};
		System.out.println(majorityElement(a));

	}

	public static int majorityElement(int[] nums) {
		int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;
            
        }
        return major;
        
    }
    

}
