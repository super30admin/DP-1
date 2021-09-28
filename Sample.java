/* COIN CHANGE */
// Time Complexity : O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        //Since we will be considering coin denomination 0, we add + 1
        int n = coins.length + 1;
        int m = amount + 1; 
        
        int[][] dp = new int[n][m];
        //Row initialisation to max value
        for(int j = 1; j < m; j++){
            dp[0][j] = 99999;
        }
        //column initialisation
        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }
        //Dynamic programming logic
         for(int i = 1; i < n; i++){
             for(int j = 1; j < m; j++){
                 if(j < coins[i - 1]){
                     dp[i][j] = dp[i - 1][j]; //If the value is less than the minimum, we pull the value from the top column
                 }
                 else{
                     dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]); 
                 }
             }
         }
        return dp[n -1][m -1] == 99999 ? -1 : dp[n - 1][m - 1]; //overflow error check
    }
}


/* HOUSE ROBBER */
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];

        dp[0] = 0; //first will be 0
        dp[1] = nums[0]; // this will be the forst element of the given array
        
        // the new value will be the maximum of either the current i value or i - 1 added to the current cost in the nums array
        for(int i = 1; i < nums.length; i++){
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }
        
        return dp[dp.length - 1];
    }
}