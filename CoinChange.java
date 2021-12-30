package dp1;

import java.util.Arrays;

public class CoinChange {
	//Time Complexity : O(n*m), where n is the amount and m is length of array coins
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        Arrays.sort(coins);
        for(int i=0; i<=amount; i++) {
            for(int j=0; j<coins.length; j++) {
                if(i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                } else 
                    break;
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
