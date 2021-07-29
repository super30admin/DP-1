// Time Complexity : O(Coins_Size * Amount)
// Space Complexity : O(Amount + 1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/coin-change/
// Submission Link: https://leetcode.com/submissions/detail/530256203/

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