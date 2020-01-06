package CoinChange_DP_322;



//322. Coin Change
//You are given coins of different denominations and a total amount of money amount.
//Write a function to compute the fewest number of coins that you need to make up that amount. 
//If that amount of money cannot be made up by any combination of the coins, return -1.
//		
//		Example 1:
//			Input: coins = [1, 2, 5], amount = 11
//			Output: 3 
//			Explanation: 11 = 5 + 5 + 1
//
//		Example 2:
//
//			Input: coins = [2], amount = 3
//			Output: -1

//Time Complexity  :  O(m*n)
//Space Complexity :  O(m*n)

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,2,5};
		int amount = 11;
		System.out.println(Integer.MAX_VALUE);
		System.out.println(coinChange(coins,amount));

	}
	public static int coinChange(int[] coins, int amount) {
		int max = Integer.MAX_VALUE -1 ;
		int dp[][] = new int[coins.length + 1][amount + 1];
//		int m = dp.length;
//		int n = dp[0].length;
		
		for(int i = 0 ; i < dp.length ; i++)
		{
			dp[i][0] = 0;
		}
		
		for(int j = 1 ; j < dp[0].length ; j++)
		{
//			dp[0][j] = 99999;
			dp[0][j] = max;
		}
		
		for(int i=1; i < dp.length;i++)
		{
			for(int j=1 ; j < dp[0].length ; j++)
			{
				if( j < coins[i-1])
				{
					dp[i][j] = dp[i-1][j];
				}else
				{
					dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j - coins[i-1]]); 
				}
				
				
				
			}
		}
		
		int ans = dp[dp.length-1][dp[0].length-1];
		
		if(ans == max)
		{
			return -1;
		}
		
		
		
		
		return ans;

	}

}
