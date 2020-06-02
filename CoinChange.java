// Time Complexity : O(N*M) where N is amount and M is the no of coins given
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Using Bottom Up approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount +1]; //+1 because zero based
        Arrays.fill(dp, amount +1);
        dp[0] = 0; //Initialize with 0 no. of coins to make sum 0(fewest coin)
        for(int i = 0; i<=amount; i++){ //Fewest no. of coins
            for(int j = 0; j< coins.length; j++){ // Iterate through coins for amount
                if(coins[j] <= i){ //Check if the coins is less or equal to the amount
                    dp[i] = Math.min(dp[i], 1 + dp[i-coins[j]]); //Best coins to make sum
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount]; // return amount or -1;
    }
}