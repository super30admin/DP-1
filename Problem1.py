# Problem1 (https://leetcode.com/problems/coin-change/)
# Time Complexity: O(m*n),for each of the m coins, we loop through n amounts, so total work is m*n
# Space Complexity: O(n), we only keep one 1D array of size n+1, no matter how many coins we have
# Approach:
# we use a 1D array dp where dp[j] tells us the min coins needed to make amount j
# start every amount as impossible (a large placeholder number), except amount 0
# for each coin, update the array by checking if using that coin gives a smaller answer
# at the end, if dp[n] is still the large placeholder, amount cannot be formed

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = amount
        # rename amount to n, just for shorter code below

        dp = [99999] * (n + 1)
        # dp[j] will store the min coins needed to make amount j
        # start every amount as impossible, 99999 acts as a placeholder for infinity

        dp[0] = 0
        # base case, making amount 0 needs 0 coins, always true no matter what coins we have

        for coin in coins:
            # go through each coin one at a time

            for j in range(coin, n + 1):
                # start from j = coin, since for j < coin this coin is too big to use
                # skipping those j values means dp[j] just keeps its old value, unchanged

                dp[j] = min(dp[j], 1 + dp[j - coin])
                # dp[j] right now is the best answer without using this coin (carried over)
                # 1 + dp[j - coin] means use this coin once, then solve for the smaller leftover amount
                #   the +1 counts the coin we just used
                # take whichever option gives fewer coins and store it back into dp[j]

        return -1 if dp[n] == 99999 else dp[n]
        # if dp[n] is still the placeholder, no combination of coins could make that amount
        # otherwise return the actual minimum number of coins needed