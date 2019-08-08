/**
 * Time: O(n^2)
 * Space: m*n
 * Leetcode Accepted: yes
 * Any problems faced: NA
 */
public class CoinChange {
	public static int coinChange(int[] coins, int amount) {
	     return coinChange(coins, amount, 0, 0);
	}
	//Tried the Recursion as well
	private static int coinChange(int[] coins, int amount, int i, int min) {
		// Base Case
		if(amount == 0) return min;
		if(i >= coins.length || amount < 0) return -1;
		// Select the element at ith position
		int case1 = coinChange(coins, amount-coins[i], i, min+1);
		// Don't select the element at ith position
		int case2 = coinChange(coins, amount, i+1, min);
		if(case1 == -1) return case2;
		if(case2 == -1) return case1;
		return Math.min(case1, case2);
	}
	
	//Dynamic Programming
	private static int coinChangeDp(int[] coins, int amount) {
		int[][] arr = new int[coins.length+1][amount+1];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(i==0) arr[0][j] = 9999;
				else if(j==0) arr[i][0] = 0;
				//For those denominations greater than the amount, the number of coins that make up the amount will be equal to that of the previous denomination 
				else if(coins[i-1]>j) {
					arr[i][j] = arr[i-1][j];
				}
				//If the previous denomination can make up the amount in less number of coins take that
				else {
					arr[i][j] = Math.min(arr[i][j-coins[i-1]]+1, arr[i-1][j]);
				}
			}
		}
		if(arr[coins.length][amount] >= 9999) return -1;
		return arr[coins.length][amount];
	}

	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 11;
		System.out.println(coinChangeDp(coins, amount));
	}

}
