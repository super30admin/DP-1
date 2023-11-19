/*
T.C - Recursive is exponential T.C O(2 pow m+n)
D.P T.C - O(m*n)
S.C O(m*n)
S.C O(n) - DP with Array
Did this code successfully run on Leetcode : yes (https://leetcode.com/problems/coin-change/)
Any problem you faced while coding this : -
 */

/*
Problem Statement: Find min no. of coins to get the amount
Recursive: A helper function which traverses through choose, not choose case of each coin
Dynamic Programming Approach: A Matrix with choose , not choose results to find no. of coins
DP with Space Optimization: Instead of matrix, an array with results S.C O(n)
 */
public class CoinChange {

    public int coinChangeSpaceOptimized(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];

        for(int j=1;j<=n;j++)
            dp[j] = amount + 1;//infinity

        for(int i=1;i<=m;i++) {
            for(int j=1; j<=n; j++) {
                if(j<coins[i-1])
                    dp[j] = dp[j];
                else
                    dp[j] = Math.min(dp[j], 1+ dp[j-coins[i-1]]);

            }
        }
        if(dp[n]==amount+1)
            return -1;

        return dp[n];
    }

    public int coinChangeDP(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];

        for(int j=1;j<=n;j++)
            dp[0][j] = amount + 1;//infinity

        for(int i=1;i<=m; i++){
            for(int j=1; j<=n; j++) {
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]);

            }
        }
        if(dp[m][n]==amount+1)
            return -1;

        return dp[m][n];
    }

    public int coinChangeRecursive(int[] coins, int amount) {
        int coinCount = helper(coins, 0, amount, 0);
        return coinCount;
    }

    private int helper(int[] coins, int index, int remainingAmt, int coinCount){
        //base
        if(remainingAmt < 0 || index == coins.length)
            return -1;
        if(remainingAmt == 0)
            return coinCount;

        //logic
        //dont choose
        int case0 = helper(coins, index+1, remainingAmt, coinCount);

        //choose
        int case1 = helper(coins, index, remainingAmt - coins[index], coinCount+1);

        if(case0 == -1) return case1;
        if(case1 == -1) return case0;

        return Math.min(case0, case1);
    }


}
