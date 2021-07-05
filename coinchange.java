//TC: O(N)
//SC: O(M*N)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        
        //first row
        for(int j=1; j<=amount; j++) {
            dp[0][j] = amount+1;
        }
        for(int i=1; i<=coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                //current amt < denomination
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                
                //choose not choose
                else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        return dp[coins.length][amount] == amount+1 ? -1 : dp[coins.length][amount];
    }
}