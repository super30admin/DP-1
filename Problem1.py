# https://leetcode.com/problems/coin-change/description/

# Solution 1
# TC: 2^m+n
# SC: m+n
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Explored the greedy logic and realized it doesn't fit. Then decided with exhaustive approach(recursive). This approach explores all 
# the permutations and combinations. We have two options at every step, choose and not choose. Whenever the amount reaches 
# 0, then it means we have a valid branch. We need to check for all the branches which has amount equals to 0, then compute 
# the minimum of coinsUsed and return that. 

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        self.minimum = float('inf')
        self.helper(coins, amount, 0, 0)
        if self.minimum == float('inf'):
            return -1
        return self.minimum

    def helper(self, coins, amount, i, coinsUsed):

        if amount < 0 or i == len(coins):
            return

        if amount == 0:
            self.minimum = min(self.minimum, coinsUsed)
            return 

        # case 0 // not choose
        self.helper(coins, amount, i+1, coinsUsed)

        # case 1 // choose
        self.helper(coins, amount-coins[i], i, coinsUsed+1)

# Solution 2
# TC: O(m*n)
# SC: O(m*n)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        m = len(coins)
        n = amount

        dp = [[0] * (n + 1) for _ in range(m+1)]
        
        for j in range(1, n+1):
            dp[0][j] = 99999

        for i in range(1, m+1):
            for j in range(1, n+1):
                if j < coins[i-1]: # no choose is available
                    dp[i][j] = dp[i-1][j]
                else:
                    # min between choose and no choose
                    dp[i][j] =  min(dp[i-1][j], 1 + dp[i][j- coins[i-1]])

        if dp[m][n] == 99999: return -1

        return dp[m][n]
    

# Solution 3
# DP with tabulation using 1D array
# TC: O(m*n)
# SC: O(n)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        m = len(coins)
        n = amount

        dp = [0] * (n + 1)
        
        for j in range(1, n+1):
            dp[j] = 99999

        for i in range(1, m+1):
            for j in range(1, n+1):
                if j < coins[i-1]: # no choose is available
                    dp[j] = dp[j]
                else:
                    # min between choose and no choose
                    dp[j] =  min(dp[j], 1 + dp[j- coins[i-1]])

        if dp[n] == 99999: return -1

        return dp[n]

        