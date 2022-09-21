//choose and not choose scenarios, recursion
//SC- exponential
//TC- Exponential
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length ==0) return -1;
        
        return helper(coins,  /*index*/0, amount, /*coins used*/0);
    }
	private int helper(int[] coins, int index, int amount, int coinsUsed)
	{
		//base case
		if(amount <0 || index == coins.length) return -1;
		if(amount==0) return coinsUsed;
		
		//not choose
		int case1 = helper(coins, index, amount, coinsUsed);
		
		//choose
		int case1 = helper(coins, index+1, amount-coins[index], coinsUsed+1);
		
		if(case1 == -1) return case2;
		if(case2 == -1) return case1;
		
		return Math.min(case1, case2);
	}
}


//Dynamic Programming - OptimizedApproach
//time complexity == O(m*n) ->m = coins.length, n = amount
//sc complexity = O(m*n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length ==0) return -1;
	
		int[][] dp = new int[coins.length+1][amount+1];
		
		for(int j =1; j <= amount; j++)
		{
			dp[0][j] = amount+1;
		}
		for(int i = 1; i <= coins.length; i++ )
		{
			for(int j =1; j<= amount; j++)
			{
				if(j <coins[i-1])
				{
					dp[i][j] = dp[i-1][j];
				}
				else
				{
					dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);	
				}
			}
		}
		if(dp[coins.length][amount] >= amount+1) return -1;
		return dp[coins.length][amount];
	}
}