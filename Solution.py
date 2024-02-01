class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        n = len(coins) + 1
        m = amount + 1
        dp = [[float("inf")] * m for _ in range(n)]
        dp[0][0] = 0
        for i in range(1, n):
            for j in range(m):
                if j == 0:
                    dp[i][j] = 0
                    continue
                if j >= coins[i-1]:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])
                else:
                    dp[i][j] = dp[i-1][j]
        if dp[n-1][m-1] == float("inf"):
            return -1
        return dp[n-1][m-1]

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        f(i) = max(f(i-2)+i, f(i-1))
        """
        n = len(nums) + 1
        dp = [0] * n
        dp[0] = 0
        dp[1] = nums[0]
        for i in range(2, n):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i-1])
        return dp[-1]
