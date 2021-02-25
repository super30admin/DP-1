// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// Used DP approach to update the previous values but just used 2 variables to reduce space complexity
class Solution {
    public int rob(int[] nums) {
        // Choose and Don't choose as the left and right branch of the recursion tree
        int ch=0,dc =0;
        for(int n:nums){
            int temp = dc;
            dc = Math.max(ch,dc);
            ch = n+temp; 
        }
        return Math.max(ch,dc);
    }
}

// Approach 2: DP approach using DP matrix
/*
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int[][] dp=new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for(int i=1;i<nums.length;i++){
            dp[i][0] = nums[i]+dp[i-1][1];
            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}
*/
