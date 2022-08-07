# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) <= 2:
            return max(nums)
           
        n = len(nums)
        dp = nums
        dp[0] = nums[0] 
        dp[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            dp[i] = max(dp[i-1], nums[i]+ dp[i-2])

        return dp[n-1]



# Recursive approach
# Any problem you faced while coding this : Run time Exceeded

class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums == 0 and len(nums) == 0:
            return 0
        return self.helper(nums, 0, 0)
    
    def helper(self, nums: List[int], i, amount):

        # base
        if i >= len(nums):
            return amount
        
# logic
# case 1 and case 2
        case1 = self.helper(nums, i + 2, amount + nums[i])
        case2 = self.helper(nums, i+1, amount)
        return max(case1, case2)
    
    
    
