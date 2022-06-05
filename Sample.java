//****COIN CHANGE - DP APPROACH****
// Time Complexity :O(M * N) M- NUMBER OF COINS , N- AMOUNT
// Space Complexity :O(1);
// Did this code successfully run on Leetcode :Y
// Any problem you faced while coding this :N
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m= coins.length;
        int n=amount;
        int [][] dp= new int[m+1][n+1];
        
        //first row 
        for(int j=1;j<dp[0].length;j++)
        {
            dp[0][j]=99999;
        }
        
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(j<coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=Math.min(dp[i-1][j], dp[i][j-coins[i-1]] +1);
                }
            }
        }
        
        if(dp[m][n]>=99999) return -1;
        return dp[m][n];
        
    
    }
}
//****COIN CHANGE - RECURSIVE APPROACH****
// Time Complexity :O(M * N) M- NUMBER OF COINS , N- AMOUNT
// Space Complexity :O(1);
// Did this code successfully run on Leetcode :Y
// Any problem you faced while coding this :N

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        return helper(coins, amount, 0 , 0);
        
    }
    
    private int helper(int[] coins, int amount, int i, int mincoins)
    {
        //BaseCase::
        if(amount==0) return mincoins;
        if(amount<0 || i==coins.length) return -1;
        
        
        
        
        //Logic::
        
        //To choose
        int case1=helper(coins, amount-coins[i], i, mincoins + 1);
        
        //Not to choose
        int case2=helper(coins, amount, i+1, mincoins);
        if(case1==-1) return case2;
        if(case2==-1) return case1;
        
        return Math.min(case1, case2);
    }
}

//****HOUSE ROBBER- RECURSIVE APPROACH****
//Time complexity: o(2^n);
//Space complexity: o(n);
//Leetcode runnable: Y
//Any doubts: N
class Solution {
    public int rob(int[] nums) {
        //null case: 
        if(nums.length==0 || nums==null) return 0;
        
        return helper(nums, 0, 0);
        
        
    }
    private int helper(int[] nums,int i,int amount)
    {
        //base
        if(i>=nums.length)
        {
            return amount;
        }
        
        //logic
        //choose
        int c1= helper(nums, i+2, amount+nums[i]);
        //not to choose
        int c2=helper(nums, i+1, amount);
        
        return Math.max(c1,c2);
    }
}

//****HOUSE ROBBER- DP APPROACH****
//Time complexity: o(n);
//Space complexity: o(n);
//Leetcode runnable: Y
//Any doubts: N
class Solution {
    public int rob(int[] nums) {
        //null case: 
        if(nums.length==0 || nums==null) return 0;
        
        return helper(nums, 0, 0);
        
        
    }
    private int helper(int[] nums,int i,int amount)
    {
        //base
        if(i>=nums.length)
        {
            return amount;
        }
        
        //logic
        //choose
        int c1= helper(nums, i+2, amount+nums[i]);
        //not to choose
        int c2=helper(nums, i+1, amount);
        
        return Math.max(c1,c2);
    }
}
