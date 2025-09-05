// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
#include <vector>
#include <algorithm> 
#include <climits>   
using namespace std;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if (amount < 1) return 0;

        //initilialize a dp array with values (each index = min coins required to form index amount)
        vector<int> dp(amount + 1, INT_MAX);

        //base case
        dp[0] = 0;

        //loop through the dp array
        for (int i = 1; i <= amount; ++i) {
        // for each index of dp array, loop through coins to get different coin combinations, use previous dp indexes to calculate number of coins, get minimum coins
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != INT_MAX) {
                    dp[i] = min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

      if(dp[amount] == INT_MAX) return -1;
       return dp[amount];
    }
};
