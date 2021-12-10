# Time Complexity : O(N),
# Space Complexity :O(N), 

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approachclass Solution:


class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums == None and len(nums) == 0:
            return 0
        skip = 0
        take = nums[0]
        for i in range(1,len(nums)):
            temp = skip
            skip = max(take, skip)
            take = temp + nums[i]
        return(max(skip, take))    
        