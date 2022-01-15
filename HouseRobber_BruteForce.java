//Time: exponential
//Space: O(n)
//https://leetcode.com/submissions/detail/616665850/
class Solution {
    public int rob(int[] nums) {
        int result =  helper(nums, 0, 0);
        return result;
    }
    
    int helper(int[] nums, int index, int amount) {
        
        if(index >= nums.length){
            return amount;
        }
        
        int left = helper(nums, index + 1, amount);
        int right = helper(nums, index+2, amount+nums[index]);
        
        return Math.max(left, right);
    }
}