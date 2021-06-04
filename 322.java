class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int num : coins){
            for(int i = num ; i<dp.length ; i++){
                if(dp[i-num]!= Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i] , dp[i-num] + 1);
                } 
            }
        }
        return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];
        
    }
}