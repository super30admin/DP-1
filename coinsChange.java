// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int c:coins) {
            for(int j = c;j<=amount;j++) {
                dp[j] = Math.min(dp[j],1+dp[j-c]);
            }
        }
        return (dp[amount]==amount+1)? -1:dp[amount];
    }
}

/*
* // exhaustive approach
    public int coinChange(int[] coins, int amount) {
        int[][] dp= new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++){
            dp[i][0] = 0;
        }
        for(int j=1;j<amount+1;j++){
            dp[0][j] = amount + 2;
        }
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                int inclusion = amount+2;
                if(j-coins[i-1] >=0){
                    inclusion = 1 + dp[i][j-coins[i-1]];
                }
                int exclusion = dp[i-1][j];
                if(inclusion != amount+2){
                    dp[i][j] = Math.min(inclusion, exclusion);
                } else {
                    dp[i][j] = exclusion;
            }
        }
    }
    return dp[coins.length][amount] == (amount+2)? -1 : dp[coins.length][amount];
    }
* */