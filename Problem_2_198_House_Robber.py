class Solution:
    def rob(self, nums: List[int]) -> int:

        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])

        dp_1 = [0 for i in range(len(nums))]
        dp_1[0] = nums[0]
        dp_1[1] = nums[0]

        for i in range(2, len(nums)):
            dp_1[i] = max(dp_1[i - 1], dp_1[i - 2] + nums[i])

        dp_2 = [0 for i in range(len(nums))]
        dp_2[0] = 0
        dp_2[1] = nums[1]
        dp_2[2] = nums[1]

        for i in range(3, len(nums)):
            dp_2[i] = max(dp_2[i - 1], dp_2[i - 2] + nums[i])

        ans = max(max(dp_1), max(dp_2))
        return ans

