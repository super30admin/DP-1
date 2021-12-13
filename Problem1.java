//dp
//time - O(n*m)
//space - O(n*m)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i=0; i<=amount; i++) {
            dp[0][i] = amount+1;
        }
        
        for(int i=0; i<=coins.length; i++) {
            dp[i][0] = 0;
        }
        
        for(int i=1; i<=coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                if(j<coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        return dp[coins.length][amount] == amount+1 ? -1 : dp[coins.length][amount];
    }
}
//recursion
//time - O(2^n)
//space - O(n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int result = helper(coins, amount, 0, 0);
        if(result == Integer.MAX_VALUE)
            return -1;
        return result;
    }
    
    private int helper(int[] coins, int total, int index, int noOfCoins) {
        if(index==coins.length)
            return Integer.MAX_VALUE;
        if(total == 0)
            return noOfCoins;
        if(total < 0)
            return Integer.MAX_VALUE;
        
       int taken = helper(coins, total - coins[index], index, noOfCoins+1);
       int notTaken = helper(coins, total, index+1, noOfCoins);
        
        return Math.min(taken,notTaken);
        
    }
}
