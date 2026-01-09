/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}

Intuition:

I am using dynamic programming with tabulation. 
 
The DP table dp[i][j] represents the minimum number of coins needed to make amount j using the first i coin denominations.

I initialize dp[0][0] to handle the base case, since zero coins are needed to make amount zero, and all other values in the first row are set to infinity because no amount greater than zero can be formed without any coins. 

If the current coin denomination is greater than the current amount, I copy the value from the previous row (dp[i-1][j]) because the coin cannot be used. 

Otherwise, I take the minimum of not using the coin (dp[i-1][j]) and using the coin at least once (1 + dp[i][j - coin]), since coins can be used an unlimited number of times.
 */

// Tabulation
var coinChange = function (coins, amount) {
    const m = coins.length;
    const n = amount;
    //  m + 1 to accomadate 0 row
    const dp = Array.from({
        length: m + 1
    }, () => []);
    // base case
    dp[0][0] = 0;
    // initialize the first row with infinity
    for (let i = 1; i <= n; i++) {
        dp[0][i] = Infinity - 100;
    }

    for (let i = 1; i <= m; i++) {
        for (let j = 0; j <= n; j++) {
            if (j < coins[i - 1]) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
            }
        }
    }

    return dp[m][n] >= Infinity ? -1 : dp[m][n];
};