import java.util.*;

public class problem1 {

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        int ans = helper(coins,amount,dp);
        
        if(ans>Integer.MAX_VALUE-10000){
            return -1;
        }else{
            return ans;
        }
    }
    public int helper(int[] coins, int amount,int[] dp){
        int ans = Integer.MAX_VALUE;
        
        if(amount == 0){return 0;}
        if(amount<0) return Integer.MAX_VALUE-10000;
        if(dp[amount]!=-1){return dp[amount];}
        
        for(int i=0;i<coins.length;i++){
       int count = 1 + helper(coins, amount-coins[i],dp);
            // +1 because we are choosing 1 coin and then will go with count
            ans = Math.min(ans,count);
        }
        
        return dp[amount] = ans;
    }
}
