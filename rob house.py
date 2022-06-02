class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        maxMoney = [0] * len(nums)  # maximum amount of money at each index
        maxMoney[0] = nums[0]
        maxMoney[1] = max(nums[0], nums[1])
        for i in range(2, len(maxMoney)):
            maxMoney[i] = max(nums[i] + maxMoney[i - 2],
                              maxMoney[i - 1])  # either current house+prev 2 house 0r prev house
        return maxMoney[len(nums) - 1]
