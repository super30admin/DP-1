// Time Complexity : O(n*k) n represents amount and k represents number of coins
// Space Complexity : O(n) n represents amount
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : Initially missed edge cases like dp[amount] does not change and when amount = 0


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if(amount ==0) return 0; //  0 ways to form 0 
       
        if(coins[0]>amount) return -1; // if first coin after sorting greater than amount return -1
     
        int [] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<amount+1;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                if(coins[j]<=i)                     
                  dp[i] = Math.min(dp[i], dp[i-coins[j]]+1); 
            }
        }
        
        if(dp[amount]==amount+1) // if there is no difference in dp[amount]
            return -1;
        
        return dp[amount];
    }
}