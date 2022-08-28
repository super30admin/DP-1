#tc: O(m*n)
#sc: O(m*n)

# Dynamic Programming

class Solution:
    def coinChange(self, coins, amount):
        
        dp = [[0]*(amount+1) for i in range(len(coins)+1)]
        dp[0][0] = 0
        
        #Top row
        for j in range(1,len(dp[0])):
            dp[0][j] = amount+1 # Instead of assigning infinity
            
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
            
                 if coins[i-1] > j:
                        # If denomiantion is greater than the amount do not choose so take from above
                        dp[i][j] = dp[i-1][j]
                
                 else:
                        dp[i][j] = min(dp[i-1][j], 1+dp[i][j - coins[i-1]])
       
        res = dp[len(dp)-1][len(dp[0])-1]
        if res > amount:
            return -1
        else:
            return res
                                        
                
obj = Solution()
print(obj.coinChange([1,2,5],11))