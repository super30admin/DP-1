# Time Complexity :- O(n**2)
# Space complexity :- O(1)

# Ran on Leetcode :- TLE
# Couldn't figure out the recrursive solution

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        return self.helper(nums,0)
    
    def helper(self, nums, currentIndex):
        
        if currentIndex >= len(nums):
            return 0
        
        first = nums[currentIndex] + self.helper(nums, currentIndex+2)
        second = self.helper(nums, currentIndex + 1)
        
        return max(first,second)