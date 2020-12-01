/*
# Recursive
class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        
        def helper(nums, index, max_cost):
            if index >= len(nums):
                return max_cost
            
            case1 = helper(nums, index+2, max_cost+nums[index])
            case2 = helper(nums, index+1, max_cost)
            
            return max(case1, case2)
        
        return helper(nums, 0, 0)
        
# DP
class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        
        skip = 0
        take = nums[0]
        
        for i in range(1, len(nums)):
            temp = max(skip, take)
            take = skip + nums[i]
            skip = temp
            
        return max(skip, take)

*/

// Time Complexity : O(n) where n is size of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Took two variables skip and take where take would be skip+current_value
// and skip would be whatever is max till last step

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int skip = 0, take = nums[0];
        for (int i=1; i<nums.length; i++){
            int temp = Math.max(skip, take);
            take = skip + nums[i];
            skip = temp;
        }
        return Math.max(skip, take);
    }
}