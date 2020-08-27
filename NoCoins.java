// TC: O(Math.pow(2, n) where n is the number of coins - this complexity is for recursion

// DP Solution
// TC: O(S*N) where N is the number of coins and we are iterating each coin and we are storing S values in the table.
//SC: O(S)  - where we are using S values to store in the dp table.

// We are starting from the amount 0 till our final amount so that we can store all the subproblems of the amount for each denomination
// . We are having a table to store the subproblems of the calculated amount, we will be calculating the minimum of previous subproblem minus the remainingAmount.
// here the remainingAmount is subtracting currentamount by that particular coin denomination if and only if the current coin denomination is less than the amount.
// If our amount in the new table excess actual amount, we will return -1 or else we will return last amount in the table
import java.util.Arrays;

public class NoCoins {
	
	public int noCoins(int[] coins, int amount) {
		return helper(coins, 0, 0, amount);
	}
	
	public static int helper(int[] coins, int noCoins, int coinIndex, int remainingAmount) {
		
		if(remainingAmount<0 || coinIndex>coins.length-1)
			return -1;
		
		if(remainingAmount == 0) {
			return noCoins;
		}
		
		int choosen = helper(coins, noCoins+1, coinIndex, remainingAmount-coins[coinIndex]);
		int notChoosen = helper(coins, noCoins, coinIndex+1, remainingAmount);
		
		if(choosen == -1)
			return notChoosen;
		else if(notChoosen==-1)
			return choosen;
		else
			return Math.min(choosen, notChoosen);
	}
	
	public static int noCoinsCnt(int[] coins, int amount) {
		
		int remainingAmount = 0;
		int[] dp = new int[amount+1];
		Arrays.fill(dp, amount+1);
		dp[0] = 0;
		
		for(int i=0;i<coins.length;i++) {
			for (int j=1;j<=amount;j++)
			{
				if(coins[i]<=j) {
				remainingAmount = j - coins[i];
				dp[j] = Math.min(dp[j], 1+dp[remainingAmount]);
				}
			}
		}
		return (dp[amount]>amount)? -1: dp[amount];
	}
	
	public static void main(String[] args) {
		
		NoCoins nc = new NoCoins();
		int[] coins =  {2};
		System.out.println(NoCoins.noCoinsCnt(coins, 3));
	}

}
