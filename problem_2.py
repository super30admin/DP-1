# without mutating matrix and in constant space
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def rob(self, houses):
        temp0 = houses[0]
        temp1 = max(houses[0], houses[1])
        for i in range(2, len(houses)):
            temp0, temp1 = temp1, max(temp1, houses[i] + temp0)
        return temp1


check = Solution()
print(check.rob([6, 9, 8, 1, 1, 5]))


# without mutating matrix
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# class Solution:
#     def rob(self, houses):
#         dp = houses
#         for i in range(len(dp)):
#             if i == 1:
#                 dp[i] = max(dp[i], dp[i-1])
#             elif i > 1:
#                 dp[i] = max(dp[i-1], dp[i]+dp[i-2])
#         return dp[-1]
#
#
# check = Solution()
# print(check.rob([1, 7, 1, 1, 7]))


# # Time Complexity : O(n)
# # Space Complexity : O(1)
# # Did this code successfully run on Leetcode : Yes
# # Any problem you faced while coding this : No
# #
# #
# # Mutating the array.
# class Solution:
#     def rob(self, houses):
#         for i in range(len(houses)):
#             if i == 1:
#                 houses[i] = max(houses[i], houses[i-1])
#             elif i > 1:
#                 houses[i] = max(houses[i-1], houses[i]+houses[i-2])
#         return houses[-1]
#
#
# check = Solution()
# print(check.rob([2, 1]))


# Recursive Approach - Time Limit exceeded.
# class Solution:
#     def helper(self, houses, index, amount):
#         if index > len(houses) - 1:
#             return amount
#         case1 = self.helper(houses, index+1, amount)
#         case2 = self.helper(houses, index+2, amount+houses[index])
#         return max(case1, case2)
#
#     def rob(self, houses):
#         return self.helper(houses, 0, 0)
#
#
# check = Solution()
# print(check.rob([2]))


# Method -2
# # Time Complexity : O(n)
# # Space Complexity : O(1)
# # Did this code successfully run on Leetcode : Yes
# # Any problem you faced while coding this : No
# #
# #
#
# class Solution:
#     def rob(self, houses):
#         if len(houses) == 1:
#             return houses[0]
#         for i in range(len(houses)-1, -1, -1):
#             if i == len(houses) - 3:
#                 houses[i] = houses[i] + houses[len(houses)-1]
#             elif i < len(houses) - 3:
#                 houses[i] += max(houses[i+2], houses[i+3])
#         return max(houses[0], houses[1])
#
#
# check = Solution()
# print(check.rob([2]))


# class Solution:
#     def helper(self, houses, index, amount):
#         if index > len(houses) - 1:
#             return amount
#         case1 = self.helper(houses, index + 2, amount + houses[index])
#         case2 = self.helper(houses, index + 3, amount + houses[index])
#         return max(case1, case2)
#
#     def rob(self, houses):
#         case1 = self.helper(houses, 0, 0)
#         case2 = self.helper(houses, 1, 0)
#         return max(case1, case2)
#
#
# check = Solution()
# print(check.rob([1, 7, 1, 1, 7]))
