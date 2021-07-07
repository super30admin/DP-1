//Coin Change problem
// Time Complexity : 0(m*n)
// Space Complexity : 0(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, as video was awesome


// Your code here along with comments explaining your approach







class Solution {
    public int coinchange(int[] coins, int amount) {

     int dp[][] = new int [coins.length + 1][amount + 1];
     for(int i = 0; i < dp.length; i++){
         dp[i][0] = 0;// initialize the first column to zero

     }
      for(int j = 1; j < dp[0].length; j++){
          dp[0][j] = 9999; // initialize the first row to zero
      }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i - 1][j]; // assign the element from above to row required till amount is less than the denomination mentioned here
                }
                else{
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]); // take the minimum of the number of coins already calculated and the number of coins above
                }
            }
        }

        int result = dp[dp.length - 1][dp[0].length - 1];
        if(dp[dp.length - 1][dp[0].length - 1] >= 9999) return -1; // to check the final result is valid or not
        return result;
    }
}


