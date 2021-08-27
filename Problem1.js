// Time Complexity : O( m x n) m number of coin, n is the amount
// Space Complexity : O(n) n is amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes creating the 2d matrix.

var coinChange = function (coins, amount) {
    if (!coins || coins.length === 0) return 0;

    var dp = new Array(coins.length + 1);
    for (var i = 0; i < dp.length; i++) {
        dp[i] = new Array(amount + 1);
        dp[i][0] = 0;
    }


    for (let j = 0; j < dp[0].length; j++) {
        dp[0][j] = amount + 1;
    }
    for (let i = 1; i < dp.length; i++) {
        for (let j = 1; j < dp[0].length; j++) {
            if (j < coins[i - 1]) {
                dp[i][j] = dp[i - 1][j];
            } else {
                // console.log( 1 + dp[i][j - coins[i - 1]]);
                dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
            }
        }
    }
    if (dp[dp.length - 1][dp[0].length - 1] > amount) return -1;
    return dp[dp.length - 1][dp[0].length - 1];

}