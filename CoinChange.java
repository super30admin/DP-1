// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : traversing the dp array

class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        
        int rows = coins.length + 1;
        int cols = amount + 1;

        int dp[][] = new int[rows][cols];

        // Fill 1st row and column
        dp[0][0] = 0;
        for(int i=1; i<cols; i++) {
            dp[0][i] = 100000;
        }

        for(int i=1; i<rows; i++) {
            dp[i][0] = 0;
        }

        for(int i = 1; i< rows; i ++) {
            for(int j=1; j<cols; j++) {
                //If coin value is greater than amount, choose the value from row above         
                if(coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                // else, take the minimum between the row above and (the value after subtracting the coin value + 1)
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], (dp[i][j-coins[i-1]] + 1));
                }

            }
        }

        // if min value is equal to the max value, return -1
        if(dp[rows-1][cols-1] == 100000) {
            return -1;
        } else {
            return dp[rows-1][cols-1];
        }
        

    }

    public static void main(String args[]) {
        System.out.println(coinChange(new int[]{1,2,5,6}, 11));
    }
}