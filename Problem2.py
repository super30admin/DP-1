## Problem2 (https://leetcode.com/problems/house-robber/)

# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        
        # Guard clause / Edge cases: 
        # If there are 1 or 2 houses, just take the maximum available.
        # This prevents an IndexError when trying to access nums[1] later.
        if n <= 2:
            return max(nums) if nums else 0
            
        # 'previous' tracks the max money we can rob up to two houses ago (i - 2)
        previous = nums[0]
        
        # 'current' tracks the max money we can rob up to the previous house (i - 1)
        current = max(previous, nums[1])
        
        # Iterate starting from the 3rd house (index 2)
        for i in range(2, n):
            # Temporarily store 'current' so we can update 'previous' afterwards
            temp = current
            
            # Core DP Logic: Decide whether to rob or skip the current house.
            # 1. Skip: Keep the max money from the previous house ('temp').
            # 2. Rob: Add this house's value to the max from two houses ago ('previous').
            current = max(temp, nums[i] + previous)
            
            # Shift our two tracking variables forward for the next iteration
            previous = temp
            
        return current