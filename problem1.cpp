// Time Complexity : O(m*n), m = number of coin denominations, n = amount 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We use a 1D array, in which dp[i] stores the answer to: How many coins of denomination i-1 do we need to make amount?
// At each step we have 2 options: pick or no pick
// If we pick, we add 1 to the result and check the cell dp[j - coins[i-1]] and add that value to the current cell as well (return -1 if the dp[n] value is >= INT_MAX - 10)

class Solution {

public:
    int coinChange(vector<int>& coins, int amount) {
        int m = coins.size();
        int n = amount;
        vector<int> dp(n+1, 0);

        for(int j = 1; j<=n; j++) {
            dp[j] = INT_MAX - 10; // not possible to make any amount other than 0 with a coin of denomination 0
        }

        for(int i = 1; i<=m; i++) {
            for(int j = 1; j<=n; j++) {
                if(coins[i-1] <= j) {
                    dp[j] = min(dp[j], 1 + dp[j - coins[i-1]]); // min(no pick, pick)
                }
            }
        }

        if(dp[n] >= INT_MAX - 10) return -1; // not possible to make the amount
        return dp[n];
    }
};