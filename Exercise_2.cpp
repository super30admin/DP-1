// Time Complexity                              :  O(N)
// Space Complexity                             :  O(N)
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n+1,0);
        // if we haven't robbed a house, we will have 0 money
        dp[0] = 0;
        for(int i=1;i<=n;i++) {
            if(i == 1) dp[i] = nums[i-1];                       // for the first house, we get the money we rob from it
            else if (i == 2) dp[i] = max(dp[i-1],nums[i-1]);    // for the second house, we get the maximum of robbing either house 0 or house 1.
            else dp[i] = max(dp[i-2] + nums[i-1], dp[i-1]);     // It gives maximum of money looted when last house was robbed and the sum of money of the current house looted and the house previous to the last one. 
        }
        return dp[n];
    }
};