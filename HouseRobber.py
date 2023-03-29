#Time and : O(n)
# Space Complexity: O(1)

class Solution:
    def rob(self, nums: List[int]) -> int:
        # Use SKIP and TAKE

        if nums == None or len(nums) == 0:
            return 0
        n = len(nums)
        skip = 0
        take = nums[0]
        for i in range(1,n):
            temp = skip
            skip = max(skip,take)
            take = temp + nums[i]
        return max(skip, take)