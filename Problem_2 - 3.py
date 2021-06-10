"""

Time Complexity : O(n) where n is number of houses.
Space Complexity : O(1)
    
"""

class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0 
        
        skip = 0
        take = nums[0]
        
        for i in range(1, len(nums)):
            pskip = skip
            ptake = take
            
            skip = max(pskip, ptake)
            take = nums[i] + pskip
        
        return max(skip, take)
        