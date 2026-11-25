#Coin change problem

#Time complexity: O(m*n)
#space complexity: O(n)

#Analysis: We first try greedy, it wont work, so we try exhaustive search, that wont work due to ntime limit exceeded and then we see there are repeated sub problems, so we try to do DP.
#As part of the DP we can do tabulation or memoization. we are doing tabulation here with 2d array first
#then with 1d array by further optimizing it.

#so basically we have 3 coins, lets say. we need to identify minimum number of coins that takes to equate to amount.
# So basically we will have to try all possible combinations to get to  a amount with minimum number of coins.
# lets say we have [1,2,5] as coins and amount is 11.
# output is 3 coins with 2 5 coins and 1 one coin denomination.
# how did we reach to this? how do we know thats minimum. we cannot know until we try all possible combinations to get to 11.
# so do that using choose and no choose conditions, in the given coins we either choose the coin or we do not choose the coin at every stage
# as we keep choosing the coin, our amount will reduce, since we add up coins by choosing it and we take that coin into count since the amount is reduced finally reaching to 0.
# we might have multiple such path, we need to choose minimum path.

#if we observe carefully, we have a repeated sub problems here. so choose or no choose of coins at multiple level might come up same with all parameters including coins and amount.

# that is exactly where we are trying to take advantage, by computing the minimum at all levels and storing them in a 1D dp array.

class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        n = len(coins)
        dp = [0 for i in range(amount+1)]
        for j in range(1, amount + 1):
            dp[j] = float('infinity')

        for coin in coins:
            for j in range(1, amount+1):
                if (j >= coin):
                    dp[j] = min(dp[j], dp[j - coin] + 1)
        return -1 if dp[amount] == float('infinity') else dp[amount]

