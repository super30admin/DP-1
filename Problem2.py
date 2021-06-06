# House Robber Problem

#   Time Complexity : 2^ (m+n)
#   Space Complexity : O(1)
#   Did this code successfully run on Leetcode : No, time limit exceeded
#   Any problem you faced while coding this : No

# Approach 1: Recursion - Time Limit Exceeded

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        return self.helper(nums, 0, 0)
    
    def helper(self, nums: List[int], index:int, robbings:int):
        
        #base case
        
        if index == len(nums) or index > len(nums):
            return robbings
        # logic
        
        # to choose a house
        case1 = self.helper(nums, index+2, robbings+nums[index])
        
        # to not choose a house
        case2 = self.helper(nums, index+1, robbings)
        
        return max(case1, case2)

# Approach 2: Dynamic Programming

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if nums == None or len(nums) == 0:
            return 0
        
        m = len(nums) + 1  # rows/ houses
        n = 2 # columns/ diff decisions
        dp = [[0 for x in range(n)] for y in range(m)]
        
        # fill the first row/ dummy row with 0s 
        for j in range(0,n):
            dp[0][j] = 0
            
        for i in range(1,m):
            for j in range(0,n):
                
                # zero case/ do not choose the house
                if j == 0:
                    dp[i][j] = max(dp[i-1][j], dp[i-1][j+1])
                    
                # one case/ choose the house
                else:
                    dp[i][j] = dp[i-1][j-1] + nums[i-1]
        
        return max(dp[m-1][0], dp[m-1][1])