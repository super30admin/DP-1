// TimeComplexity : O(nT) where T is the target and n is the number of coins of different dinominations.
// Space COmplexity: O(T)

// Approach:
//     Populate the 0th index for each row as 0.
//     Create a 2D matrix and for dp[i][j], calculate the min of dp[i-1][j] or dp[i][j-coins[i-1]].

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int j=1; j<=amount; j++){
            dp[0][j] = 99999;
        }
        
        for(int i=0; i<=coins.length; i++){
            dp[i][0] = 0;
        }
        
        for(int i =1; i<=coins.length; i++){
            for(int j =1; j<=amount; j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        int result = dp[coins.length][amount];
        return result == 99999 ? -1 : result;
    }
}