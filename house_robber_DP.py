# House robber DP problem Leetcode 198
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        '''
        1. Solution 1 using DP array
        TC: O(N)
        SC: O(N) -> this is the down side , extra space for the array
        
        if not nums:
            return 0

        if len(nums) <= 2:
            return max(nums)

        dp = [0] * len(nums)
        # In the beginning we will always go to first house to rob
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for r in range(2, len(nums)):
            dp[r] = max(dp[r-1], nums[r] + dp[r-2])
        # return the last element of the DP array as it holds the max sum or cumulative sum.
        return dp[-1]
        '''
        # Solution 2 using variables to store cumulative sum
        
        prev = 0
        curr = 0
        for num in nums:
            temp = prev
            prev = curr
            curr = max(num+temp, prev)
        return curr
    
       # TC: O(N)
       # SC:O(1) -> because we are not using any array to store the values
    

