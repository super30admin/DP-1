# Time Complexity --> O(m*n) where m is the amount and n is the number of coins
# Space Complexity --> O(m)
# Approach --> Still going over all the possibilities but optimizing the search by reusing the result for repeated subproblems. This is the Tabulation DP, a bottom up approach. The space complexity is optimized to use only a single array of length m+1 since the result at each node only depends on its curent value or the value before that position in array. 
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)
        m = amount
        dp = [0 for i in range(m+1)]
        for i in range(1,m+1):
            dp[i] = amount+1

        for i in range(1,n+1):
            for j in range(1,m+1):
                if j>=coins[i-1]:
                    dp[j] = min(dp[j], 1+dp[j-coins[i-1]])
        #print(dp)
        if dp[m]>amount:
            return -1
        return dp[m] 
