# Time Complexity : O(n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : not with the programming logic but i am trying to practice with python as well so with in python was not smooth

"""
We are using the tabulation approach where we are keeping track of previous nums and based on that what will be the total count that 
be possible if we rob the current houe or not
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        
        
        index = len(nums)
        dp = [0 for _ in range(index)]
        dp[0] = nums[0]
        dp[1] = max(dp[0],nums[1])
        for i in range(2,index):
            dp[i] = max(dp[i-1],(nums[i]+dp[i-2]))
        print(dp)
        
        return dp[index-1]