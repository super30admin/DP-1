# TC: O(n)
# SC: O(1)

class Solution:
    def rob(self, nums: List[int]):
        skip = 0
        take = 0
        temp = 0

        for i in range(len(nums)):
            temp = skip
            skip = max(skip, take)
            take = temp + nums[i]

        return max(skip, take)
