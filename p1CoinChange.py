"""
You are given an integer array coins representing coins of different
 denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

// Time Complexity : O(A* N),  A= amount of change, N = amount of coins
// Space Complexity : O(A)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : syntax


// There are 2 approaches, top down and bottom up


"""

class Solution:


    def leastCoins(self, coins, amount):
        '''
        :type coins: list of int
        :type amount: int
        :rtype: int
        '''

        # This table will store the answer to our sub problems
        dp = [amount + 1] * (amount + 1)

        '''
        The answer to making change with minimum coins for 0
        will always be 0 coins no matter what the coins we are
        given are
        '''
        dp[0] = 0

        # Solve every subproblem from 1 to amount
        for i in range(1, amount + 1):
            # For each coin we are given
            for j in range(0, len(coins)):
                # If it is less than or equal to the sub problem amount
                if coins[j] <= i:
                    # Try it. See if it gives us a more optimal solution
                    dp[i] = min(dp[i], dp[i - coins[j]] + 1)

        '''
        dp[amount] has our answer. If we do not have an answer then dp[amount]
        will be amount + 1 and hence dp[amount] > amount will be true. We then
        return -1.
  
        Otherwise, dp[amount] holds the answer
        '''

        return -1 if dp[amount] > amount else dp[amount]

