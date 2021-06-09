// Time Complexity : O(n)
// Space Complexity : O(1) no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;


class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.empty())
            return 0;
        
        vector<vector<int>> dp(nums.size(), vector<int> (2));
        dp[0][1] = nums[0];
        
        for(int i = 1; i < dp.size(); i++){
            dp[i][0] = std::max(dp[i-1][0],dp[i-1][1]);
            
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        
        return std::max(dp[dp.size() - 1][0], dp[dp.size()-1][1]);
    }
};