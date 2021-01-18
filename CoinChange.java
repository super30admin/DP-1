import java.util.Arrays;
//Time Complexity : O(n)
//Space Complexity : O(n)
public class CoinChange {

		public static void main(String[] args) {
			int coins[] = {1,2,5};
			int amount = 11;
			System.out.println(" minimum coins used = " + coinChange(coins, amount));
		}
		 public static int coinChange(int[] coins, int amount) {
		       int max = amount + 1;
		        int[] dp = new int[max];
		        Arrays.fill(dp, max);
		        dp[0] = 0;

		        for (int i=1 ; i <= amount; i++) {
		            for (int coinval : coins) {
		                // if coinvalue is less than or equal to the amount
		                if (coinval <= i) { 
		                    dp[i] = Math.min(dp[i], dp[i - coinval] + 1);
		                }
		            }
		        }

		        // account for overflow.
		        return dp[amount] > amount ? -1 : dp[amount];
		    }
	}
