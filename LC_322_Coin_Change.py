'''
Exhaustive Approach where we explore all the possible paths.
For each coin we have two choices:
- Don't choose: move to the next coin (idx + 1), amount stays the same.
- Choose: use the current coin (count + 1), amount reduces by its denomination, idx stays the same since a coin can be reused.
We take the minimum of the two. Amount < 0 or running out of coins means this path is invalid, so we return infinity.

Time Complexity: O(2^(m+n)) where m is the number of coins and n is the amount. The recursion is at most m+n levels deep (idx moves forward at most m times, amount shrinks at least n times) and branches two ways at each level.
Space Complexity: O(m+n) for the recursion stack.
'''
# Lets list[int] annotations work on Python 3.7/3.8 too (not needed on LeetCode)
from __future__ import annotations


class BruteForce:
    def coinChange(self, coins: list[int], amount: int) -> int:
        result = self.helper(coins, amount, 0)
        if result >= float('inf') - 10:
            return -1
        return result

    
    def helper(self,coins, amount, idx):
        # base case
        if amount < 0 or idx == len(coins):
            return float('inf') - 10
        if amount == 0:
            return 0
        # logic
        # don't choose the current coin
        dont_choose = 0 + self.helper(coins, amount, idx + 1)

        # choose the current coin
        choose = 1 + self.helper(coins, amount - coins[idx], idx)

        return min(choose, dont_choose)


'''
DP Matrix (bottom up / tabulation)
Rows = coins (+1 for the "no coins" row), columns = amounts 0..n.
dp[i][j] = fewest coins needed to make amount j using the first i coins.
- Row 0 (no coins): amount 0 needs 0 coins, every other amount is impossible (infinity).
- If j < coin denomination: we can't choose this coin, so copy from the row above: dp[i-1][j] (don't choose).
- Else we have both options and take the minimum:
    don't choose -> dp[i-1][j]               (row above, same column)
    choose       -> 1 + dp[i][j - coin]      (same row, coin steps back, since a coin can be reused)
The answer is dp[m][n]. If it is still infinity, the amount can't be made, so return -1.

Time Complexity: O(m * n) where m is the number of coins and n is the amount
Space Complexity: O(m * n) for the dp matrix
'''
class DPMatrix:
    def coinChange(self, coins: list[int], amount: int) -> int:
        if coins == None or len(coins) == 0:
            return -1
        m = len(coins)
        n = amount
        dp = [[0 for j in range(n + 1)] for i in range(m + 1)]
        for j in range(1, n + 1):
            dp[0][j] = float('inf') - 10
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                # if amount is smaller than the denomination of the coin we have don't choose case
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                # else we have don't choose and choose case both
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])
        result = dp[m][n]
        if result >= float('inf') - 10:
            return -1 
        return result


'''
DP Array (space optimization of the DP Matrix)
The matrix only ever reads from the row above (dp[i-1][j]) and from the same row (dp[i][j - coin]), so a single 1D array is enough.
dp[j] holds the value of the row above until we overwrite it for the current coin, so "don't choose" is just keeping dp[j] as it is.
We loop j from left to right, so dp[j - coin] has already been updated for the current coin. That is exactly the "choose again" case (coin reuse).

Time Complexity: O(m * n) where m is the number of coins and n is the amount
Space Complexity: O(n) where n is the amount
'''
class DPArray:
    def coinChange(self, coins: list[int], amount: int) -> int:
        if coins == None or len(coins) == 0:
            return -1
        m = len(coins)
        n = amount
        dp = [0 for j in range(n+1)]

        for j in range(1, n+1):
            dp[j] = float('inf') - 10
        
        for i in range(1, m+1):
            for j in range(1, n+1):
                if j < coins[i-1]:
                    dp[j] = dp[j]
                else:
                    dp[j] = min(dp[j], 1+dp[j-coins[i-1]])
        result = dp[n]
        if result >= float('inf') - 10:
            return -1
        return result


# ======================================================================
# Test cases
# Run with: python3 coin_change.py
# To submit on LeetCode, copy the one class you want and rename it to Solution.
# ======================================================================
import unittest

# (coins, amount, expected) - small enough for the exponential brute force
SMALL_CASES = [
    ([1, 2, 5], 11, 3),          # LeetCode example 1: 5 + 5 + 1
    ([2], 3, -1),                # LeetCode example 2: impossible
    ([1], 0, 0),                 # LeetCode example 3: amount 0 needs 0 coins
    ([1], 1, 1),                 # single coin, exact match
    ([1], 2, 2),                 # single coin repeated
    ([2], 4, 2),                 # single coin repeated, even
    ([2], 1, -1),                # coin larger than amount
    ([5], 3, -1),                # coin larger than amount
    ([2, 5], 3, -1),             # no coin fits
    ([1, 3, 4], 6, 2),           # greedy trap: 3 + 3 (greedy gives 4 + 1 + 1)
    ([1, 5, 10], 12, 3),         # 10 + 1 + 1
    ([2, 5, 10], 6, 3),          # 2 + 2 + 2
    ([5, 2, 1], 11, 3),          # unsorted coins
    ([3, 7], 5, -1),             # no combination
    ([3, 7], 13, 3),             # 3 + 3 + 7
    ([1, 2, 5], 0, 0),           # amount 0 with many coins
    ([7, 3], 14, 2),             # 7 + 7
]

# Larger inputs - only the DP solutions (brute force would be far too slow)
LARGE_CASES = [
    ([186, 419, 83, 408], 6249, 20),
    ([1, 2, 5], 100, 20),
    ([2], 9999, -1),
    ([1], 10000, 10000),
    ([5, 10, 25], 10000, 400),
    ([2, 5, 10, 1], 27, 4),      # 10 + 10 + 5 + 2
]


class CoinChangeMixin:
    solution_class = None

    def check(self, cases):
        for coins, amount, expected in cases:
            with self.subTest(coins=coins, amount=amount):
                # pass a copy so a solution can't hide a bug by mutating the input
                self.assertEqual(self.solution_class().coinChange(list(coins), amount), expected)


class TestBruteForce(CoinChangeMixin, unittest.TestCase):
    solution_class = BruteForce

    def test_small(self):
        self.check(SMALL_CASES)


class TestDPMatrix(CoinChangeMixin, unittest.TestCase):
    solution_class = DPMatrix

    def test_small(self):
        self.check(SMALL_CASES)

    def test_large(self):
        self.check(LARGE_CASES)


class TestDPArray(CoinChangeMixin, unittest.TestCase):
    solution_class = DPArray

    def test_small(self):
        self.check(SMALL_CASES)

    def test_large(self):
        self.check(LARGE_CASES)


class TestAllAgree(unittest.TestCase):
    """Cross-check: all three solutions must return the same answer."""

    def test_agreement(self):
        for coins, amount, _ in SMALL_CASES:
            with self.subTest(coins=coins, amount=amount):
                a = BruteForce().coinChange(list(coins), amount)
                b = DPMatrix().coinChange(list(coins), amount)
                c = DPArray().coinChange(list(coins), amount)
                self.assertEqual(a, b)
                self.assertEqual(b, c)


if __name__ == "__main__":
    unittest.main(verbosity=2)