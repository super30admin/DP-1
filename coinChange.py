# Time Complexity : O(m*n)
# Space Complexity : O(m*n)

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        row = len(coins) + 1
        col = amount +1

        dp = [[99999 for x in range(col)] for x in range(row)]

        for j in range (1, row):
            dp[j][0] = 0

        for i in range(1,row):
            for j in range(1,col):
                if coins[i-1]>j:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]])
        
        if (dp[row-1][col-1] == 99999):
            return -1
        return dp[row-1][col-1]
