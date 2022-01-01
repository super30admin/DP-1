# Time Complexity: O(mn)
# Space Complexity: O(mn)

class Solution:
    
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        dp = [[0 for j in range(amount+1)] for i in range(len(coins)+1)]  # creating a matrix
        for x in range(len(coins) + 1):
            dp[x][0] = 0
        for k in range(1,len(dp[0])):
            dp[0][k] = amount+1    # initializing the values in 1st row to infinity
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                # coin value greater than denomination then provide same values as in previous row
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:  
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1)
        result = dp[len(dp)-1][len(dp[0])-1]
        if result > amount:
            return -1 
        else:
            return result