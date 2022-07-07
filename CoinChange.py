# Time Complexity : O(M * N) //It runs for the inner and outer loop for amount and length of coins array respectively
#  Space Complexity : O(M * N) //The space taken is also with respect to the nested loops
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:        
        lenCoin = len(coins)
        #Take dp with length (amount + 1) 
        dp = [[float('inf') for x in range(amount + 1)] for y in range(lenCoin + 1)]
        
        #Iterate over evry coin and initailizing row as 0
        for i in range(1, lenCoin + 1):
            dp[i][0] = 0
        
        #Iterate over amount and total coin, we check to see if its a valid value (greater than or equal to 0)
        #and if so, we add our dp[i][j] the minimum of the smallest amount and the current one .
        for i in range(lenCoin + 1):
            
            for j in range(amount + 1):
                
                if coins[i - 1] <= j:
                    
                    dp[i][j] = min(dp[i][j - coins[i - 1]] + 1, dp[i - 1][j])
                    
                else:
                    
                    dp[i][j] = dp[i - 1][j]
        if dp[i][j] != float("inf"):
            return dp[i][j]  
        else:
            return -1