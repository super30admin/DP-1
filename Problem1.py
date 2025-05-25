''' 
Recursive Approach:
    Time Complexity: 
        Without Memoization :  O(n^m) 
        With Memoization : O(n*m)
    Space Complexity: O(n) 

Bottom Up DP:
    Time Complexity: O(n*m)
    Space Complexity: O(n)

Approach: 
    1. Recursive Approach: 
       For Recursive approach, we try to solve the problem by iterating over all possible combinations of coins, 
       we exhaustively try all combinations and find the minimum number of coins required to make the change.
       
    2. Bottom Up DP:
       For Bottom Up DP, we try to find the Recurrence Relation between the states i and i-coin,
       where i is the value of the coin we need to reach from i-coin, dp[i-coin] is the least number of coins required to form the amount i-coin, 
       and dp[i] is the least number of coins required to form the amount i. 
       We know that, dp[i] = min(dp[i-coin] + 1, dp[i]) for all the coins we have 
'''

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        # recursive approach top down DP gives TLE
        @cache
        def solve(current, count):
            if current == amount:
                return count
            minCount = 10000000
            for coin in coins:
                if coin + current <= amount:
                    tempCount = solve(coin + current, count + 1)
                    minCount = min(tempCount, minCount)
            return minCount

        res = solve(0, 0)
        if res == 10000000:
            return -1
        return res 

        # bottom up DP
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        for i in range(1, amount + 1):
            for coin in coins:
                if i - coin >= 0:
                    dp[i] = min(dp[i], dp[i - coin] + 1)

        return dp[amount] if dp[amount]!= float('inf') else -1
