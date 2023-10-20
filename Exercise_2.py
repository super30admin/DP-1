# ## Problem2 (https://leetcode.com/problems/house-robber/)

# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

class Solution:
    def rob(self, nums):
        if len(nums) < 2:
            return nums[0]
        prev = nums[0]
        curr = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            temp = curr
            curr = max(curr, nums[i] + prev)
            prev = temp
        return curr


# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

# class Solution:
#     def rob(self, nums):
#         # if empty
#         n = len(nums)
#         if n < 2:
#             return nums[0]
#         # initializing dp array
#         dp = [-1] * n
#         # add 0th element of nums to dp
#         dp[0] = nums[0]
#         # add 1st element of nums to dp
#         dp[1] = max(nums[0], nums[1])
#         for i in range(2, n):
#             dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])
#         return dp[n - 1]


# // Time Complexity :O(2^n) --> exponential
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : Time Limit Exceeded


# // Your code here along with comments explaining your approach

# class Solution:
#     def rob(self, nums):
#         # if empty array
#         if len(nums) == 0:
#             return nums
#         # calling helper function for recursion
#         self.helper(nums, 0, 0)

#     def helper(self, nums, i, amount):
#         # base
#         if i >= len(nums):
#             return amount
#         # logic
#         # case0 not choose
#         case0 = self.helper(nums, i + 1, amount)
#         # case1 choose
#         case1 = self.helper(nums, i, amount + nums[i])

#         return max(case0, case1)


nums = [1, 2, 3, 1]
sol = Solution()
print(sol.rob(nums))


class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 2:
            return nums[0]
        prev = nums[0]
        curr = max(nums[0], nums[1])
        for i in range(2, n):
            temp = curr
            curr = max(curr, nums[i] + prev)
            prev = temp
        return curr

        # n = len(nums)
        # if n < 2:
        #     return nums[0]
        # dp = [-1] * n
        # dp[0] = nums[0]
        # dp[1] = max(nums[0], nums[1])
        # for i in range(2, n):
        #     dp[i] = max(dp[i-1], nums[i] + dp[i - 2])
        # return dp[n - 1]
    #     if len(nums) == 0:
    #         return -1
    #     return self.helper(nums, 0, 0)

    # def helper(self, nums, i, amount):
    #     # base
    #     if i >= len(nums):
    #         return amount

    #     # logic
    #     # case 0 not choose
    #     case0 = self.helper(nums, i + 1, amount)
    #     # case 1
    #     case1 = self.helper(nums, i + 2, amount + nums[i])

    #     return max(case0, case1)
