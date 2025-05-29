public class CoinChange {
    /* Intuition : Classic DP
time : O(n^2)
space: O(n^2)
*/

        public int coinChange(int[] coins, int amount) {
            int m = amount;
            int n = coins.length;

            int[][] dp = new int[n + 1][m + 1];

            dp[0][0] = 0; //always 0

            for (int j = 1; j <= m; j++) { //filling rest of array with infinity
                dp[0][j] = m + 1; //m is the max we can go so m+1 is kind of infinity
            }

            //we start at index 1 for column and start dp calculations
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    //till amount < denmonator of current largest coin - copy from above
                    if (j < coins[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]); //remember i starts from 1
                    }

                }
            }

            if (dp[n][m] >=  m+1) //random 10
            {
                return -1; //return infinity
            }

            return dp[n][m];

        }
    }

