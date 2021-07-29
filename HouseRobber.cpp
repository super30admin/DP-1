// Time Complexity : O(N) where N is size of array
// Space Complexity : O(1) as I am just using extra variables
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/house-robber/
// Submission Link: https://leetcode.com/submissions/detail/530194883/

class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size() == 1)
            return nums[0];
        
        if(nums.size() == 2)
            return max(nums[0], nums[1]);
        
        int prev2 = nums[0], prev1 = max(nums[0], nums[1]);
        int max_val = 0;
        
        for(int i = 2; i < nums.size(); i++){
            max_val = max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = max_val;
        }
        
        return prev1;
    }
};