"""
#coin change 

Time Complexity : O(m*n) m -> len(coins) and m -> amount
Space Complexity -0(m*n)"""

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        #null case
        if (coins ==None or len(coins) == 0):
            return 0
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        
        for i in range(len(dp)):
            dp[i][0] = 0
        
        #first row
        for j in range (1,len(dp[0])):
            dp[0][j]=amount+1
            
            
        for i in range (1,len(dp)):
            for j in range (1,len(dp[0])):
                #denomination of coin is less than j
                if j<coins[i-1]:
                    #zero case
                    dp[i][j]=dp[i-1][j]
                else:
                    #zero case and one case
                    dp[i][j] = min(dp[i-1][j],dp[i][j-coins[i-1]]+1)
        result = dp[len(dp)-1][len(dp[0])-1]
        if result >= amount+1:
            return -1
        return result
        