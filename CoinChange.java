// Time Complexity : O(amount*N)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(0 == amount){return amount;}
        Arrays.sort(coins);
        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < coins.length; j++){
                    if(coins[j] <= i){
                        dp[i] = Math.min(dp[i],dp[i-coins[j]] + 1);
                    }
            }
        }
        return dp[amount] > amount?-1:dp[amount];
    }
}