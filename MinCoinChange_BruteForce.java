// Time Complexity :O(2^T/min(t)), n = number of coins, t = amount target
// Space Complexity : O(T/min(t))


public class MinCoinChange_BruteForce {
	public static int coinChange(int[] coins, int amount) {
		return helper(coins, amount, 0, 0);
	}

	public static int helper(int[] coins, int remainingAmount, int coinIndex, int currentNumberOfCoins) {
		if(remainingAmount < 0 || coinIndex > coins.length-1)
			return -1;
		
		if(remainingAmount == 0)
			return currentNumberOfCoins;
		
		//Case1: Not choosing coins
		int noOfCoinsCase1 = helper(coins, remainingAmount, coinIndex+1, currentNumberOfCoins);
		
		//Case2: Choosing the coins
		int noOfCoinsCase2 = helper(coins, remainingAmount - coins[coinIndex], coinIndex, currentNumberOfCoins+1);
		
		if(noOfCoinsCase2 == -1)
			return noOfCoinsCase1;
		if(noOfCoinsCase1 == -1)
			return noOfCoinsCase2;
		
		else return Math.min(noOfCoinsCase1, noOfCoinsCase2);
	}

}
