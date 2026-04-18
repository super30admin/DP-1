## Problem2 (https://leetcode.com/problems/house-robber/)

# Brute Force

'''

class Solution:
    def rob(self, nums: List[int]) -> int:
        return self.getMax(0, nums)

    def getMax(self, index, nums):
        if index >= len(nums):
            return 0
        not_robbed = self.getMax(index + 1, nums)
        robbed = nums[index] + self.getMax(index + 2, nums)
        return max(not_robbed, robbed)

'''

# Memoization (Top Down)
'''
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        memo = [-1] * n
        return self.getMax(0, nums, memo)

    def getMax(self, index, nums, memo):
        if index >= len(nums):
            return 0
        if memo[index] != -1:
            return memo[index]
        not_robbed = self.getMax(index + 1, nums, memo)
        robbed = nums[index] + self.getMax(index + 2, nums, memo)
        memo[index] = max(not_robbed, robbed)
        return memo[index]

'''

# Tabulation (bottom up)

'''
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        memo = [0] * (n + 2)
        for index in range(n - 1, -1, -1):
            not_robbed = memo[index + 1]
            robbed = nums[index] + memo[index + 2]
            memo[index] = max(not_robbed, robbed)
        return memo[0]
'''

# Space Optimised Tabulation

class Solution:
    def rob(self, nums):
        n = len(nums)
        memo_plus_1, memo_plus_2 = 0, 0
        result = 0
        for index in range(n - 1, -1, -1):
            not_robbed = memo_plus_1
            robbed = nums[index] + memo_plus_2
            result = max(not_robbed, robbed)
            memo_plus_2 = memo_plus_1
            memo_plus_1 = result
        return result

nums = [2,7,9,3,1]
sl = Solution()
print(sl.rob(nums))