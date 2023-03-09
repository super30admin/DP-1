# Time complexity : O(M*N) - iterating the 2D array
# Space complexity : O(M*N) - size of the 2D array

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # bottom up dp approach
        m=len(coins)+1
        n=amount+1
        dp=[[0]*n for i in range(m)]
        dp[0][0]=0
        for j in range(1,n):
            dp[0][j]=9999999
        for i in range(1,m):
            for j in range(1,n):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j],1+dp[i][j-coins[i-1]])
        if dp[m-1][n-1]==9999999:
            return -1
        return dp[m-1][n-1]
        
        
        
        
        
        
        
#         #exponential time complexity
#         # things that we need for recursion - coins, amount, index, minCoins
#         def helper(coins,amount,idx,minCoins):
#             #base
#             if amount==0:
#                 return minCoins
#             if amount<0 or idx==len(coins):
#                 return -1
            
            
#             #logic
#             #2 choices- choose coin and dont choose coin
#             case1 = helper(coins,amount,idx+1,minCoins)
#             case2 = helper(coins, amount-coins[idx],idx,minCoins+1)
            
#             if case1==-1:
#                 return case2
#             if case2==-1:
#                 return case1
            
            
#             return min(case1,case2)
            
#         return helper(coins,amount,0,0)

        
    






        