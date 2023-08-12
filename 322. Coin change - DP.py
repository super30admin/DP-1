# Using DP
# Time complexity : O(m*n)
# Space complexity : O(m*n)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = []
        for i in range(len(coins)+1):
            row = []
            for j in range(amount+1):
                row.append(0)
            dp.append(row)
        
        dp[0][0] = 0
        for i in range(1,amount+1):
            dp[0][i] = 99999
        for i in range(1,len(coins)+1):
            for j in range(amount+1):
                # Till denomination of the coin is greater than amount
                if coins[i-1]>j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(1+dp[i][j-coins[i-1]],dp[i-1][j])
        # print(dp)
        if dp[len(coins)][amount] == 99999:
            return-1
        return dp[len(coins)][amount]

        