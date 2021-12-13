//Time Complexity = O(mn)
//Space Complexity = O(mn)

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i =1;i<amount+1;i++){
            dp[0][i] = amount+1;
        }
        for (int i = 1;i<dp.length;i++){
            for (int j = 1;j<amount+1;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[coins.length][amount]>amount){
            return -1;
        }
        return dp[coins.length][amount];
        
    }
}