# TC: O(n)
#SC: O(1)
class Solution:
    def rob(self, nums):
        if not nums:
            return 0

        skip, take = 0, nums[0]
        for i in range(1, len(nums)):
            temp = skip
            skip = max(skip, take)
            take = nums[i] + temp
        
        return max(skip, take)