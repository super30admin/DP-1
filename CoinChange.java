/* Time Complexity: O(n*m), n - no of coins, m - total amount
 * Space Complexity:O(n*m), n - no of coins, m - total amount
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
       int m = coins.length; 
       int n = amount;
       int [][] dp = new int[m+1][n+1];
       for(int j = 1; j < dp[0].length; j++){
           dp[0][j] = 99999; //here we are not using max value as there will integer overflow error
       }
       for(int i = 1; i < dp.length; i++){
           for(int j = 1; j < dp[0].length; j++){
                 if(j < coins[i-1]){
                      dp[i][j] = dp[i - 1][j];
                 } else {
                      dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                 }
           }
        } 
        if(dp[m][n] >= 99999) return -1;
        return dp[m][n];
    }
}
