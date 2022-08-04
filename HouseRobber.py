#198. House Robber
"""
Time Complexity : O(n)
Space Complexity : O(n) #dp array
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return nums[0]
        
        n = len(nums) #rows and columns
        dp = [0] * n
        ans = 0 
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        
        for i in range(2, len(dp)):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])
            """
            if we choose current house, then add current money + money 
            of i-=2 house. because we cannot select immediate previous house.
            If we are not choosing current house, then we can select immediate
            previous house
            """
            
        return dp[-1]
