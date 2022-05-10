'''
Successfully executed all the test cases on Leetcode
Time Complexity: O(mn), m is length of coins list and n is the amount
Space Complexity: O(mn),m is length of coins list and n is the amount 
'''

#CODE
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[0 for i in range(amount+1)] for _ in range(len(coins)+1)]
        dp[0] = [amount+1 for i in range(amount+1)]
        dp[0][0] = 0
        
        for i in range(1,len(dp)):
            for j in range(len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j],dp[i][j-coins[i-1]]+1)
        if dp[-1][-1] >= amount+1:
            return -1
        return dp[-1][-1]
        