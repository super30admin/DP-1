// Time Complexity : O(2^(m+n))
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : No since time complexity is exponential which is why for some cases time limit exceeds.

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        return helper(coins, 0, amount, 0);
    }
    int helper(vector<int>& coins, int idx, int amount, int coinsUsed){
        //base
        if(amount == 0) return coinsUsed;
        if(amount < 0 || idx == coins.size()) return -1;
        //logic
        //choose
        int chose = helper(coins, idx, (amount - coins[idx]), coinsUsed + 1);
        //dont choose
        int reject = helper(coins, idx + 1, amount, coinsUsed);

        if(chose == -1) return reject;
        if(reject == -1) return chose;

        return min(chose, reject);

    }
};