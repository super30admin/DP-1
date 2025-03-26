from typing import List
# Approach: Dynamic Programming
# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I didn't face any problem while coding this.

# Approach:
# 1. We will use a dp array to store the maximum amount of money that can be robbed from the houses.
# 2. At each house, we have 2 choices: either rob the house or don't rob the house.
# 3. If we rob the house, we can't rob the previous house. So, we will add the amount of money in the current house to the amount of money robbed from the house 2 steps back.
# 4. If we don't rob the house, we have the amount of money robbed from the previous house.
# 5. We will take the maximum of the 2 choices and store it in the dp array.
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        # path array to store the path of houses that are robbed
        path = [False] * n
        res = []
        # Initialize the dp array with 0s
        dp = [0] * n
        if n == 1:
            return nums[0]
        # Initialize first 2 elements of the dp array with the maximum amount of money that can be robbed from the first 2 houses.
        dp[0] = nums[0]
        path[0] = True
        dp[1] = max(nums[0], nums[1])
        if dp[1] < dp[0]: path[1] = True

        for i in range(2, len(dp)):
            if dp[i-1] < nums[i] + dp[i-2]:
                path[i] = True
            # at each house, we have 2 choices: either rob the house or don't rob the house
            dp[i] = max(dp[i-1], nums[i] + dp[i-2])
        # Printing the path
        i = len(path) - 1    
        while i >= 0:
            if path[i] == True:
                res.append(i)
                i -= 2
            else:
                i -= 1
        # return the maximum amount of money that can be robbed from the houses
        return dp[-1]

# Approach: Space optimized Dynamic Programming  
# Time Complexity: O(n)
# Space Complexity: O(1)
# 1. We will use 2 variables to store the maximum amount of money that can be robbed from the houses.
# 2. Before updating the current house, we will store the previous house's amount in a temporary variable.
# 3. We will update the current house with the maximum of the previous house and the amount of money in the current house.
# 4. We will update the previous house with the temporary variable.
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        prev = nums[0]
        curr = max(nums[0], nums[1])

        for i in range(2, n):
            tmp = curr
            curr = max(tmp, prev + nums[i])
            prev = tmp

        return curr
    
# Approach: Recursive approach
# Time Complexity: O(2^n)
# Space Complexity: O(n) (recursion stack)
# Did this code successfully run on Leetcode : No (Time Limit Exceeded)
# Any problem you faced while coding this : I didn't face any problem while coding this.
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        def dfs(i, robbings):
            # base case
            if i >= len(nums):
                return robbings
            # at each house, we have 2 choices: either rob the house or don't rob the house
            # if we don't rob the house, we can rob the next house
            no_choose = dfs(i + 1, robbings)
            # if we rob the house, we can't rob the next house
            choose = dfs(i + 2, robbings + nums[i])
            # return the maximum of the 2 choices
            return max(choose, no_choose)
        
        return dfs(0, 0)