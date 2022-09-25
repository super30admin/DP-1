

# Passed on leetcode
# TC of DP: o(M*N)
# SC of DP: o(N)

# Recursion
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        def helper(coins, amount, coincount, index):
            
            if index == len(coins) or amount < 0:
                return -1
            if amount==0:
                return coincount
            # decide not to choose
            case1 = helper(coins,amount, coincount, index+1 )
            # Decide to choose
            case2 = helper(coins,amount-coins[index], coincount+1, index )

            if case1 == -1:
                return case2
            if case2 == -1:
                return case1
            return min(case1,case2)
        if len(coins) == 0 :
            return -1
        return helper(coins, amount, 0, 0)
# DP

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins)==0:
            return 0
        m = len(coins)
        n = amount
        dp = [[0] * (n+1) for i in range(m+1)] 
        i = 0
        while(i < n+1):
            if i==0:
                dp[0][i] = 0
            else:
                dp[0][i] = amount+1
            i += 1
 

        for i in range(1,m+1):
            for j in range(1,n+1):

                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j] 
                 
                else:
                    
                  
                    dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]])
                 
        if dp[m][n]==amount+1:
            return -1
        else:
            
            return dp[m][n]                  
        