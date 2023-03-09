# Time Complexity :  O(mn) m = number of coins, n = amount
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[0 for j in range(amount+1)] for i in range(len(coins)+1)]

        for j in range(amount+1):
            dp[0][j] = sys.maxsize

        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]])

        if dp[len(coins)][amount] == sys.maxsize:
            return -1
        return dp[len(coins)][amount]
