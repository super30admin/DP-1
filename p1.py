# Time Complexity : O(S*n)
# Space Complexity : O(S)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach


class Solution:

    def coinChange(self, coins: List[int], amount: int) -> int:

        coins.sort()

        dp = [0 for i in range(amount + 1)]

        for i in range(1, amount + 1):

            dp[i] = float('inf')

            for c in coins:
                if i >= c:
                    dp[i] = min(dp[i], dp[i - c] + 1)
                elif i < c:
                    break

        # use list comprehensions
        # for i in range(1, amount + 1):
        # dp[i] = min([dp[i - c] if i - c >= 0 else float('inf') for c in coins]) + 1

        for i in range(len(dp)):
            if dp[i] == float('inf'):
                dp[i] = -1

        return dp[-1]


'''    
    # Recursive
    def coinChange(self, coins: List[int], amount: int) -> int:

        coins.sort()

        if amount == 0:
            return 0

        elif amount < coins[0]:
            return -1

        m = float('inf')

        for c in coins:
            n = self.coinChange(coins,amount-c)
            if n != -1:
                m = min(m, 1 + n)

        if m == float('inf'):
            return -1
        else:
            return m
'''