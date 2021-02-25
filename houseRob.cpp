// Time Complexity: O(N)Where N is no of elements in the array.
// Space Complexity: O(N) where no of elements in the array.
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No




class Solution {
public:
    int rob(vector<int>& nums) {
        vector<int>dp;
        dp.resize(nums.size());
        if(nums.size()==0)return 0;
        if(nums.size()==1)return nums[0];
        dp[0] = nums[0];
        dp[1] = max(nums[0],nums[1]);
        for(int i = 2; i < dp.size();i++){
            dp[i] = max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[nums.size()-1];
        
    }
    
  
};