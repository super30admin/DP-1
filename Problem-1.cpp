// Time Complexity : O(N*M)

// Space Complexity : O(N*M)

// Did this code successfully run on Leetcode : YES

// Appoarch: First solved it using recursion, the did tabulation
// to avoid TLE and avoid using stack space for dp.

// 322. Coin Change

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int coinChange(vector<int> &coins, int amount)
    {
        int n = coins.size();
        vector<vector<int>> dp(n + 1, vector<int>(amount + 1, 0));
        for (int t = 0; t <= amount; t++)
        {
            if (t % coins[0] == 0)
            {
                dp[0][t] = t / coins[0];
            }
            else
            {
                dp[0][t] = 1e9;
            }
        }
        for (int idx = 1; idx < n; idx++)
        {
            for (int t = 0; t <= amount; t++)
            {
                int notTake = 0 + dp[idx - 1][t];
                int take = INT_MAX;
                if (coins[idx] <= t)
                {
                    take = 1 + dp[idx][t - coins[idx]];
                }
                dp[idx][t] = min(notTake, take);
            }
        }
        int ans = dp[n - 1][amount];
        if (ans >= 1e9)
        {
            return -1;
        }
        return ans;
    }
};