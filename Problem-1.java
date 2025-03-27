/* Using DP matrix: Time complexity - O(m*n) & Space complexity - O(m*n) */

/* Using array: Time complexity - O(m*n) & Space comlexity - O(n) */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];
        //dp[0][0] = 0;

        for(int j=1; j<=n; j++){
            dp[0][j] = 99999;
        }

        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j < coins[i-1]) //amount < denomination of the coin
                {
                    //no choose case
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }

        if(dp[m][n] == 99999) return -1;
        return dp[m][n];
    }
}

/* Recursive logic: Time complexity - 2^(m+n) & Space complexity - (m+n)
 * m - length of coins, n - amount
*/
/* class Solution {
    int count;
    public int coinChange(int[] coins, int amount) {
        this.count = Integer.MAX_VALUE;
        helper(coins, 0, amount, 0);

        if(count == Integer.MAX_VALUE) return -1;
        return count;
    }
    private void helper(int[] coins, int i, int amount, int coinsUsed){

        //base case
        if(amount < 0 || i == coins.length){
            return;
        }

        if(amount == 0){
            count = Math.min(count, coinsUsed);
            return;
        }

        //don't choose
        helper(coins, i+1, amount, coinsUsed);

        //choose
        helper(coins, i, amount - coins[i], coinsUsed+1);
    }
}
*/