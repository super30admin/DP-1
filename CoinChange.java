// Time Complexity :O(numberOfCoins * amount) - We are creating a dp array and visiting every cell
// Space Complexity :O(numberOfCoins * amount) - We are creating a dp array for storing our optimal solution
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Missed a condition that if coin value present doesnt make up to target, we have to check if the last element is the higher value initialized then return -1


// Your code here along with comments explaining your approach

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0) return -1;
        if(amount == 0) return 0;

        int[][] dp = new int[coins.length+1][amount+1];:

        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j = 1 ; j < dp[0].length; j++){
            dp[0][j] = 9999999;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }

        return dp[coins.length][amount] == 9999999 ? -1 : dp[coins.length][amount];

    }
}
