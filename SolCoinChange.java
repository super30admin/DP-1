// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes

// created a 2D array, column as an amount and the coins as a row

class SolCoinChange {
    public int coinChange(int[] coins, int amount) {

        if(coins == null || coins.length ==0) return 0;
        int m =coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];

        // added first row as an dummy, with coin value 0 to make algorithm consistant through out all coin. and assigned maximum value to it.
        dp[0][0] = 0;
        for(int j=1; j<dp[0].length; j++){
            dp[0][j] = amount+1;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){

                //until the amount is more than the coin value, we'll be coping the minimum value from the upper-most coin.
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    //get the smaller value out of value of upper-most coin and sum of the coin value and (the coin value steps back in the same row)
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }

        // return the last element of the matrix as out expected output.
        int result = dp[m][n];
        if(result>amount) return -1;
        return result;
    }
}