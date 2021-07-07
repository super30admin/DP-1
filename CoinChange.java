// Time Complexity : O(n*a) ; n is number of coins and a is the amount 
// Amount is a number/constant. Therefore the problem is PSEUDO POLYNOMIAL.
// Space Complexity : O(a); Array is size of amount 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int a = 1; a <= amount; a++) {
            dp[a] = amount+1;
            for (int c = 0; c < coins.length; c++) {    
                if(coins[c] <= a) {
                    dp[a] = Math.min(dp[a], dp[a-coins[c]]+1);
                }
                else { break;}
            }
        } if(dp[amount] > amount) return -1;
          return dp[amount];
    }
}
