// Problem - House Robber
//  Time Complexity : O(n)
//  Space Complexity : O(n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Here we use 1D DP dp[i] array which tells the max coins if we choose the
// house
// 2. We choose the max between prev house or curr house + dp[i-2](non adjacent
// house)
// 3. In the end we return dp[n] which holds the maximum amount we can rob

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int rob(vector<int> &nums) {
    int n = (int)nums.size();
    vector<int> dp(n + 2, 0);
    dp[1] = nums[0];

    for (int i = 2; i <= n; i++) {
      dp[i] = max(nums[i - 1] + dp[i - 2], dp[i - 1]);
    }

    return dp[n];
  }
};
