# Time complexity = O(m*n)
# Space complexity = O(m*n)

class Solution:
    def rob(self, nums):
        m = len(nums)
        n = 2

        dp = [[0 for i in range(0, n)] for j in range(0, m)]
        dp[0][0] = nums[0]
        dp[0][1] = 0

        for i in range(1, m):
            for j in range(n):
                if j == 0:
                    dp[i][j] = nums[i] + dp[i - 1][1]

                else:
                    dp[i][j] = max(dp[i - 1][0], dp[i - 1][1])

        return max(dp[m - 1][0], dp[m - 1][1])


