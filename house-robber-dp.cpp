// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size() < 2) return nums[0];

        // vector<int> dp(nums.size());
        // dp[0] = nums[0];
        // dp[1] = max(dp[0], nums[1]);
        // for(int i = 2; i < nums.size(); i++){
        //     dp[i] = max(dp[i - 1], (nums[i] + dp[i - 2]));
        // }
        // return dp[nums.size() - 1];
        int prev = nums[0];
        int curr = max(prev, nums[1]);
        for(int i = 2; i < nums.size(); i++){
            int temp = curr;
            curr = max(curr, nums[i] + prev);
            prev = temp;
        }
        return curr;
    }
};