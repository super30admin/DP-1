// Time Complexity : O(N*M) - N = 1 to amount, M = length of coins array
// Space Complexity : O(N) - N = amount + 1;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
// The idea is to use a dp array to maintain the number of coins needed to get amounts from 0 to the target amount
// Use the minimum between number of coins needed to get a particular amount and 1 + the minimun number of coins need to get i-coins[j] amount
class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
                   
        for(int i = 1; i<=amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
          
        return dp[amount] > amount ? -1 : dp[amount];
    }
}