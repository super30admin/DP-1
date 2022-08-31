'''
Approach: Bruteforce recursive calls
Here, we are using all the recursive calls in the tree
TC: 2^n where n is the number of coins

'''

'''
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        return self.helper(coins, amount, 0, 0)

    def helper(self, coins, amount, ind, minCoins):

        if amount == 0:
            return minCoins
        if amount < -1 or ind == len(coins):
            return -1

        #choose
        #when you choose the value, ind will remain at the same index as we can choose the same coin infinite times
        case1 = self.helper(coins, amount-coins[ind], ind, minCoins+1)

        #not choose
        case2 = self.helper(coins, amount, ind+1, minCoins)

        if case1 == -1:
            return case2
        if case2 == -1:
            return case1
        return min(case1, case2)
'''
'''
Approach: Bottom-up DP
TC: O(amount*n); n= number of coins
SC: O(amount*n); space for storing matrix
'''


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0

        for coin in coins:
            for x in range(coin, amount + 1):
                dp[x] = min(dp[x], dp[x - coin] + 1)
        return dp[amount] if dp[amount] != float('inf') else -1