class Solution:
    def rob(self, nums) -> int:
        if not nums:
            return 0

        skip, take = 0, nums[0]
        for i in range(1, len(nums)):
            temp = skip
            skip = max(skip, take)
            take = nums[i] + temp
        
        return max(skip, take)