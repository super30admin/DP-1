class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[float('inf')]*(amount+1)]*(len(coins)+1)
        
        for i in range(len(coins)+1):
            dp[i][0] = 0
            
        for i in range(len(coins)+1):
            for j in range(amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                    
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]] +1 )
        
        if dp[-1][-1] != float('inf'):
            return dp[-1][-1]
        return -1
#Time Complexity = O(N *n)
#Space Complexity = O(N *n)