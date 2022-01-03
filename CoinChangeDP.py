# // Time Complexity : O(M*N)
# // Space Complexity : O(M*N)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp =[[0]*(amount+1)]*(len(coins)+1)
        #first row is infinity or amount +1
        for j in range(1, len(dp[0])):
            dp[0][j] = amount+1 # or infinity
        
        for i in range(1, len(dp)):
            for j in range(1,len(dp[0])):
                if(j< coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1)
                    
        
        result = dp[len(dp)-1][len(dp[0])-1]

        if result > amount:
            return -1
        else:
            return result
            
            
        
