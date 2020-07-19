# https://leetcode.com/problems/house-robber/submissions/

# // Time Complexity : o(number of houses)
# // Space Complexity : o(1) = only two choices (to rob, or to not to rob)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this : none
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [[0 for i in range(2)] for j in range(len(nums) + 1)]

        for i in range(1, len(nums) + 1):
            for j in range(2):
                if j == 0:
                    dp[i][j] = dp[i - 1][j + 1]
                else:
                    dp[i][j] = max(dp[i - 1][j - 1] + nums[i - 1], dp[i - 1][j])
        return max(dp[len(nums)][0], dp[len(nums)][1])

