class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not amount or not coins:
            return 0
        
        coins_len = len(coins)
        dp = [[float("INF") for j in range(amount+1)] for i in range(coins_len)]
        
        for idx in range(coins_len):
            dp[idx][0] = 0
        
        for idx in range(coins_len):
            for jdx in range(1, amount+1):
                if jdx < coins[idx]:
                    dp[idx][jdx] = dp[idx - 1][jdx]
                elif jdx == coins[idx]:
                    dp[idx][jdx] = 1
                else:
                    dp[idx][jdx] = min(dp[idx][jdx - coins[idx]] + 1, dp[idx - 1][jdx - coins[idx]] + 1, dp[idx-1][jdx])
                    
        return dp[-1][-1] if dp[-1][-1] != float("INF") else -1