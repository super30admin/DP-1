# // Time Complexity : O(n*amount) where n: length of coins
# // Space Complexity : O(n*amount)  
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : how to fill the table.

# // Your code here along with comments explaining your approach

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not coins: return 0
        dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        minCoins = float('inf')
        dp[0][0] = 0
        for j in range(1,len(dp[0])):
            dp[0][j] = amount+1
        
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                # if coin value is more than the amount required
                # use the previous row value as current coin cannot 
                # contribute to a lesser sum than its value
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    # min of previous row cell (represents count of 
                    # previous coin value to make the amount 'j') and 
                    # num of coins at amount - cur coin value plus 1 for the cur coin
                    dp[i][j] = min(dp[i-1][j],dp[i][j-coins[i-1]]+1)
                    
        res = dp[-1][-1]
        
        if res > amount:
            return -1
        return res
                    
                    
            
            