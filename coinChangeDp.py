class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
    
        if coins == None or len(coins)==0:
            return None
        dp = [[12 for j in range(amount+1)] for i in range(len(coins)+1)]
#         col1    
        for i in range(0,len(dp)):
            dp[i][0] = 0
#         row1
        for j in range(1, len(dp[0])):
            dp[0][j] = amount+1
        
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                
                if j<coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1)
        
        result = dp[len(dp)-1][len(dp[0])-1]
        
        if result>=amount+1:
            return -1
        
        return result
            
# time complexity would be O(amount*no. of coints) -> O(nk)
#  Approach is to make a dp matrix and not have to compute for repeated subproblems.
            
        
        
