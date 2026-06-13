// Time Complexity : O(mxn)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no 


// Your code here along with comments explaining your approach

//Using the DP we will set the for each coin we will asign hingher value than amount  and 
//find the minimum coins for amount j is either the old answer, or using this coin plus 
// the best answer for the remaining amount.

class CoinChange{
    public int coinChange(int[] coins, int amount) {
       
          int n = coins.length;
          int []dp = new int[amount+1];

          for(int i = 1; i <= amount; i++){
               dp[i] = amount+1;
          }

          for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i-1] <= j){
                   dp[j] = Math.min(dp[j], dp[j-coins[i-1]]);
                }
            }
          }
        
        if(dp[amount] > amount){
            return -1;
        }

        return dp[amount];
    }
}
