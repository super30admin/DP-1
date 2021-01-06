# // Time Complexity : O(n)
# // Space Complexity : O(no of coins , amount)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
	# Identify the repeating sub problem and implement it on a dp table
	# variang parameters are coins and amount so it will be a matrix

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[0 for i in range(amount+1)] for j in range(len(coins)+1)] 
        print(dp)
        for k in range(1,amount+1):
            dp[0][k] = amount + 1
        
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j] , 1 + dp[i][j-coins[i-1]])
        mincoins = dp[-1][-1]
        if mincoins > amount:
            return -1
        return mincoins