// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

var coinChange = function (coins, amount, index) {
  if (!index || amount - coins[index - 1] > amount) {
    return Infinity;
  }

  const excluded = coinChange(coins, amount, index - 1);
  const included = coinChange(coins, amount - coins[index - 1], index - 1);
};

coinChange([1, 2, 5], 11, 3);
