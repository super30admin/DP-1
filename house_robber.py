# tc : O(N)
# sc : O(N)
from typing import List

class Solution:
    def rob(self, hval: List[int]) -> int:
        n = len(hval)
        if n == 0:
            return 0
        if n == 1:
            return hval[0]
        if n == 2:
            return max(hval[0], hval[1])

        # dp[i] represent the maximum value stolen so
        # for after reaching house i.
        dp = [0]*n

        # Initialize the dp[0] and dp[1]
        dp[0] = hval[0]
        dp[1] = max(hval[0], hval[1])

        # Fill remaining positions
        for i in range(2, n):
            dp[i] = max(hval[i]+dp[i-2], dp[i-1])

        return dp[-1]