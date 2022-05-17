// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        //int first=nums[0];
        nums[1]=Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            //At any house the maximum amount that can be robbed is the maximum of either (current house's value + the max value that can be robbed upto the house before the previous house) or (the max value that can be robbed upto the previous house).
            nums[i]=Math.max(nums[i]+nums[i-2], nums[i-1]);
        }
        return nums[nums.length-1];
    }
}
