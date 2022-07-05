//Time Complexity : O(2^n)
//Space Complexity : O(n) - Recursion Stack
//Solution accepted, but Time Limit Exceeded due to Exhaustive Search.


public class Problem1_ExhaustiveSearch {
	
	public int coinChange(int[] coins, int amount) {
		
		if(coins == null || coins.length ==0)
			return -1;
		
		int index = 0;
		int coinsUsed = 0; // no. of coins used; final answer
		
		return helper(coins, index, amount, coinsUsed);
		
        
    }
	
	private int helper(int[] coins, int index, int amount, int coinsUsed){
		
		if(amount < 0 || index == coins.length)
			return -1;
		
		if(amount == 0)
			return coinsUsed;
		
		//do not choose the coin at the current index
		int case1 = helper(coins, index +1, amount, coinsUsed);
		
		//choose the coin at the current index
		int case2 = helper(coins, index, amount - coins[index], coinsUsed +1);
		
		if(case1 == -1)
			return case2;
		
		if(case2 == -1)
			return case1;
		
		else
			return Math.min(case1, case2);
	}

}
