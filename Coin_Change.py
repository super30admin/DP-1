
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        columns = len(coins)+1
        rows = amount+1
        dp = [[0 for i in range(rows)] for j in range(columns)]
        
        coins.sort()
        
        dp[0][0] = 0
        for i in range(1,len(dp[0])):
            dp[0][i] = 2**31
        for i in range(1,len(dp)):
            dp[i][0] = 0
            
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(1+dp[i][j - coins[i-1]],dp[i-1][j])
        if dp[-1][-1] == 2**31:
            return -1
        return dp[-1][-1]