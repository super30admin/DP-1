'''
Time Complexity :O(S*n) A is the amount and n is the number of coins
Space Complexity: O(1)
Did this code successfully run on Leetcode : No (Max Recursive depth on large denomination and few edge cases to fix)
Explanation: Create a function and traverse recursively every time we decrease the amount by a denomination and find
all subproblems.
'''


class Solution:

    def coinChange(self, coins: List[int], amount: int) -> int:
        return self.change(coins, len(coins), amount)

    def change(self, coins: List[int], m: int, amount: int) -> int:
        if amount == 0:
            return 1

        if amount < 0:
            return 0;

        if amount <= 0 and amount >= 1:
            return 0

        return self.change(coins, m - 1, amount) + self.change(coins, m, amount - coins[m - 1]);
