"""
Problem: Coin change
Leetcode: https://leetcode.com/problems/coin-change/solution/
Solution: Use Dynamic programming - bottom up approach
Time complexity : O(S*n). On each step the algorithm finds the next F(i) in nn iterations, where 1≤i≤S.
    Therefore in total the iterations are S*n.
Space complexity : O(S). We use extra space for the memoization table.
"""


class Solution:
    def coin_change(self, coins, amount):
        # Base case
        if amount == 0 or len(coins) == 0:
            return 0

        # Define an array to store number of coins used at particular amount
        # +1 to match amount 0 with index 0
        dp = [float('inf')] * (amount + 1)

        dp[0] = 0
        for x in range(1, amount+1):
            # set the dp[amt] to max possible value so that we can compare and find min number of coins
            dp[x] = amount + 1
            for coin in coins:
                if coin <= x:
                    dp[x] = min(1 + dp[x-coin], dp[x])

        if dp[amount] > amount:
            return -1
        else:
            return dp[amount]


# Test Cases
# coins = [1,2,5]; amount = 11
# coins = [3,2,5]; amount = 1
coins = [2]; amount = 3
obj = Solution()
print(obj.coin_change(coins, amount))