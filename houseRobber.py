# Time Complexity :- O(n**2)
# Space complexity :- O(1)

# Ran on Leetcode :- Yes
# Couldn't figure out the recrursive solution

class Solution:


    def rob(self, nums: List[int]) -> int:
        
        self.dp = {}
        return self.helper(nums,0)
    
    def helper(self, nums, currentIndex):
        
        if currentIndex >= len(nums):
            return 0

        if currentIndex in self.dp:
            return self.dp[currentIndex]
        
        first = nums[currentIndex] + self.helper(nums, currentIndex+2)
        second = self.helper(nums, currentIndex + 1)
        
        self.dp[currentIndex] =  max(first,second)
        return self.dp[currentIndex]