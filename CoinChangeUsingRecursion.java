// Time complexity is o(2^n) or exponential
// Space complexity is O(1) as we are not using any extra space.
// Leetcode gives Time limit on submission

public class CoinChangeUsingRecursion {
	public int coinChange(int[] coins, int amount) {
		return helper(coins, amount,0,0);
	}
	
	private int helper(int [] coins, int amount, int index, int min ) {
		//base cases
		if (amount<0 || index>=coins.length) {
			return -1;
		}
		if(amount ==0) return min;
		// our logic
		// case1: when we don't choose a coin
		int case1 = helper(coins, amount, index+1, min);
		// case2: when we choose the coin
		int case2 = helper(coins, amount-coins[index],index, min+1);
		if (case1 == -1) return case2;
		else if (case2 == -1) return case1;
		return Math.min(case1, case2);
	}
	public static void main(String[] args) {
	}
}
