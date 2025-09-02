// Ran on leetcode : Yes
/*
Do choose and no choose, if we do choose reduce the amount by the coin value we are choosing till we reach the base condition and 
if we not choose then dont reduce the amount and skip the coin, store this value in the dp matrix and return the last index of the dp matrix
*/
// TC: O(2^m+n) SC: O(m+n)
class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int coinsLen = coins.length;
        int totalAmt = amount;
        int[][] dp = new int[coinsLen + 1][totalAmt + 1];
        for(int i = 1; i <= totalAmt; i++){
            dp[0][i] = Integer.MAX_VALUE - 100;
        }
        for(int i = 1; i <= coinsLen; i++){
            for(int j = 1; j <= totalAmt; j++){
                if(j < coins[i - 1]){
                    //no choose case
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //min between choose and no choose case
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        } 

        if(dp[coinsLen][totalAmt] == Integer.MAX_VALUE - 100) return -1;
        return dp[coinsLen][totalAmt];
    }

   
}