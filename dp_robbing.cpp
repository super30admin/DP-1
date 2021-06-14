//This code is DP approach

//Time complexity : O(n)
//Space complexity : O(1)

class Solution {
public:
    int rob(vector<int>& nums) {
        
        
        
        vector<vector<int>> dp(nums.size(), vector<int>(2));
        
        dp[0][1]=nums[0];
        for(int i=1; i<nums.size(); i++)
        {
            //case 0
            dp[i][0]= std::max(dp[i-1][0], dp[i-1][1]);
            //case1
            dp[i][1]= dp[i-1][0]+nums[i];
        }
        return max(dp[dp.size()-1][0], dp[dp.size()-1][1]);
    }
    
    
};
