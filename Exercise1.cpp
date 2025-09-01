// Problem - Coin Change
//  Time Complexity : O(m*n)
//  Space Complexity : O(n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Here we use 1D DP dp[j] array which tells the min coins needed to make
// amount j
// 2. If we reach a coin denomination which is smaller or equal to amount then
// only we take min of the current value, or current amount - coins denomination
// value or we skip it
// 3. If we still have INT_MAX - 10 as value then we return -1;

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int coinChange(vector<int> &coins, int amount) {
    int m = (int)coins.size();
    int n = amount;
    vector<int> dp(n + 1, INT_MAX - 10);
    dp[0] = 0;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (coins[i - 1] <= j) { // If I reach a coin denomination which is
                                 // smaller or equal to amount
          dp[j] = min(dp[j], 1 + dp[j - coins[i - 1]]);
        }
      }
    }

    return dp[n] == INT_MAX - 10 ? -1 : dp[n];
  }
};
