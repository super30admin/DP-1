// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i = 1; i < amount+1; i++){
            dp[0][i] = amount+1; // fill with max number (like infinity) that is not possible
        }
        
        // DP Array with min coins from previous subproblems 
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        
        if(dp[dp.length-1][dp[0].length-1]==amount+1) return -1; //if max number choosen above return -1
        return dp[dp.length-1][dp[0].length-1];
    }
}
