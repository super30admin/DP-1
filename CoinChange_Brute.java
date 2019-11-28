class Solution {

	//	Time: Exponential O(2^n) or O(amount^n)
	//	Space O(1) ignoring recursive stack
	//	LeetCode: Time limit excedded

	public int coinChange(int[] coins, int amount) {
		if(coins == null) return -1;
		return helper(coins,0, amount, 0);
	}

	private int helper(int[] coins, int i ,int amount ,int min){
		if (amount < 0 || i > coins.length - 1) return -1;
		if (amount == 0) return min;
		// /case1 : chosen 
		int case1 = helper(coins,i, amount - coins[i], min+1);
		//case2 not chosen
		int case2 = helper(coins,i+1 ,amount, min);
		int result = Math.min(case1, case2);
		
		if(case1 == -1 ) return case2;
		else  if(case2 == -1) return case1;
		else return result;
	}
}