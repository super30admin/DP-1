#Time O(m *n)
#Space: O(m * n)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m_rows= len(coins)
        n_columns = amount 
        
        # Creates a matrix of m rows and n columns with 0s
        dp = [[0] * (n_columns+1) for _ in range(m_rows + 1)]

        for j in range(1, n_columns +1):
            dp[0][j] = 999999

        for i in range(1, m_rows + 1):
            for j in range(0, n_columns + 1):
                # Until amount is less than denominotaor, we consider 0 case only.
                if j < coins [i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i - 1]])

        result = dp[m_rows][n_columns]

        if result >= 99999:
            return -1
        else:
            return result
