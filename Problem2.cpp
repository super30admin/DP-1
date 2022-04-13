//Time complexity : o(n);
// space :  o(n);
class Solution {
public:
    int rob(vector<int>& nums) {
       
        return helper(nums);
    }
    
    int helper(vector<int>&nums) {
        
        int n = nums.size();
        int dp[nums.size()][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        
        for(int j=1;j<nums.size();j++) {
            
            dp[j][0] = max(dp[j-1][0],dp[j-1][1]);
            
            dp[j][1] = dp[j-1][0] + nums[j];
        }
        return max(dp[n-1][0],dp[n-1][1]);
    }
};