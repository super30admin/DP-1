// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 0 || nums == null){		// edge case
            return 0;
        }
        if(nums.length == 1){						// edge case with the array of only one element
            return nums[0];
        }
        
        int[] rSum = new int[nums.length];			// need an extra space to save the runnning sums
        rSum[0] = nums[0];							// 1st value is directly put in the 0th position
        rSum[1] = Math.max(nums[0], nums[1]);		// compare the first element with 2nd and put the max in the third element
        
        for(int i = 2; i< nums.length; i++){		// following the same approach as above but compare 2 values to find the maximum and add it with the current element
            rSum[i] = Math.max(rSum[i-1], rSum[i-2] + nums[i]);
        }
        return rSum[nums.length - 1];				// return last element
    }
}