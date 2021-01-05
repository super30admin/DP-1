# TC = O(m * n)
# SC = O(m * n)
# The recursive approach gives exponential TC. To use recorded subproblems and save time we do DP. 
# Formula derived via recursion tree and DP tabulation
class Solution:
    def coinChange(self, coins, amount):
        dp = [[0] * (amount+1) for _ in range(len(coins)+1)]
        for j in range(1, len(dp[0])):
            dp[0][j] = amount + 1
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-i][j]
                else:
                    # min of zero case and one(chosen) plus subproblem(previous instance before taking current coin in to consideration)
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
        
        res = dp[len(dp)-1][len(dp[0])-1] 
        if res >= amount+1 : return -1
        return res