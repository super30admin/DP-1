// Time Complexity : O(n*k) , n=amount, k=total elements in coins array
// Space Complexity : O(n), n=amount
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1]; //Array initialization
        //Initialising each value of the array witht he max value other than the first index
        Arrays.fill(dp,(int) 1e9); 
        dp[0]=0;
        for(int i=1; i<dp.length; i++) {
            for(int j=0; j<coins.length; j++) {
                if(i-coins[j]>=0)
                    dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]); //replacing the max value with the min number of coins for the amount i
            }
        }
        return dp[amount] == (int) 1e9 ? -1 : dp[amount]; 
    }
}

