# Using recursion (DFS)
# Time complexity : 2^(len(coins)+amount)
# Space complexity : (len(coins)+amount)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        return self.helper(coins,0,amount,0)

    def helper(self,coins,idx,amount,coinsUsed):
        # Base
        if amount == 0:
            return coinsUsed
        if (amount<0 or idx == len(coins)):
            return -1
        # Logic
        # Choose
        case_1= self.helper(coins,idx,amount-coins[idx],coinsUsed+1)
        # Not Choose
        case_2 = self.helper(coins,idx+1,amount,coinsUsed)
        if case_1 == -1:
            return case_2
        if case_2 == -1:
            return case_1

        return min(case_1,case_2)