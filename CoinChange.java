// Recursive TLE O(2^(m+n)) time, O(m+n) space
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int ans = helper(0, coins, amount);
//         if (ans == Integer.MAX_VALUE) return -1;
//         return ans;
//     }

//     public int helper(int i, int[] coins, int amount) {
//         if (amount == 0) return 0;

//         if (i == coins.length || amount < 0) {
//             return Integer.MAX_VALUE;
//         }

//         int dontPickCoin = helper(i+1, coins, amount);

//         int pickCoin = Integer.MAX_VALUE;
//         if (coins[i] <= amount) {
//             int temp = helper(i, coins, amount - coins[i]);
//             if (temp != Integer.MAX_VALUE) {
//                 pickCoin = 1 + temp;
//             }
//         }
//         return Math.min(pickCoin, dontPickCoin);
//     }
// }

// Bottom up DP O(n * m) time, O(n * m) space
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[][] dp = new int[n+1][amount+1];

        dp[0][0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[0][i] = Integer.MAX_VALUE-1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i-1] <= j) { // can pick
                    // min between pick and dont pick
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
                else {
                    // dont pick
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if (dp[n][amount] == Integer.MAX_VALUE-1) return -1;
        return dp[n][amount];
    }
}
