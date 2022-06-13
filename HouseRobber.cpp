// Time Complexity - O(n)
// Space Complexity - O(n)
// Problems Faced - No!
// It runs on leetcode.

class Solution {
public:
    int rob(vector<int>& nums) {
        int m = nums.size();
        vector<int> dp(m);
        if(m == 1)
            return nums[0];
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        for(int i = 2; i < m; i++){
            dp[i] = max(dp[i-1], nums[i] + dp[i-2]);
        }
        
        return dp[m-1];
    }
};
