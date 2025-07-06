'''
198. House Robber
'''

# Time Complexity : 
# Space Complexity : 
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this :

class Solution:
    def rob(self, nums: List[int]) -> int:
        # Using Recursion
        # def rob_helper(i): # we define a helper function to handle the recursion
        #     if i < 0: # base case, if index is negative, return 0
        #         return 0 # no house to rob
        #     if i == 0: # if we are at the first house, return its value
        #         return nums[0] # rob the first house
        #     # we can either rob the current house and skip the previous one, or skip the current house
        #     # and take the maximum of the two options
        #     return max(rob_helper(i - 1), nums[i] + rob_helper(i - 2))
        # return rob_helper(len(nums) - 1) # call the helper function with the last index

        # Using Dynamic Programming
        if not nums: # if the list is empty, return 0
            return 0 # no house to rob
        n = len(nums) # get the number of houses
        if n == 1: # if there is only one house, return its value
            return nums[0] # rob the only house
        dp = [0] * n # create a dp array to store the maximum amount we can rob up to each house
        dp[0] = nums[0] # we can only rob the first house
        dp[1] = max(nums[0], nums[1]) # we can either rob the first house or the second house, whichever is greater
        for i in range(2, n): # iterate through the houses starting from the third one
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2]) # we can either skip the current house or rob it and add the maximum from two houses before it
        return dp[-1] # return the maximum amount we can rob from all houses

# Visualizng the DP array:
# dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])
# dp[0] = nums[0]
# dp[1] = max(nums[0], nums[1])
# dp[2] = max(dp[1], nums[2] + dp[0])
# dp[3] = max(dp[2], nums[3] + dp[1])
# dp[4] = max(dp[3], nums[4] + dp[2])
# ...
# The dp array stores the maximum amount we can rob up to each house, where dp[i] is the maximum amount we can rob from the first i houses.
# The final answer is stored in dp[-1], which is the maximum amount we can rob from all houses.

# Visualizing using a dry run:
# nums = [1, 2, 3, 1]
# dp = [1, 2, 4, 4]
# Explanation:
# - For the first house (1), we can only rob it, so dp[0] = 1.
# - For the second house (2), we can either rob the first house (1) or the second house (2), so dp[1] = max(1, 2) = 2.
# - For the third house (3), we can either skip the second house (2) and rob the first house (1) + current house (3), or rob the second house (2) and skip the first house, so dp[2] = max(2, 1 + 3) = 4.
# - For the fourth house (1), we can either skip the third house (4) and rob the second house (2) + current house (1), or rob the third house (4) and skip the second house, so dp[3] = max(4, 2 + 1) = 4.
# # The final answer is dp[-1] = 4, which is the maximum amount we can rob from all houses.

# Visualizing the dp table:
# | House | Robbed | Not Robbed | Max Amount |
# |-------|--------|------------|------------|
# | 0     | 1      | 0          | 1          |
# | 1     | 2      | 1          | 2          |
# | 2     | 4      | 2          | 4          |
# | 3     | 4      | 4          | 4          |  
# # The dp table shows the maximum amount we can rob from each house, either by robbing it or not robbing it. The final answer is the maximum amount we can rob from all houses, which is stored in the last column of the table.      
