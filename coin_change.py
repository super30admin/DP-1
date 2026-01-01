"""
time - o(n)
space - o(n)
create an array whose length is same as amount set the zeroth index as 0. For every coin
calculate the number of ways we can achieve the amount by taking previous amount and adding 1
if we are able to get the target amount with the given coins then the array's amount index will
have a value and not the default value (+inf in this case)
"""
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')]*(amount+1)
        dp[0] = 0
        for coin in coins:
            for i in range(coin, amount+1):
                dp[i] = min(dp[i], dp[i-coin]+1)
        if dp[amount]!=float('inf'):
            return dp[amount]
        return -1
        