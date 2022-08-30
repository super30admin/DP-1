## Problem2 (https://leetcode.com/problems/house-robber/)

#Solution -> 

class Solution:
    def rob(self, nums: List[int]) -> int:
        rob1, rob2 = 0, 0
        for n in nums:
            temp = max(n+rob1, rob2)
            rob1=rob2
            rob2=temp
        return rob2
    
# Time Complexity -> o(n)
# Space Complexity -> o(1)