//Time Complexity: O(n)
//Space Complexity: O(n) //can be optimized to O(1) by using 2 variables for prev index value and current index value
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
//Approach: for each house, we have a choice - either rob it or dont. Is you rob it, total amount = max found
// when robbing index-2 house + amount in current house and max found so far in index-1 house
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int dp[]= new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[nums.length-1];
    }
}