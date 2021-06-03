//Time Complexity: O(MN)
//Space Complexity: O(N)  
//Runtime: 11 ms, faster than92.87%of Java online submissions forCoin Change.
//Memory Usage: 38.3 MB, less than72.32%of Java online submissions forCoin Change.

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);

        dp[0] = 0;
        
        for(int i = 1; i < amount+1; i++){
            for(int coin: coins){
                if(i - coin >= 0){
                dp[i] = Math.min(1 + dp[i - coin], dp[i]);
                }
            }
        }
        
    return dp[amount] > amount ? -1 : dp[amount];
    }
}
