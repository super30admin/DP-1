# 322. Coin Change
# https://leetcode.com/problems/coin-change/

# Brute Force
# Time Complexiety: O(k^n) k is length of coins array
class BF_Solution:
    def _helper(self,coins,amount,count,idx):
        if amount == 0:
            return count

        if amount < 0:
            return 1000 # treat as infinity

        if idx == len(coins) and amount != 0:
            return 1000

        notTaken = self._helper(coins,amount,count,idx+1)
        taken = self._helper(coins,amount-coins[idx],count+1,idx)

        return min(notTaken,taken)

    def coinChange(self, coins, amount) -> int:
        return -1 if self._helper(coins,amount,0,0) == 1000 else self._helper(coins,amount,0,0)

obj = BF_Solution()
print(obj.coinChange([2],3))

#DP
# Time complexiety: O(n*m)
# Space complexiety: O(n*m)
class Solution:
    def coinChange(self, coins, amount) -> int:
        dp = [[0] * (amount + 1) for _ in range(len(coins)+1)]

        for i in range(1,len(coins)+1):
            dp[i][0] = 0
        for i in range(1,amount+1):
            dp[0][i] = amount + 1

        for row in range(1,len(coins)+1):
            for col in range(1,amount+1):
                if col < coins[row-1]:
                    dp[row][col] = dp[row-1][col]
                else:
                    dp[row][col] = min(dp[row-1][col],dp[row][col-coins[row-1]]+1)

        if dp[len(coins)][amount] == (amount+1):
            return -1
        else:
            return dp[len(coins)][amount]

obj = Solution()
print(obj.coinChange([1,2,5],6))