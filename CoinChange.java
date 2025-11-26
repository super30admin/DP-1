// Time Complexity: O(mn)
// Space Complexity: O(mn)

// 1: We maintain a dp table where dp[i][j] contains the total coins we have used to make amount j using coins i so far available to us
// 2: We check to make sure that the denomination is greater than the amount, else we will only have case0
// 3: If not, we add case0 and case1 to have the total running sum through which we can return the last element of the dp table
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || coins == null) return -1;
        int n = coins.length;
        int m = amount;
        int[][]dp = new int[n+1][m+1];
        for(int i = 1;i<=m; i++){
            dp[0][i] = amount+1;
        }
        for(int i = 1; i<=n;i++){
            for(int j=1; j<=m; j++){
                // when denomination > amount
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        int res = dp[n][m];
        if(res > amount){
            return -1;
        }
        return res;
    }
}