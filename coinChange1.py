class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
       

        #Here we follow DP approach. Taking (amout+1) colums and (coins.length+1) rows. If amount value is less than the coin denomination then we take value above the current cell. If not then we take minimum of value above the cell and (1 + value at cur position - coin denomination).
        #Time complexity - O(m*n) where m = (1+number of coins) and n = (amount+1)
        #Space complexity - O(m*n)
        m = len(coins)+1
        n = amount+1

        dp = [[0]*n for i in range(m)]

        for i in range(1, n):
            dp[0][i] = amount+1


        for i in range(1, m):
            for j in range(1, n):
                if j<coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
        
        return dp[m-1][n-1] if dp[m-1][n-1]<(amount+1) else -1

#------------------------------OR----------------------------------------------


     #Here we follow recurrsive tree - exhaustive approach. This gives time exceeded
        #Time complexity - O(2^(m+n)) where m = (number of coins) and n = (amount)

        if not coins:
            return -1

        return self.helper(coins, amount, 0, 0)

    def helper(self, coins, amount, idx, minCount):

        if amount==0:
            return minCount
        if idx>=len(coins) or amount<0:
            return -1

        case1 = self.helper(coins, amount-coins[idx], idx, 1+minCount)
        case0 = self.helper(coins, amount, idx+1, minCount)

        if case1 == -1:
            return case0

        if case0 == -1:
            return case1

        return min(case0, case1)
