// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.empty() || nums.size() == 0){
            return 0;
        }
        vector<vector<int>> dp;
        dp.resize(nums.size(), vector<int> (2));
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1; i<nums.size(); i++){
            dp[i][0] = max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return max(dp[dp.size() - 1][0], dp[dp.size() - 1][1]);
    }
   
};
