# Recursive solution

# Doesn't run on Leetcode
    # Runtime - O(2^n) - n is length of nums
    # Memory - O(n) - considering the recursive stack
    
    
class Solution:
    def rob(self, nums: List[int]) -> int:
        return self.recursion(nums,0,0)
    
    def recursion(self,nums,index,amount):
        if index >= len(nums):
            return amount
        
        not_chosen = self.recursion(nums,index+1,amount)
        chosen = self.recursion(nums,index+2,amount+nums[index])
        
        return max(chosen, not_chosen)
        
   
# DP solution

# Runs on Leetcode
    # Runtime - O(n) - where n is length of nums
    # Memory - O(m*n) - m is length of nums, n is 2 since it's either choose ro not choose

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        dp = [[None for i in range(2)] for j in range(len(nums))]
        
        rows = len(dp)
        cols = len(dp[0])
        
        dp[0][0] = 0
        dp[0][1] = nums[0]
        
        for i in range(1,rows):
            for j in range(cols):
                if j == 0:
                    dp[i][j] = max(dp[i-1][j+1],dp[i-1][j])
                else:
                    dp[i][j] = dp[i-1][j-1] + nums[i]
        
        return max(dp[rows-1][0],dp[rows-1][1])
