// Time Complexity :
//      n - number of coins and k - amount to be made
//      coinChange() - O(nk)
//      
// Space Complexity :
//      coinChange() - O(k)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Problem1 {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return -1;
        else if(amount == 0) return 0;
        else
        {
            int[] dp = new int[amount + 1];
            
            for(int i = 1; i < dp.length; ++i)
                dp[i] = Integer.MAX_VALUE - 1;
            
            for(int i = 0; i < dp.length; ++i)
            {
                for(int j=0; j < coins.length; ++j)
                {
                    if(i >= coins[j])
                        dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
            
            if(dp[dp.length-1] == Integer.MAX_VALUE - 1)
                return -1;
            return dp[dp.length-1];
        }
    }
}