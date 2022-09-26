class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if not nums:
            return None
        skip,take = 0,nums[0]
        
        for i in range(1,len(nums)):
            temp = take
            take = nums[i] + skip
            
            skip = max(temp,skip)
        return max(skip,take)
        