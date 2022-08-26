// Time Complexity :O(c(amount))
// Space Complexity :O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I could understand how (1, 2, 5 ) = 11 in the question


// Your code here along with comments explaining your approach
class Solution {
    //dynamic programming: Bottom-up approach
    public int coinChange(int[] coins, int amount) 
    { 
        int[] dp = new int[amount + 1];
        
        //Fiils the array
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        //Loops over each coin in the coin array
        for(int coin : coins)
        {
            //Loops over the dp array
            for(int i = coin; i <= amount; i++)
            {
                //Updates the minimum value of the dp
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
        
        //Loops through the array and returns the amount of money made from the coin combination
        if(dp[amount] <= amount)
        {
             return dp[amount]; 
        }       
        else 
        {
           return - 1; //returns -1 if the amount of money cannot be made up by any combination of the coins.
        }
    }
}

// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
class Solution 
{
    //Dynamic programming
    public int rob(int[] nums) 
    {
        //Checks if there are houses to rob and returns zero, if there are none.
        if(nums.length == 0)
        {
            return 0;
        }
        
        int dp[] = new int[nums.length + 1];
        
        //The maximum value we can rob when we first start out from zero houses is zero.
        dp[0] = 0; 
        
        dp[1] = nums[0];
        
        //Checks the maximum value after robbing the first house.
        for(int i = 1; i < nums.length; i++)
        {
            //Calculates the maximum value at each house we rob.
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }
        return dp[nums.length];
    }
}