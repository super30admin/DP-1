# Time Complexity : O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        coins.sort(reverse=True)
        dp = [[-1 for _ in range(amount+1)] for _ in range(len(coins))]

        def helper(i, totalSum) -> int:
            if i == len(coins) or totalSum > amount:
                return sys.maxsize

            if dp[i][totalSum] != -1:
                return dp[i][totalSum]

            if totalSum == amount:
                return 0

            include = 1 + helper(i, totalSum + coins[i])
            exclude = helper(i + 1, totalSum)

            dp[i][totalSum] = min(include, exclude)
            return dp[i][totalSum]

        ans = helper(0, 0)
        return -1 if ans == sys.maxsize else ans