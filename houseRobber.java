// Time Complexity :O(n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        if(nums[0]>nums[1])
            nums[1]=nums[0];
        if(nums.length==2)
            return nums[1];
        for(int i=2;i<nums.length;i++)
        {
            nums[i]=Math.max(nums[i]+nums[i-2],nums[i-1]); //check till the element which is max by considering it or not considering it
        }
        return nums[nums.length-1];
    }
}