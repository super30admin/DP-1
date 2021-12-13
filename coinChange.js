// Time Complexity : O(m x n): for each m(coins) we iterate through n(amount + 1) items
// Space Complexity : O(n): we use an aux array to store our numbers
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

var coinChange = function (coins, amount) {
  const dpArr = new Array(amount + 1).fill(Infinity);
  dpArr[0] = 0;

  for (let i = 0; i < coins.length; i++) {
    for (let j = 0; j < dpArr.length; j++) {
      if (j >= coins[i]) {
        let dpIndex = j - coins[i];
        dpArr[j] = Math.min(dpArr[dpIndex] + 1, dpArr[j]);
      }
    }
  }
  return dpArr[dpArr.length - 1] === Infinity ? -1 : dpArr[dpArr.length - 1];
};

console.log(coinChange([2], 3));
