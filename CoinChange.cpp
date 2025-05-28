#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int m = coins.size();
        int n = amount;

        vector<int>dp(n+1);

        for (int j = 1; j <= n; j++) {
            dp[j] = 99999;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < coins[i - 1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = min(dp[j], 1 + dp[j - coins[i - 1]]);
                }
            }
        }
        if (dp[n] == 99999) 
            return -1;
        return dp[n];
    }
};