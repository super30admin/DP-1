# Exhaustive
# TC: O(m+n) , m is amount, n is no of coins, Time limit exceede
# SC: no of nodes in the tree, 2^(m+n)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        def helper(coins, idx, amount, coinsUsed):

            if amount == 0:
                return coinsUsed

            if amount < 0 or idx ==len(coins): 
                return -1
            #choose
            case1 = helper(coins, idx, amount - coins[idx], coinsUsed + 1)
            #not choose
            case2 = helper(coins, idx + 1, amount, coinsUsed)

            if case1 == -1: return case2
            if case2 == -1: return case1

            return min(case1, case2)
        return helper(coins, 0, amount, 0)
    
# Tabulation (Bottom-Up)
# Time Complexity: O(n*m), m is amount, n is no of coins
# Space Complexity: O(n*m), m is amount, n is no of coins
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount==0:
            return 0
        m = len(coins)
        n = amount
        dp=[[-1 for j in range(n+1)] for i in range(m+1)]
        dp[0][0] = 0
        for j in range(1, n+1):
            dp[0][j]=maxsize - 10
        for i in range(1,m+1):
            for j in range(n+1):   
                if j< coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]])
        ans=dp[m][n]
        if ans>=maxsize - 10: return -1
        return ans
                    