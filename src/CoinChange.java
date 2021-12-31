public class CoinChange {
   // Brute Force
    // m = amount , n = denominations
    // Time Complexity : O(2^(m+n))
// Space Complexity : O(m+n0
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


    class Solution {
        public int coinChange(int[] coins, int amount) {
            if(coins == null) return -1;
            return helper(coins, amount, 0, 0);
        }

        private int helper(int coins[], int amount, int index, int coinUsed) {

            //base
            if(amount == 0) {
                return coinUsed;
            }
            if(amount < 0 || index == coins.length) return -1;
            //logic
            int case1 = helper(coins, amount-coins[index], index, coinUsed+1);
            int case2 = helper(coins, amount, index+1, coinUsed);
            if(case1 == -1) return case2;
            if(case2 == -1) return case1;

            return Math.min(case1, case2);
        }
    }

    //DP - solution
// m = amount , n = denominations
    // Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
        public int coinChange(int[] coins, int amount) {
            int dp[][] = new int[coins.length+1][amount +1];
            dp[0][0] = 0;
            for(int j=1; j< dp[0].length; j++) {
                dp[0][j] = amount+1;
            }

            for(int i=1; i<dp.length; i++) {
                for(int j=1; j<dp[0].length; j++) {
                    if(j < coins[i-1]) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i - 1]] + 1);
                    }
                }
            }
            int result =  dp[dp.length -1][dp[0].length-1];
            if(result > amount) {
                return -1;
            }
            return result;
        }

}
