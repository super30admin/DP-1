// Time Complexity : O(NM) N number of elements in coins, M amount 2*2 matrix used
// Space Complexity : O(NM) N number of elements in coins, M amount 2*2 matrix used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve problem before class. 


// Your code here along with comments explaining your approach: Same as class

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        //edge cases check
        if(coins == null || coins.length == 0) return -1;
        
        int m = coins.length;//rows
        int n = amount;//cols
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<= m; i++){
            dp[i][0] = 0;
        }
        
        for(int i=1; i<=n; i++){
            dp[0][i] = 9999;
        }
        
        for(int i=1; i <= m; i++){
            for(int j=1; j<= n; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
                }
            }
        }
        if(dp[m][n] >= 9999) return -1;
            else return dp[m][n];
    }
}
