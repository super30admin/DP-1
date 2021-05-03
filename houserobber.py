"""House Robber1 
Time Complexity: O(N) and Space Complexity: O(1)"""

class Solution:
    def rob(self, nums: List[int]) -> int:
        if(nums ==None and len(nums)==0):
            return 0
        skip =0
        take = nums[0]
        
        for i in range(1,len(nums)):
            temp = skip
            skip = max(skip,take)
            take = nums[i]+temp
        return max(skip,take)