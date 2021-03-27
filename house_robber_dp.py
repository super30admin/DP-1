# Time Complexity : Add - O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. I have used a Table Approach as described in the lecture.
2. At any point, we have two decision to make. either we select the house or we don't
3. If we don't select the house amount remains same, If we select the house, then house at that would impley that
the house at i-1 was not selected, but priabbaly house at i-2 was selected.

'''

class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums == [] or len(nums) < 1:
            return 0
        
        rows = len(nums) + 2
        
        dp = [0]*rows           
        for i in range(2, rows):
        	#1st case handls when we don't select the ith house, so we just look at the cumulative amount from i-1
        	#2nd case handels when we select the ith house, and thus going back to i-2 to check total possible earning
        	#Then we take its max
            dp[i] = max(dp[i-1], nums[i-2] + dp[i-2])
            
        
        return dp[-1]
            