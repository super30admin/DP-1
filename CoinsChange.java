// Time Complexity : O(m * n),m = coins.length,  n = amount
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

public class CoinsChange {
    
    public int coinChange(int[] coins, int amount) {
        
        if(coins==null || coins.length==0 || amount<=0) return 0;
           int m = coins.length;
           int n = amount;
           int[][] dp= new int[m+1][n+1];
           
           for(int j=1;j<n+1;j++){
               dp[0][j]=amount+1;
           }
           
           for(int i=1;i<m+1;i++){
               for(int j =1;j<n+1;j++){
                   
                   int case0 = dp[i-1][j];                 
                   int aIndex= j-coins[i-1];
                   int case1;
                   if(aIndex<0){
                       case1= amount+1;
                   }else{
                       case1 = dp[i][j-coins[i-1]]+1;    
                   }
                   dp[i][j] = Math.min(case0,case1);                
               }
               
           }
           if(dp[m][n]==amount+1) return -1;
           
           return dp[m][n];
           
           
       }






}
