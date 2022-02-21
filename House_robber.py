
"""
Time Complexity :- O(2^n)
Space Complexity :- 0(n)
"""


class Solution:
    def rob(self, nums):
        dp = {}
        ans = self.rob1(nums, 0, dp)
        if ans == 0:
            return 0
        else:
            return ans

    def rob1(self, money, index, dp):

        if index >= len(money):
            return 0
        if index in dp:
            return dp[index]

        crob = money[index] + self.rob1(money, index + 2, dp)
        nrob = self.rob1(money, index + 1, dp)

        dp[index] = max(crob, nrob)

        return max(crob, nrob)
