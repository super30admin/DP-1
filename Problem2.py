# https://leetcode.com/problems/house-robber/description/

# Exhaustive approach
# TC: O(2^n)
# SC: O(n)

class Solution:
    highest = 0
    def rob(self, nums: List[int]) -> int:
        self.helper(nums, 0, 0)
        return self.highest

    def helper(self, nums, i, robbings):

        if i >= len(nums):
            self.highest = max(self.highest, robbings)
            return 

        # case 0
        self.helper(nums, i+1, robbings)

        # case 1
        self.helper(nums, i+2, robbings + nums[i])

# int based recursion

class Solution:
    highest = 0
    def rob(self, nums: List[int]) -> int:
        return self.helper(nums, 0, 0)

    def helper(self, nums, i, robbings):

        if i >= len(nums):
            return robbings

        # case 0
        case0 = self.helper(nums, i+1, robbings)

        # case 1
        case1 = self.helper(nums, i+2, robbings + nums[i])

        return max(case0, case1)
    
# DP solution
# TC: O(n)
# SC: O(n)

class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        dp = [0] * n

        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, n):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])

        return dp[n-1]
    
# Using curr and prev

class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]

        prev = nums[0]
        curr = max(nums[0], nums[1])

        for i in range(2, n):
            temp = curr
            curr = max(curr, nums[i] + prev)
            prev = temp

        return curr