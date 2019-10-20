// here the time complexity is O(m*n) and space complexity is O(m*n) 
// here we are making a matrix of coins. length +1 (because we are adding one more row with all corresonding columns having a big number in it)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][] dp= new int [coins.length+1][amount+1];
        int m=dp.length; // no of rows
        int n=dp[0].length; // no of columns
        for(int i=0;i<m;i++)
        {
            dp[i][0]=0;    
        }
         for(int i=0;i<n;i++)
        {
            dp[0][i]=99999;    // taking high value rather than INT_MAX beacuse some operation on this may lead to its range overflow
        }
         for(int i=1;i<m;i++)   // for rows
         {
             for(int j=1;j<n;j++) // for columns
              {
                   
                 if(j<coins[i-1])
                 {
                     dp[i][j]=dp[i-1][j];   // if amount is less than the coin then take the upper value
                 }
                 else
                     dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);  // go back by coins[i-1] and add 1 to the value calculated there and find min with the above calculated value.
         }
         }
             int result=dp[m-1][n-1];
             if(result>=99999)
             {
                 return -1;
             }
             return result;
        
    }
}