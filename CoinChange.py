#Time Complexity: O(m*n) m-Number of coins, n-Amount
#Space Complexity: O(m*n)
#Successfully ran on leetcode

class Solution:
    def coinChange(self, coins: list(int), amount: int) -> int:
        n = len(coins)
        if n==0:
            return -1
        dp=[]
        for i in range(n+1):
            dp.append([])
        dp[0].append(0)
        for i in range(1,amount+1):
            dp[0].append(amount+1)
        for i in range(1,n+1):
            for j in range(amount+1):
                if j<coins[i-1]:
                    dp[i].append(dp[i-1][j])
                else:
                    dp[i].append(min(dp[i-1][j],dp[i][j-coins[i-1]]+1))
        if dp[n][amount]==amount+1:
            return -1
        else:
            return dp[n][amount]