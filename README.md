# DP-1

## Problem1 (https://leetcode.com/problems/coin-change/)
// Time Complexity : O( M * N), where M= amount, N = number of coin denominations 
// Space Complexity :  O( M * N), comes from the size of the dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
       int dp[][] = new int[coins.length+1][amount +1 ];
        
        dp[0][0] = 1;
        for(int j=1; j< dp[0].length; j++)
        {
            dp[0][j] = amount+1;
        }
        
        for(int i=1; i< dp.length; i++)
        {
            for (int j=1; j< dp[0].length; j++)
            {
                if(j < coins[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] +1);
                }
            }
        }
        
        int result = dp[dp.length-1][dp[0].length-1];
        if(result > amount ) return -1;
        else return result;
        
        
    }
    
   /* private int coinChange(int index, int[] coins, int amount, int count)
    {
        //base 
        if (amount == 0)
            return count;
        
        if(amount < 0 || index == coins.length)
            return -1;
        
        //case 1: we select the coin at index i 
        int includeCoin = coinChange(index,  coins, amount-coins[index], count +1);
        
        //case 2: we do not select the coin at index i 
         int excludeCoin = coinChange(index +1 ,  coins, amount, count);
        
        if(includeCoin == -1) return excludeCoin;
        if(excludeCoin == -1) return includeCoin;
        
        
        
        return Math.min(includeCoin, excludeCoin);
        
    }*/
    
    
}
## Problem2 (https://leetcode.com/problems/house-robber/)
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        int temp =0;
        int skip=0, take =0;
        
        for(int i=0; i< nums.length; i++)
        {
            temp = skip;
            skip =Math.max(skip, take);
            take = temp + nums[i]; 
        }
        
        return Math.max(skip, take);
    }
    
    
   /*  public int rob(int[] nums) {
         if(nums == null) return 0;
         
         return houseRobbers(0, 0, nums);
     }
    
    // exhaustive recursive approach 
    private int houseRobbers(int index, int amountRobbed, int[] profits)
    {
        //base
        if(index >= profits.length) return amountRobbed;
        
        //logic 
        //SKIP : don't rob this house 
        int skip = houseRobbers(index+1, amountRobbed, profits);
        //TAKE : rob this house 
        int take = houseRobbers(index+2, amountRobbed + profits[index], profits);
        
        return Math.max(skip, take);
    }
    */
}
