import sys 

class Solution:
    """
    Time complexity - O(m*n) - m - # coins. n - amount
    Space complexity -  O(m*n) - m - # coins. n - amount
    """
    def coinChange(self, coins: list[int], amount: int) -> int:
        # dp[x][y] stores the min coins needed from coins[0..x] to make sum y
        dp = [[0 for x in range(0, amount+1)] for y in range(0, len(coins) + 1)]
        # initialise the dp when coin 0 is given. 
        #Any sum cannot be made. So setting infinity
        dp[0] = [sys.maxsize for x in range(0, amount+1)]
        dp[0][0] = 1  
        # sum 0 can be made by selecting 0 coins.
        for x in range(0, len(coins)+1):
            dp[x][0] = 0
        for x in range(1, len(coins) + 1):
            for y in range(0, amount+1):
                if coins[x-1] <= y:
                    # take min of either selecting coin[x] or not selecting coin[x]
                    dp[x][y] = min(dp[x-1][y], 1+dp[x][y-coins[x-1]])
                else:
                    dp[x][y] = dp[x-1][y]
        if dp[len(coins)][amount] == sys.maxsize:
            return -1
        return dp[len(coins)][amount]
        