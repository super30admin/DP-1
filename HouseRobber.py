# TC: O(n)
# SC: O(1)
# LeetCode: Y(https://leetcode.com/problems/house-robber)
# Approach: The brute force way has repeating sub-problems. Since this is an optimization problem, use dynamic programming
#           Remember the max of value added by robbing a house and skipping a house
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if not nums or not len(nums):
            return 0
        
        # Skip first house
        skip = 0 
        # Rob first house
        rob = nums[0]
        
        # Decide for the houses from 1st to end
        for current_house in range(1, len(nums)):
            # get max of whether previous house needs to be skipped or robbed
            temp = max(skip, rob)
            # update rob i.r. skip previous house and rob current house
            rob = skip + nums[current_house]
            # skip the current house and remember the max from previous choices
            skip = temp
            
        # return the max of skip and rob
        return max(skip, rob)
