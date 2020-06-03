class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:return 0
        if len(nums) == 1:return nums[0]
        memo = [0 for i in range(len(nums)+1)]
        memo[0] = 0
        memo[1] = nums[0]
        for i in range(1, len(nums)):
            memo[i+1] = max(memo[i], nums[i] + memo[i-1])
        return memo[len(nums)]