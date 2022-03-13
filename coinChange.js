// Time Complexity : O(S*n) where S is amount and n is coin denominator
// Space Complexity : O(S)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
    let dp = [new Array(amount+1).fill(Infinity)];
    dp[0][0] = 0;
    for(let i=1; i<coins.length+1; i++) {
        for(let j=1; j<dp[0].length; j++) {
            if(!dp[i]) {
                dp[i] = new Array(dp[0].length);
                dp[i][0] = 0;
            }
            if(coins[i-1]>j) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]])
           }
        }
    }
    let result = dp[dp.length-1][dp[0].length-1];
    return result > amount ? -1 : result;
};