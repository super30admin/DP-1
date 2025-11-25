'''
In this problem I have used exhaustive approach by using a DP table, where I stored repeated sub problems.
- Initialized a 2D array with amount as columns and coins as rows.
- By comparing the repeated sub problems same as the above elemnts sub problem in the columns and denomination steps back in the row.
- By repeating this till the amount of DP table is reached at the last element we will get the minimum no of coins needed to make up the amount.
'''
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0 or coins is None: return -1
        n = len(coins)
        m = amount
        # dp = [n+1][m+1]
        dp = [[0] * (m + 1) for _ in range(n + 1)]
        # filling first column with infinity
        for i in range(m+1):
            dp[0][i] = amount+1
        # filling DP table
        for i in range(1, n+1): # coins
            for j in range(1, m+1): # amount
                # 2 cases 
                # till the denomination > amount we only have case0
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    # 2 cases, cas0 & case1
                    dp[i][j] = min(dp[i-1][j], 1+ dp[i][j-coins[i-1]])
        res = dp[n][m]
        if(res >= amount+1):
            return -1
        else:
            return res

'''
Time Complexity: O(m*n)
Since we are iterating on an 2D array of size m*n.
Space Complexity: O(m*n)
The size of the array used to store the DP table is m*n.
'''