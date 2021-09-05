class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0

        skip, take = 0, nums[0]

        for i in (range(1, len(nums))):
            temp = skip

            skip = max(skip, take)

            take = temp + nums[i]

        return max(skip,take)


obj = Solution()
o