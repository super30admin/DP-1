// Time Complexity : O(2^n)  n is amount/minimum denomination
// Space Complexity : O(n*a) n is coins length and a is amount.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Used the Memoization Approach. 
class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount+1];
       int ans = coinChange(coins,0,amount);
        if(ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }
    
   int coinChange(int[] coins, int index, int amount){
       
        //Edge cases
        if(amount == 0)
            return 0;
        if(amount<0 || index == coins.length)
            return Integer.MAX_VALUE;
       if(dp[index][amount] == 0){
           
        //Not choosing
        int nchoose = coinChange(coins, index+1, amount);
        
        //Choosing
        int choose = coinChange(coins, index, amount-coins[index]);
        
        if(choose != Integer.MAX_VALUE){
            choose = choose + 1;
        }
           dp[index][amount] = Math.min(choose, nchoose);
       }
        
        return dp[index][amount];    
    }    
}
