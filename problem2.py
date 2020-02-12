'''
Time Complexity :O(S*n) A is the amount and n is the number of coins
Space Complexity: O(1)
Did this code successfully run on Leetcode : No (Max Recursive depth on large denomination and few edge cases to fix)
Explanation: Create a function and traverse recursively every time we decrease the amount by a denomination and find
all subproblems.
'''


class Solution:

    def coinChange(self, coins: List[int], amount: int) -> int:
        return self.change(coins, 0, amount, 0)

    def change(self, coins: List[int], i: int, amount: int, count: int) -> int:
        if amount < 0 or i > len(coins) - 1:
            return -1

        if amount == 0:
            return count

        case2 = self.change(coins, i + 1, amount, count)
        case1 = self.change(coins, i, amount - coins[i], count + 1)

        if case1 == -1:
            return case2

        elif case2 == -1:
            return case1

        return min(case1, case2)
