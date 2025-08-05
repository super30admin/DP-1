#Time Complexity : O(n)
#Space Complexity : O(n)
#Any problem you faced while coding this : none

#Your code here along with comments explaining your approach
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        no_of_houses=len(nums)
        dp = [0] * no_of_houses
        if no_of_houses==1: # base case when only one house to rob
            return nums[0]
        dp[0] = nums[0]     # if only one house then rob that house
        dp[1] = max(nums[0], nums[1]) # if 2 house then choose the max of two
        for i in range(2, no_of_houses):
            dp[i] = max(dp[i-1], nums[i] + dp[i-2]) # choose the max based on one is choosing to rob the house or not 
        
        return dp[no_of_houses-1]                  # the last value gives the max