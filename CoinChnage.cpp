#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
Start with a 2D matirx to solve the problem first and then convert it to a 1D DP
take the minimum of the current choose case and the previous case,
Finally check if the given amount is reached else return -1
*/
class Solution{
public:
    int coinChange(vector<int>& coins, int amount) {
        int n = amount;
        vector<int> dp(n + 1, 99999 );
        dp[0] = 0;

        for (int coin : coins){
            for (int j = coin; j <= n; ++j) {
                dp[j] = min(dp[j], 1 + dp[j - coin]);
            }
        }
        return dp[n] == 99999 ? -1 : dp[n];
    }
};
