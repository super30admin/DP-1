"""
Time Complexity: 2^n (Exponential)  where n is number of houses
Space Complexity: O(n) where n is number of houses

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:

1. Greedy approach: 
Greedy approach does not work for the follwoing example: [2,8,9,2,1,7]
So selecting the maximum 9 we have to select 2,9,1 -> Total Earnings = 12
Ideal Solution: 8,2,7 -> Total Earnings: 17

2. From the Greedy approach we can conclude that all the possibilities should check before coming to any conclusion.
But the Exhaustive approach's Time complexity is exponentioal 2^n hence we can use DP
"""
class Solution:
    def helper(self, nums, idx, amountRobbed):
        #base case
        if idx >= len(nums):
            return amountRobbed
        
        #Logic:
        #Chosen
        case1 = self.helper(nums, idx+2, amountRobbed+nums[idx])
        
        #Not Chosen
        case0 = self.helper(nums, idx+1, amountRobbed)
        
        return max(case1, case0)
    
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        return self.helper(nums, 0, 0)