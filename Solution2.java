class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = coinChangeRecursion(coins, amount, 0, new int[coins.length][amount + 1]);
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
    
    private int coinChangeRecursion(int[] coins, int amount, int i, int[][] dp){
        if(amount == 0){
            return 0;
        }
        if(amount < 0 || i==coins.length){
            return Integer.MAX_VALUE;
        }
        
        if(dp[i][amount] > 0){
            return dp[i][amount];
        }
        
        int n = coinChangeRecursion(coins, amount, i + 1, dp);
        int y = coinChangeRecursion(coins, amount - coins[i], i, dp);
        
        if(y != Integer.MAX_VALUE){
            y += 1;
        }
        
        dp[i][amount] = Math.min(n, y);
        return dp[i][amount];
    }
}
