// Time Complexity :O(n m) n-length of the array coins. m- array created with length amount+1
// Space Complexity :O(m) 
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this : understanding the bottom up approach
class Solution {
    public int coinChange(int[] coins, int amount) {
     int dp[]=new int[amount+1]; // to solve sub problems first and use it later in the array we create an array with length amount+1
	                             // amount +1 because we use index as amount and store the minimum coins required as values
	//edge cases
     if(amount==0 ) return 0;
     if(coins==null || coins.length==0) return -1;
	 
     Arrays.fill(dp,amount+1);// fill array values as a max amount as default
     int i=0,j=1;
     dp[0]=0; // no coins required for amount 0
     while(j<dp.length)
     {
         for(i=0;i<coins.length;i++)
         {
         if(coins[i]<=j) // checking if a coin is less than the amount
         {
             dp[j]=Math.min(dp[j],dp[j-coins[i]]+1); // performing j-coins[i] is one usage of coin and the rest copied from the subarray at the index j-coins[i] 
         }
         }
         j++;
    
     }
	 // On one worst case if the coin is 1 and amount is 10 it still takes 10 min coin changes. 
	 //Hence the condition dp[amount]<=amount 
	 //If the amount cant be made with the coins given then the default value amount+1 will be in dp thus will return -1  
        return dp[amount] <= amount? dp[amount]:-1; 
    }
}

// Approach taught in class
// Time Complexity :O(n m) n-length of the array coins. m- array created with length amount+1
// Space Complexity :O(n m) 
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0) return -1;
        int[][] dp=new int [coins.length+1][amount+1];
        for(int i=0;i<dp[0].length;i++)
        {
            dp[0][i]=amount+1;
        }
        
        for(int i=1;i<coins.length+1;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(coins[i-1]>j)
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        return dp[coins.length][amount]>=amount+1?-1:dp[coins.length][amount];
    }
}
*/