// Time Complexity : O(M * N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {

    public int coinChange(int[] coins, int amount) {
                if(coins.length == 0 || amount==0){
                    return 0;
                }
                int m = coins.length;
                int n = amount;

                int[][] dp = new int[m+1][n+1];

                for(int i=1;i<dp[0].length;i++){
                    dp[0][i] = 99999;
                }

                for(int i=1;i<dp.length;i++){
                    for(int j=1;j<dp[0].length;j++){
                        if(j<coins[i-1]){
                            dp[i][j] = dp[i-1][j];
                        }else{
                            dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                        }
                    }
                }
                if(dp[m][n] >= 99999)
                    return -1;
                else
                    return dp[m][n];
    }
}