#Time Complexity: O(m*n) where m in length of coins and n is amount
#Space Complexity: O(m*n)
#Did it run on Leetcode: Yes

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins is None or len(coins) == 0:
            return 0
        m = len(coins)
        n = amount
        dp = [[0 for jindex in range(n+1)] for index in range(m+1)]
        dp[0][0] = 0
        for index in range(1,n+1):
            dp[0][index] = amount + 1
        print(dp[0])
        for index in range(1,m+1):
            for jindex in range(1,n+1):
                if jindex < coins[index - 1]:
                    dp[index][jindex] = dp[index -1][jindex]
                else:
                    dp[index][jindex] = min(dp[index-1][jindex], 1 + dp[index][jindex - coins[index - 1]])
                
        result = dp[m][n]
        if result > amount:
            return -1
        else:
            return result