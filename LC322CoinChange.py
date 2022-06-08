
class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        m= len(coins) +1
        n= amount +1
        dp = [[2**31]*n for _ in range(m)]
        dp[0][0]=0

        # print(dp)
        for i in range(1,m):
            for j in range(0,n):
                denomination = coins[i-1]
                dp[i][j]=min(dp[i-1][j], dp[i][j-denomination]+1)
        if dp[m-1][n-1]==2**31:
            return -1

        else:
            return dp[m-1][n-1]

coins=[1,2,5]
amount=11
object = Solution()
ans = object.coinChange(coins, amount)
print(ans)
        