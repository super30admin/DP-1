"""
Intuition: Try greedy first by getting the highest denomination coins first.
This fails.

Draw recursive tree starting from target going to 0.
Subproblems can be observed here.

For getting all possible combinations of coins for all possible combinations of targets

#####################################################################
For Recursive: 2 decisions are made for every coin.
Time Complexity : O(2^N)  N = number of rows
Space Complexity : O(2^N) 
#####################################################################
For DP Approach: 
Time Complexity : O(target * numberOfCoins) 
Space Complexity :  O(target * numberOfCoins)
#####################################################################
"""
#Recursive
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        return self.helper(coins, amount,0,0)
    
    def helper(self,coins,amount, index, minCoins):
        if amount == 0:
            return minCoins
        if index >= len(coins) or amount < 0:
            return -1
        
        
        else:
            case1 = self.helper(coins, amount, index + 1, minCoins)
            case2 = self.helper(coins, amount - coins[index], index, minCoins+1)
            if case1 == -1:
                return case2
            if case2 == -1:
                return case1
            return min(case1, case2)

#DP
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        dp = [[float("inf") for _ in range(amount + 1)] for _ in range(len(coins) + 1)]
        dp[0][0] = 0
        
        for row in range(len(coins)+1):
            dp[row][0] = 0

        for i in range(1, len(coins)+1):
            for j in range(1, (amount)+1):
                
                target = j
                denomination = coins[i-1]
                
                if target <denomination:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][target - denomination] + 1)
                    
        return -1 if dp[-1][-1] == float("inf") else dp[-1][-1]
                    
#DP withO(Target) Space
class Solution:
    def coinChange(self, coins: List[int], target: int) -> int:

        minNumberOfCoins = [float("inf") for i in range(target+1)]
        minNumberOfCoins[0] = 0
        for denominator in coins:
            for amount in range(target+1):
                if denominator <= amount:
                    minNumberOfCoins[amount] = min(minNumberOfCoins[amount], 1+ minNumberOfCoins[amount-denominator])
        return minNumberOfCoins[-1] if minNumberOfCoins[-1]!= float("inf") else -1
        