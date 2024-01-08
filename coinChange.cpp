// Time Complexity :O(m*n) m is length of coins and n is amount
// Space Complexity :O(n) is amount
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector <int> dpAmount (amount + 1, amount+1);
        dpAmount[0] = 0;
        for (int i = 1; i < dpAmount.size(); i++){
            for(int j = 0; j < coins.size(); j++) {
                if(i - coins[j] >= 0) {
                    dpAmount[i] = min(dpAmount[i],  dpAmount[i - coins[j]]+1);
                }
            }
        }
        if(dpAmount[amount]>amount)
            return -1;
        return dpAmount[amount];
    }
};