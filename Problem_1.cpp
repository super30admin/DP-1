/*
 * Time Complexity : O(n*amount)
 * Space Complexity : O(amount)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>

class Solution {
public:
    int coinChange(std::vector<int>& coins, int amount) {
        int dp[amount + 1];
        const int MAX = amount + 1;

        // fill(start_index, start_index + amount + 1, element_to_fill)
        std::fill(dp, dp + amount + 1, MAX);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i)
                    dp[i] = std::min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == MAX ? -1 : dp[amount];
    }
};
