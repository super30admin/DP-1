# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#

class Solution:
    def rob(self, houses):
        if len(houses) == 1:
            return houses[0]
        for i in range(len(houses)-1, -1, -1):
            if i == len(houses) - 3:
                houses[i] = houses[i] + houses[len(houses)-1]
            elif i < len(houses) - 3:
                houses[i] += max(houses[i+2], houses[i+3])
        return max(houses[0], houses[1])


check = Solution()
print(check.rob([2]))


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
