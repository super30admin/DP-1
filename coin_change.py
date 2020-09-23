# Time Complexity : O(N^2)
# Space Complexity : O(N)

# Did this code successfully run on Leetcode : Some TC
# Any problem you faced while coding this : It was hard to figure out DP[i]

class Solution(object):
    def coinChange(self, coins, amount):
        DP = [amount+1]*(amount+1)
        DP[0] = 0
        
        for i in range(1,len(DP)):
            for coin in coins:
                if coin<=i:
                    DP[i] = min(DP[i],DP[i-coin] + 1)
        return DP[amount]
                    
                    
                    