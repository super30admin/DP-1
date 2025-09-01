// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We initialize a 1D DP array to track maximum loot at any given house
// If we pick a house to rob, we add the loot @ that house and the max loot possible at the house 2 steps before this house
// If we choose not to rob a house, we copy over the loot @ the previous house, the value at the last index is the max loot possible considering all houses from [0, n).
// Can be optimized to O(1) space by keeping track of the loot @ the previous house and at the house 2 steps before.

class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size() == 1) return nums[0]; // only one house available to rob
        vector<int> dp(nums.size(), -1);

        dp[0] = nums[0]; // max possible loot at house 0
        dp[1] = max(nums[0], nums[1]); // max possible loot at house 1

        for(int i = 2; i<nums.size(); i++) {
            dp[i] = max(nums[i] + dp[i-2], dp[i-1]); // max(pick, no pick)
        }
        
        return dp[nums.size() - 1];
    }
};