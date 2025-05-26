// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
//Time complexity - O(mn)
// space - o(mn)
//solved on leetcode - yes
// Did you face any problem - no
// Using recursive solution the time complexity will be 2^(m+n) due to repeated subproblems, but to reduce this, we are using a dp array to store the solution of recursive problem and using them
class Solution {

   public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i <= coins.length; i++){
           dp[i][0] = 0;
       }

       for(int j = 1; j <= amount; j++){
           dp[0][j] = 99999;   
       }

      for(int i = 1; i <= coins.length; i++){

           for(int j = 1; j <= amount; j++){

               if(j < coins[i-1]){

                  dp[i][j] = dp[i-1][j];

               } else{

                   dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j - coins[i-1]]);

               }

           }

       }

       int result = dp[coins.length][amount];

       if(result >= 99999) return -1;

       else return result;

   }

//    public static int helper(int [] coins, int remainingAmount,int coinIndex, int currentNumberOfCoins){

//        if (remainingAmount < 0 || coinIndex > coins.length - 1) return -1;

//        if (remainingAmount == 0) return currentNumberOfCoins;

//        // Case 1 Don't choose the coin 

//        int noOfCoinsCase1 = helper(coins, remainingAmount, coinIndex + 1, currentNumberOfCoins);

//        // Case 2 Choose the coin

//        int noOfCoinsCase2 = helper(coins, remainingAmount - coins[coinIndex], coinIndex, currentNumberOfCoins + 1);

//       if (noOfCoinsCase2 == -1) return noOfCoinsCase1;

//       if (noOfCoinsCase1 == -1) return noOfCoinsCase2;

//       else return Math.min(noOfCoinsCase1, noOfCoinsCase2);

//    }

}

// Your code here along with comments explaining your approach
