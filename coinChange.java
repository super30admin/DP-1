// Time Complexity : O(n*k) where n is amount and k coins
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        //for all the amount values
        for(int J = 1;J<=amount; J++) {
            // for all the coin values
            for(int i = 0;i<coins.length;i++) {

                 if (coins[i] <= J) {
                    // select min of if i use current coin or use previous coins
                    dp[J] = Math.min(dp[J], dp[J-coins[i]]+1);
                 }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
