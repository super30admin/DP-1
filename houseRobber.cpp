// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
public:
    int rob(vector<int>& nums) {
        vector<int> dp(nums.size(), 0);

        if(nums.size() == 1) return nums[0];

        if(nums.size() == 2) {
            if(nums[0] >= nums[1]) return nums[0];
            return nums[1];
        }

        dp[0] = nums[0];
        dp[1] = max(nums[1], nums[0]);

        for(int i = 2; i < nums.size(); i++) {
            dp[i] = max(nums[i] + dp[i-2], dp[i-1]);
        }

        for(int i = 0; i < dp.size(); i++) {
            cout << dp[i] << endl; 
        }

        return dp[nums.size()-1];
        
    }
};