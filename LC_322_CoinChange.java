// Time Complexity : O(A*n) - Since it has nested for loops(coins & amount)
// Space Complexity :O(n+1) - Made use of dummy array 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Array out of bound of exception because of dp[i-coins[j]] condition
//later on handled in if condition


// Your code here along with comments explaining your approach

import java.util.*;
import java.io.*;

class CoinChange{
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		
		System.out.println("Minimum coins: " + findMinimumCoins(coins,amount));
	}
	
	public static int findMinimumCoins(int[] coins, int amount) {
		//Declare an array to store minimum number of coins required to store certain amount
		int[] dp= new int[amount+1];
		//Fill the array with dummy value greater than 11
		Arrays.fill(dp,  amount+12);
		//Initialize first element to 0;
		//Since 0 coins needed to for 0 amount
		dp[0]= 0;
		for(int i= 1; i<= amount;i++) {
			for(int j= 0; j< coins.length; j++) {
				if(coins[j] <= i) {
					dp[i] = Math.min(dp[i-coins[j]] + 1, dp[i]);
				}
			}
		}
		//dp[amount] will contain the final answer
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
