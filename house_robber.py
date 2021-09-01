# time complexity: O(N)
# space complexity: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        memo= [-1 for i in range(n+1)]
        return self.helper(nums, memo, 0)
    
    
    def helper(self, nums, memo, index):
        if index >= len(nums):
            return 0
        if memo[index] != -1:
            return memo[index]
        memo[index] = max(nums[index] + self.helper(nums, memo, index+2), self.helper(nums,memo,index+1))
        return memo[index]