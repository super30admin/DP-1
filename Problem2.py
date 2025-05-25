"""   
Time Complexity: O(n)   
Space Complexity: O(n)  for the DP array 

Approach:
    1. Top Down Recursion: 
       Using recursion to explore all possible ways to rob houses, starting from the first house. Use a memoization array (dp) to store results of subproblems to avoid redundant calculations
      
    2. Bottom Up Tabulation: 
       Use an iterative approach to build the solution from smaller subproblems to larger ones, avoiding recursion.
"""

# Top Down Recursion

class Solution:
    def rob(self, nums: List[int]) -> int:

        dp = [-1 for i in range(len(nums) + 1)]

        def solve(index):
            if index >= len(nums):
                return 0

            if dp[index] != -1:
                return dp[index]

            dp[index] = max(nums[index] + solve(index + 2), solve(index + 1))
            return dp[index]

        return solve(0)

# Bottom Up Tabulation 

class Solution:
    def rob(self, nums: List[int]) -> int:

        if len(nums) == 1:
            return nums[0]

        dp = [-1 for i in range(len(nums) + 1)]
        dp[0] = nums[0]
        dp[1] = max(dp[0], nums[1])

        for i in range(2, len(nums)):
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])

        return dp[len(nums)-1]


#TODO: Using two variables Approach 

