class Solution:
    def rob(self, nums):
        n = len(nums)
        if n == 1:
            return nums[0]
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        prev2 = 0
        prev1 = 0

        for money in nums:
            curr = max(prev1, prev2 + money)
            prev2 = prev1
            prev1 = curr

        return prev1

    # TC O(n)
    # SC O(1) # if you use DP it's O(n) This is space optimized pointers version