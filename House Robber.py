class Solution:
    def rob(self, nums: List[int]) -> int:
        maxMoney = [0] * len(nums)
        if (len(nums) == 1): return nums[0]
        maxMoney[0] = nums[0]
        maxMoney[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            maxMoney[i] = max(maxMoney[i - 1], nums[i] + maxMoney[i - 2])
        return maxMoney[-1]

