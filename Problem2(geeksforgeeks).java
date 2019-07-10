// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes, src: leetcode
// Any problem you faced while coding this : couldn't think about the taking 
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int value0 = nums[0];
        
        if(nums.length == 1){
            return nums[0];
        }
        int value1 = Math.max(nums[0],nums[1]);
        if(nums.length == 2){
            return value1;
        }
        int maxMoney = 0;
        for(int i = 2; i<nums.length; i++){
            maxMoney = Math.max(nums[i] + value0, value1);
            value0 = value1;
            value1 = maxMoney;
        }
        return maxMoney;
        
        
    }
}