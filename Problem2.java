// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
       
        if(nums.length == 0){ //base case - Empty array
            return 0;
        }
        if(nums.length == 1){ //base case - only one element 
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);  //base case - if two elements, they are adjacent - return max of those two
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0]; //initial sum
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);// compare current running sum, with previous running sum, store the max
        }
        return dp[nums.length - 1]; //the last index of dp[] contains max 
    
    }
}
