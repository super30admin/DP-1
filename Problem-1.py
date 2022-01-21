# Time Complexity: O(len(coins) * amount ) || O(len(dp)* len(dp[0]))
# Space Complexity: O(len(coins) * amount ) || O(len(dp)* len(dp[0]))
# Leetcode Execution: YES
class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        # initializing a 2D array in python with 0s
        dp=[0 for _ in range(len(coins)+1)]
        for i in range(len(dp)):
            if i==0:
                # making sure first row is all infinity or amount+1
                dp[i]=[amount+1 for _ in range(amount+1)]
            else:
                dp[i]=[0 for _ in range(amount+1)]
        dp[0][0]=0
        
        # looping through the 2d array for computations 
        for i in range(1,len(coins)+1,1):
            for j in range(1,amount+1,1):
                # if colum is less than the current row coin value then just copy data from the above row /
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    # else check which is smaller the data data above or the value after using the coin 
                    dp[i][j]=min(dp[i-1][j], 1+dp[i][j-coins[i-1]])
        # return -1 if the final row clum value is infinity or greater than amount 
        if dp[len(coins)][amount]>amount:
            return -1
        else:
            # return the last row and column value if everything goes right  
            return dp[len(coins)][amount]
            
        