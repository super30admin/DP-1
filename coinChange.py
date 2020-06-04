# All analysis is for the solution on line 30 and beyond.
# Time Complexity : O(m*n), where m is amount and n is length of coins array.
# Space Complexity : O(m*n), where m is amount and n is length of coins array.
# Did this code successfully run on Leetcode : Yes!
# Any problem you faced while coding this : Not after the session.

# Your code here along with comments explaining your approach
class Solution(object):
    # approach 1 Brute Force/greedy, Time limit exceeded.
    def coinChangeGreedy(self, coins, amount):
        if len(coins) == 0:
            return 0
        return self.helper(coins, amount, 0, 0)

    def helper(self, coins, amount, index, count):
        if amount == 0:
            return count
        if index == len(coins) or amount < 0:
            return -1

        caseChoose = self.helper(coins, amount-coins[index], index, count+1)
        caseNotChoose = self.helper(coins, amount, index+1, count)

        if caseChoose == -1:
            return caseNotChoose
        if caseNotChoose == -1:
            return caseChoose
        return min(caseChoose, caseNotChoose)

    # storing all possible minimum number of coins for each coin and each value until the amount, by
    # doing this we will minimise the number of coins to form any possible amount between 0 and amount.
    # As the value of coins will go up we will choose either the minimum of the last
    # coin for same amount or a value by factoring in the current coins denomination.
    # at the end, return the biggest coins count for amount.
    def coinChange(self, coins, amount):
        if len(coins) == 0:
            return 0

        dpArray = [[float('inf')] * (amount + 1)] * (len(coins)+1)
        for i in range(len(coins)+1): dpArray[i][0] = 0
        m = len(dpArray)
        n = len(dpArray[0])

        for i in range(1, m):
            for j in range(1, n):
                if j < coins[i-1]:
                    dpArray[i][j] = dpArray[i-1][j]
                else:
                    dpArray[i][j] = min(dpArray[i-1][j], dpArray[i][j-coins[i-1]] + 1)

        result = dpArray[m-1][n-1]
        if result == float('inf'): return -1
        else: return result


print Solution().coinChange([1,2,5], 9)
