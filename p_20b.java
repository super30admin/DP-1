// Time Complexity :o(m*n)
// Space Complexity :o(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approachclass Solution {
   
    public int coinChange(int[] coins, int amount) {
       int[][] dp = new int[coins.length + 1][amount + 1];
       dp[0][0] = 0;
       for(int j = 1 ; j < dp[0].length ; j++)
       {
           dp[0][j] = amount + 1;
       }
       for(int i = 1; i < dp.length ; i++)
       {
           for(int j = 1; j < dp[0].length; j++){
               //amount < denmon coin only case 1 available
               if(j < coins[i  - 1]){
                    dp[i][j] = dp[i-1][j];
               }
               else{
                   dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
               }
           }
       }
       int result = dp[dp.length - 1][dp[0].length - 1];
       if(result > amount)return -1;
       return result;
    }
}