// Time Complexity : O(m*n) //the size of the matrix
// Space Complexity : O(n) //not sure
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//approach 1: Bottom Up DP coin change
class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1]; //new matrix to store all the possibility 
        
        //fill the first column of every row as 0
        for(int i=1; i<dp.length; i++)
        {
            dp[i][0]= 0; 
        }
        
        //fill the first row and each column with infinity 
        for(int j=0; j<dp[0].length; j++)
        {
            dp[0][j]= amount+1; //infinity
        }
        
        //calculate the number of coins needed to make each amount 
        // used the logic of  bottom up DP
        for(int i=1; i<dp.length; i++)
        {
            for(int j=1; j< dp[0].length; j++)
            {
                if(j<coins[i-1])
                {
                    dp[i][j]= dp[i-1][j]; //if value is less than use the above number of coin 
                }
                else
                {
                    dp[i][j]= Math.min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]); // less calculate the number of coins
                }
            }
        }
        
        int result= dp[dp.length-1][dp[0].length-1]; 
        if(result> amount)
        {
            return -1;
        }
        return result; 
        
        
    }
}

//approach 2: Recursive method coin change

class Solution2 {
    public int coinChange(int[] coins, int amount) {
        
        // Time Complexity= 2^n
        if(coins==null || coins.length== 0) return -1; 
            
        return helper(coins,amount,0,0); //start with the 0th index of the coins array and number of min coins=0 
    }
    
    private int helper( int[] coins, int amount, int index, int min)
    {
        
        if(amount==0) return min; //if amount is finished
        if(index==coins.length || amount < 0) return -1; //negative amount or out of bound in the coins array
        //use the coin 
        int case1= helper(coins, amount-coins[index], index, min+1);
            
        //did not use the coin
        int case2= helper(coins,amount, index+1, min); 
        
        if(case1==-1)
        {
            return case2; 
        }
        
        if(case2==-1)
        {
            return case1; 
        }
        
        return Math.min(case1,case2); //minimum of both the cases. 
    }
 }

 //House Robber Problem

 // Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

 //Approach 1: 
 class Solution1 {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0; 
        
        int[][] dp= new int[nums.length][2]; 
        dp[0][1]= nums[0];
        for(int i=1; i<nums.length;i++)
        {
            //not choose
            dp[i][0]= Math.max(dp[i-1][0], dp[i-1][1]);
            
            //choose 
            dp[i][1] = dp[i-1][0] + nums[i]; 
        }
        
        return Math.max(dp[dp.length-1][0] , dp[dp.length-1][1]);
        
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//Approach 2: 
class Solution2 {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0; 
        
        int skip= 0;
        int take= nums[0]; 
        for(int i=1; i<nums.length;i++)
        {
            int temp = skip; 
            //not choose
            skip= Math.max(skip, take);
            
            //choose 
            take = temp + nums[i]; 
        }
        
        return Math.max(skip , take);
        
    }
}
