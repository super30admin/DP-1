class Solution:
    # Time Complexity :O(n)
    # Space Complexity :O(n)
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        n = len(nums)
        if n == 1:
            return nums[0]
        dp = [[0] * 2 for _ in range(n)]
        dp[0][0] = nums[0]
        dp[1][0] = max(nums[0], nums[1])
        for i in range(2, n):
            dp[i][0] = max(dp[i - 2][0] + nums[i], dp[i - 1][0])
            dp[i][1] = max(dp[i - 1][0], dp[i - 1][1])
        return max(dp[-1][0], dp[-1][1])
