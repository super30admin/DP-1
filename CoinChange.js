// Time Complexity : O ( m*n)
// Space Complexity : O (m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
  if (coins.length === 0 || coins === null) {
    return -1;
  }

  var n = coins.length;
  //create a 2D Matrix
  var matrix = new Array(n + 1);
  for (var i = 0; i <= n; i++) {
    matrix[i] = new Array(amount + 1);
  }
  //amount+1 equivalent to infinity
  for (var i = 1; i < amount + 1; i++) {
    matrix[0][i] = amount + 1;
  }
  //fill amount = 0 with zero
  for (var i = 0; i <= n; i++) {
    matrix[i][0] = 0;
  }
  //logic
  for (var i = 1; i < n + 1; i++) {
    for (var j = 1; j < amount + 1; j++) {
      if (j < coins[i - 1]) {
        matrix[i][j] = matrix[i - 1][j];
      } else {
        matrix[i][j] = Math.min(
          matrix[i - 1][j],
          matrix[i][j - coins[i - 1]] + 1
        );
      }
    }
  }
  //if result comes out infinity
  if (matrix[n][amount] === amount + 1) {
    return -1;
  }

  return matrix[n][amount];

  // console.log(matrix)
};
