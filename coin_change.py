# // Time Complexity : O(m*n)
# // Space Complexity : O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Basic Approach is to use the exhaustive method, trying to find out every possibility to reach the sum using minimum coins, Then analyzed a pattern on repeated sub trees from my actual tree, to optimize further I tried to store the values in a matrix and used bottom up approach to solve the question.


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        dp = [[None for i in range((amount+1))] for j in range(len(coins)+1)]
        
        for i in range(len(coins)+1):
            dp[i][0]=0
            
        for j in range(1, len(dp[0])):
            dp[0][j]= float('inf')
            
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                # base case
                if(j < coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1)
                    
        result = dp[-1][-1]
        
        if result>amount:
            return -1
        return result
                
            
        