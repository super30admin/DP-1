// TC : O(N*C)
// SC : O(N)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        return helper(coins, dp, amount);
    }
    
    public int helper(int[] coins,int[] dp, int amount){
        if(amount <0) return -1;
        if(amount==0) return 0;
        if(dp[amount] != 0) return dp[amount];
        int minCount = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            int res = helper(coins, dp, amount-coins[i]);
            if(res != -1){
                minCount = Math.min(res+1, minCount);
            }
           }
        dp[amount] = (minCount == Integer.MAX_VALUE)?-1:minCount;
        return dp[amount];
    }
}
