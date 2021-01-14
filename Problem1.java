// Brute Force Solution
// Time Complexity - O(S^n)
// Space Complexity - O(n^2)
// This Solution did not work Successfully on Leetcode because it is not an optimized solution and the time limit exceeded.


class Solution {
    public int coinChange(int[] coins, int amount) {
        int min =0;
        return(helper(coins,0,min,amount));
    }
    private int helper(int[] coins,int i,int min,int amount){
        // Base Case
        if(amount==0)   return min;                         // if the amount is 0 , minimum denomination has been found
        if(amount <0 || i>=coins.length || min>99999)    return -1;     // Denomination cannot be found for any of these conditions
        //Recursion Logic  
        int Case1 = helper(coins,i,min+1,amount-coins[i]);  // When the denomination is chosen
        int Case2 = helper(coins,i+1,min,amount);           // When the denomination is not chosen
        if(Case1 ==-1)  return Case2;
        else if(Case2 ==-1) return Case1;
        else return Math.min(Case1,Case2);              // return the min value of coins between both the cases
        //return min;
    }
}

// Dynamic Programming
// Time Complexity - O(m*n) where m is the amount and n is the number of denominations; time used for creating the dp array of size n*m
// Space Complexity - O(m*n) where m is the amount and n is the number of denominations;  this space is the dp array space that we created.
  // Leet Code shows space complexity of  O(m) -- what is the correct one?
// This solution worked on Leetcode
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        int n = dp.length;
        int m = dp[0].length;
        for(int i=0;i<n;i++)
            dp[i][0] =0;
        for(int i=0;i<m;i++)
            dp[0][i] = 99999;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]]+1,dp[i-1][j]);
            }
        }
        if(dp[n-1][m-1] >=99999)    return -1;
        return dp[n-1][m-1];
    }
}
