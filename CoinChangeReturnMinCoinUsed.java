public class CoinChangeReturnMinCoinUsed {

// Did this code successfully run on Leetcode : this is recursive solution gives time limit exceeds error
    class Solution1 {
        public int coinChange(int[] coins, int amount) {
            return helper(coins, 0, amount, 0);
        }

        private int helper(int[] coins, int i, int amount, int coinUsed){
            //null checks
            if(amount==0) return coinUsed;
            if(amount<0 || i==coins.length) return -1;
            //case 1 when we don't select the coin (0)
            int case1 = helper(coins, i+1, amount, coinUsed);
            //case 2 when we do select the coin (1) // here the ask is how many coins in total used so      previous +1
            int case2 = helper(coins, i, amount-coins[i], coinUsed+1);
            if(case1 == -1) return case2;
            if(case2 == -1) return case1;
            int min = Math.min(case1, case2);
            return min;
        }
    }
// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
    class Solution2 {
        public int coinChange(int[] coins, int amount) {
            int m = amount;
            int n = coins.length;
            //taking 2D matrix (rxc). taking +1 becz we are adding dummy row
            int[][] dp = new int[n+1][m+1];
            for(int i = 1; i <= m; i++){
                dp[0][i] = 99999; // putting infinite value in row one except (0,0) index
            }

            for(int i=1; i<=n; i++){
                for(int j =1; j<=m; j++){
                    if(j<coins[i-1]){
                        dp[i][j] = dp[i-1][j];
                    }
                    else {
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] +1);
                    }
                }
            }
            if(dp[n][m] >= 99999) return -1;
            return dp[n][m];
        }
    }

 // Time Complexity : O(m)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

    //Optimize  solution using 1D array
    class Solution3 {
        public int coinChange(int[] coins, int amount) {
            int m = amount;
            int n = coins.length;
            // optimize solution is using 1d array and override the elements as we only need the previous row data
            int[] dp = new int[m+1];
            for(int i = 1; i <= m; i++){
                dp[i] = 99999; // putting infinite value in row one except (0,0) index
            }

            for(int i=1; i<=n; i++){
                for(int j =1; j<=m; j++){
                    if(j<coins[i-1]){
                        dp[j] = dp[j];
                    }
                    else {
                        dp[j] = Math.min(dp[j], dp[j-coins[i-1]] +1);
                    }
                }
            }
            if(dp[m] >= 99999) return -1;
            return dp[m];
        }
    }
}
