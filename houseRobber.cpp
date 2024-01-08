// Time Complexity :O(n) n is length of nums
// Space Complexity :O(n) n is length of nums
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int rob(vector<int>& nums) {
        vector<int> dp (nums.size()+1,0);
        dp[1]=nums[0];
        for(int i = 2;i<dp.size();i++)
        {
            dp[i]= max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[dp.size()-1];
    }
};