"""
// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



## Problem2 (https://leetcode.com/problems/house-robber/)
"""

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # If there are no houses, there's nothing to rob
        if not nums:
            return 0
        
        # If there's only one house, rob it
        if len(nums) == 1:
            return nums[0]
        
        # If there are two houses, rob the richer one
        if len(nums) == 2:
            return max(nums[0], nums[1])
        
        # Initialize two variables to track the max loot
        prev2 = nums[0]               # Loot till house i-2
        prev1 = max(nums[0], nums[1]) # Loot till house i-1
        
        # Start from the 3rd house (index 2) and calculate maximum loot
        for i in range(2, len(nums)):
            # Either skip current house or rob it and add to loot till i-2
            current = max(prev1, prev2 + nums[i])
            # Update the variables for the next iteration
            prev2 = prev1
            prev1 = current
        
        # The final answer is the max loot till the last house
        return prev1
