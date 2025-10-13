#tc = m*n
#sc = m*n
class solution:
    def coinchange(self,coins,amount):
        m = len(coins)
        n = amount
        dp = [[0]*(n+1) for _ in range(m+1)]
        for j in range(1,n+1):
            dp[0][j] = 99999
        for i in range(1,m+1):
            for j in range(n+1):
                if j<coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])
        return -1 if dp[m][n] == 99999 else dp[m][n]
        

        
if __name__ == "__main__":
    sol = solution()
    print(solution().coinchange([1,2,5],11))
    print(solution().coinchange([2],3))
    print(solution().coinchange([1],0))
    
