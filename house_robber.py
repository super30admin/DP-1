# Time Complexity: o(n)
# Space Complexity: o(n)

class Solution:
    def rob(self, nums: List[int]) -> int:
        skip = 0
        one = nums[0]
        for i in range(1,len(nums)):
            skip,one = max(skip,one),skip+nums[i]
            
        return max(skip,one)