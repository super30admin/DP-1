//TC - O(n*amount) where n is coins array length
//SC - O(n* amount)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length+1][amount+1];
        for(int j=0;j<amount+1;j++){
            dp[0][j] = amount+1;
        }
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{

                    dp[i][j]= Math.min(dp[i-1][j] , dp[i][j-coins[i-1]]+1);
                }
            }
        }
        if(dp[coins.length][amount] == amount+1){
            return -1;
        }
        return dp[coins.length][amount];
    }
}
