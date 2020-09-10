#Time complexity: O(len(coins) * amount)
#Space complexity: O(len(coins) * amount)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[None for _ in range(amount+1)] for _ in range(len(coins)+1)]

        for i in range(1, amount+1):
            dp[0][i] = 99999
        for i in range(0, len(coins)+1):
            dp[i][0] = 0
        
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]])

                    
        return dp[-1][-1] if dp[-1][-1] < 99999 else -1
