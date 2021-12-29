import java.util.Arrays;

// Time Complexity : O(M*N),  where M is the amount and N is the denomination count
// Space Complexity : O(M) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
public class Problem1 {
	  public int coinChange(int[] coins, int amount) {
	        int max = amount +1;
	        int dp[] = new int[amount+1];
	        Arrays.fill(dp,max);
	        dp[0] =0;
	        for(int i=1;i<=amount;i++){
	            for(int j = 0;j<coins.length;j++){
	                if(coins[j]<=i){
	                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
	                }
	            }
	        }
	        return dp[amount] > amount ? -1 : dp[amount];
	    }
}
