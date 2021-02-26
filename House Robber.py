# Time Complexity:O(1)
# Space Complexity:O(n*m)
class Solution:
    def rob(self, nums):
        n = len(nums)
        if n == 0:
            return 0
        m = 2
        dp = [[0 for i in range(m)] for j in range(n)]
        dp[0][0] = nums[0]
        dp[0][1] = 0

        for t in range(1, (n)):
            for r in range(0, (m)):  # 0 -> Choose  1-> Dont Choose
                if r == 0:  # Choose
                    dp[t][r] = nums[t] + dp[t - 1][1]
                else:  # Don't Choose
                    dp[t][r] = max((dp[t - 1][1]), (dp[t - 1][0]))

        max_value = max((dp[n - 1][0]), (dp[n - 1][1]))
        return max_value

nums = [2,7,9,3,1]
s = Solution()
ans = s.rob(nums)
print(ans)