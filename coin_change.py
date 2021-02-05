# O(C * A) TIME AND O(A) SPACE WHERE C IS NO.OF COINS AND A IS AMOUNT
class Solution:
    def coinChange(self, coins, amount):
        dp = [float("inf") for i in range(amount+1)]
        dp[0] = 0
        for coin in coins:
            for i in range(coin,amount+1):
                dp[i] = min(dp[i],1+dp[i-coin])

        return dp[-1] if dp[-1] != float("inf") else -1
                