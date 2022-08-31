/*
Time Complexity:O(S*n) for iterating
Space Complexity:O(S)memoization table space
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for(int i = 0; i < coins.length; i++){
            int coin = coins[i];
            for(int j = coin; j < dp.length; j++){
                int total_c = -1;
                int rem_c = j - coins[i];
                if(dp[rem_c] < 0){
                    continue;
                }
                total_c = 1 + dp[rem_c];
                if(dp[j] == -1) dp[j] = total_c;
                else dp[j] = Math.min(dp[j], total_c);
            }
        }
        
        return dp[amount];
    }
}