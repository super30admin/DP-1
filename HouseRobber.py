# # Using Recursion
# #TC: O(2^n)
# #SC: O(n)
# #It tries every possibility—either robbing the current house (if the previous wasn’t robbed) or skipping it—and returns the maximum sum. It explores all choices but can be slow due to repeated work.
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         return self.helper(nums, 0, False, 0)

#     def helper(self, nums, i, lastHouseChosen, currentSum):
#         # Base case: reached end of houses
#         if i == len(nums):
#             return currentSum 
#         case1Sum = 0
#         # Case 1: choose current house only if last wasn't chosen
#         if not lastHouseChosen:
#             case1Sum = self.helper(nums, i + 1, True, currentSum + nums[i])
#         # Case 2: skip current house
#         case2Sum = self.helper(nums, i + 1, False, currentSum)
#         # Return max amount from both choices
#         return max(case1Sum, case2Sum)


# # Using DP with array
# #TC: O(n)
# #SC: O(n)
# #It builds up the solution from the smallest cases, storing the max money that can be robbed up to each house in an array. This avoids repeated calculations and runs efficiently.
# class Solution:
#     def rob(self, nums):
#         n = len(nums)
#         # dp[i] will hold max money can rob up to house i-2 (shifted by 2)
#         dp = [0] * (n + 2)
#         for i in range(2, n + 2):
#             # max of skipping or robbing current house plus dp two steps behind
#             dp[i] = max(dp[i - 1], nums[i - 2] + dp[i - 2])      
#         return dp[-1]


# Using DP without array (space optimized)
#TC: O(n)
#SC: O(1)
#It uses just two variables to keep track of the best amounts when robbing or skipping houses, saving space while still efficiently finding the max money possible.
class Solution:
    def rob(self, nums):
        chosen = 0      # max money when current house is chosen
        notChosen = 0   # max money when current house is not chosen
        for num in nums:
            temp = chosen
            # If we choose current house, add current money to previous notChosen
            chosen = num + notChosen
            # If we skip current house, max of previous chosen or notChosen
            notChosen = max(temp, notChosen)      
        # Return max of choosing or skipping last house
        return max(chosen, notChosen)
