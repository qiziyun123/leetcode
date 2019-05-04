package qizy.leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

	public static void main(String[] args) {
		int[] nums = {1,2,3,1,2,3};
		int k =2;
		System.out.println(containsNearbyDuplicate(nums,k));
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int tdx = map.get(nums[i]);
                if(i<=tdx){
                    return true;
                }
                map.put(nums[i],i+k);
            }else{
                map.put(nums[i],i+k);
            }
        }
        return false;
    }
}
