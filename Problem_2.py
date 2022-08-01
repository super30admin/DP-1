"""
Time Complexity : Inside function
Space Complexity : Inside function
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes


Your code here along with comments explaining your approach

Problem_1:  House Robber, Given an integer array nums representing the amount of money of each house,
            return the maximum amount of money you can rob tonight without alerting the police..
"""

# Approach - 1

class Solution:
    def rob(self, nums: List[int]) -> int:
        """
        Taking every scenario into account using recursion
        Time complexity :O( 2^n), n is number of house
        space complexity: O(n)
        """
        if len(nums) == 0: return 0
        
        return self.helper(nums, 0, 0)
        
    def helper(self, nums, index, amount):
        #base case
        if len(nums) <= index: return amount
        
        #logic
        #choose
        case_1 = self.helper(nums, index + 2, amount + nums[index])
        case_2 = self.helper(nums, index + 1, amount)
        
        return max(case_1, case_2)

# Approach - 2

class Solution:
    def rob(self, nums: List[int]) -> int:
        """
        using bootom up dynamic prog by taking array of cost of house
        Time complexity : O(n)
        space complexity : O(n)
        """
        if len(nums) == 0: return 0
        n = len(nums)
        if n == 1: return nums[0]
        dp = [0 for _ in range(n)]
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            dp[i] = max(dp[i-1], nums[i] + dp[i - 2])
            
            
        return dp[n-1]

# Approach - 3

class Solution:
    def rob(self, nums: List[int]) -> int:
        """
        Using the same approach with redusing space comp.
        Time complexity : O(n)
        space complexity : O(1)
        """
        if len(nums) == 0: return 0
        n = len(nums)
        if n == 1: return nums[0]
        
        prev = nums[0]
        curr = max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            temp = curr
            curr= max(curr, nums[i] +prev)
            prev = temp
            
            
        return curr