// Time Complexity : O(S^n) where S is the amount
// Space Complexity :)O(n)
// Did this code successfully run on Leetcode : TLE
// Description: Recursive approach

class Solution{
	public int coinChange(int[] coins, int amount){
		return helper(coins, amount, 0,0);
	}
	private int helper(int[] coins, int amount , int i, int min){
		//Base case
		if(amound < 0 || i> coins.length -1) {
			return -1;
		}
		if(amount == 0){
			return min;
		}
		//Choose the coin
		int case1 = helper(coins, amount - coins[i], i , min+1);
		//Don't choose the coin
		int case2 = helper(coins, amount, i + 1, min);
		
		if( case1 = -1){
			return case2;
		
		else if(case2 == -1)
			return case1;
		
		else return Math.min(case1, case2);
		
	}
}


// Time Complexity : O(n*S) where S in the amount
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Description: DP approach
class Solution{
	public int coinChange(int[] coins, int amount){
		int[][] dp = new int[coins.length+1][amount+1];
		int m = dp.length;//rows
		int n = dp[0].length; // columns
		
		//make first column all 0s
		for(int i=0; i<m; i++){
			dp[i][0] = 0;
		}
		
		//make first row infinity(here 99999 to prevent integer overflow during addition
		for(int i=1; i<n; i++){
			dp[0][i] = 99999;
		}
		for(int i=1 ; i<m; i++){
			for(int j=1; j<n; j++){
				if(j < coins[i-1]){
					dp[i][j] = dp[i-1][j];
				}
				else{   
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
				}
			}
		}
		int result = dp[m-1][n-1];
        return result>=99999 ? -1: result;
	}
}