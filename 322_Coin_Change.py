'''
## Problem 322: Coin Change

## Author: Neha Doiphode
## Date:   07-02-2022

## Description:
    You are given an integer array coins representing coins of different denominations and
    an integer amount representing a total amount of money.

    Return the fewest number of coins that you need to make up that amount.
    If that amount of money cannot be made up by any combination of the coins, return -1.

    You may assume that you have an infinite number of each kind of coin.

## Approach:
    1. Greedy approach
       Choose max denomination. Subtract it from the target amount and
       keep on repeating the process until target amount is achieved.

       A greedy algorithm is an approach for solving a problem by selecting the best option available at the moment.
       It doesn't worry whether the current best result will bring the overall optimal result.
       The algorithm never reverses the earlier decision even if the choice is wrong.
       It works in a top-down approach.

       Greedy approach does not always guarantee the correct answer.
       For example: Denominations are [2, 5], target amount = 4.

    2. Exhaustive Search with recursion technique(Explore all combinations).
       The decision is made based on 2 choices.
       * Choose the combination        OR
       * Don't choose the combination

       Recursion tree for the problem should look like this.
                              [1, 2, 5], 11
            Don't choose 1   /          \  choose 1
                    [2, 5], 11          [1, 2, 5], 10
                     /     \
                [5], 11  [2, 5], 9
                / \
           [], 11 [5], 6

           Like this we can explore the whole tree.

    3. Dynamic programming
       Dynamic Programming (DP) is an algorithmic technique for solving an optimization problem
       by breaking it down into simpler subproblems and utilizing the fact that
       the optimal solution to the overall problem depends upon the optimal solution to its subproblems.

       Approach is chosen when the subproblems are repeated. So, instead of repeating the computation again,
       the result of computation is stored and re-used when we encounter the similar subproblem again.

       All DP problems will always have a table(1D or 2D array.)
       Decision of 1D/2D array depends on exit criteria.
       If the exit criteria/conditions are more than 1, choose 2D array(In this case, index and amount)
       If the exit criteria/condition is 1, choose 1D array.

       Every cell of the table contains an answer to a sub-problem.
       In this case, 2-D matrix contains

                                Amounts until target amount

            (Denominations)  0  1  2  3  4  5  6  7  8  9  10  11
                        0   inf ----------------------------------> Same
              Index  0  1    0  1  2  3  4  5  6  7  8  9  10  11   cell contents = Number of coins needed upto that point
                     1  2    0  1  1  2  2  3  3  4  4  5  5   6    Go 2 steps behind + 1 coin chosen(for coin chosen case)
                     2  5    0  1  1  2  2  1  2  2  3  3  2   3    Go 2 steps behind + 1 coin chosen(for coin chosen case)

                       case 1 = check above the current cell as we don't choose.

        Denominations don't have to be sorted for the approach to work.

## Examples:
    Example 1:
        Input: coins = [1,2,5], amount = 11
        Output: 3
        Explanation: 11 = 5 + 5 + 1

    Example 2:
        Input: coins = [2], amount = 3
        Output: -1

    Example 3:
        Input: coins = [1], amount = 0
        Output: 0

## Constraints:
    1 <= coins.length <= 12
    1 <= coins[i] <= 231 - 1
    0 <= amount <= 104

## Time complexity: Please refer to function doc-strings.

## Space complexity: Please refer to function doc-strings.
'''

from typing import List

def get_input():
    print("Enter the list of coin denominations with spaces: ", end = "")
    inp_list = input()
    inp_list = [int(value) for value in inp_list.split()]
    print("Enter the target amount: ", end = "")
    target_amount = int(input())
    return inp_list, target_amount

class Solution:
    def helper(self, coins: List[int], amount: int, index: int, number_of_coins_used: int) -> int:
        # Start with a base case
        # There are 3 types of base cases
        # base case 1: We have no denominations left but there is amount left to be processed
        if index == len(coins):
            return -1

        # base case 2: We have denominations left but the amount left is negative
        if amount < 0:
            return -1

        # base case 3: Actual case where the amount is 0 and we still have denominations left
        if amount == 0:
            return number_of_coins_used

        # Now process main cases
        # There are two possible cases

        # DO NOT CHOOSE A COIN CASE
        # Since we don't choose a particular denomination, we need to look at next denomination at index + 1
        # number of coins used will not change in this case
        case1 = self.helper(coins, amount, index + 1, number_of_coins_used)

        # CHOOSE A COIN CASE
        case2 = self.helper(coins, amount - coins[index], index, number_of_coins_used + 1)

        if case1 == -1:
            return case2

        if case2 == -1:
            return case1

        return min(case1, case2)

    ############## TIME LIMIT EXCEEDS #######################
    def coinChange_exhaustive_search_with_recursion(self, coins: List[int], amount: int) -> int:
        '''
        Time complexity: O(s^n), exponential time complexity as we perform exhaustive search.
        Space complexity: O(n), worst case depth of recursion will be n.
        '''

        # Check for edge cases and call the helper function
        if not len(coins):
            return -1

        # Arguments to the helper function are:
        # Coins array, amount, Index in the array to indicate the denomination, number of coins used
        index = 0
        number_of_coins_used = 0
        return self.helper(coins, amount, index, number_of_coins_used)


    def coinChange(self, coins: List[int], amount: int) -> int:
        '''
        Time complexity: O(m * n), where m is number of denominations, n = target amount
        Space complexity: O(m * n), to store auxiliary DP array.
        '''
        # Check for edge cases and call the helper function
        if not len(coins):
            return -1

        rows = len(coins) # 3
        columns = amount # 11

        # Considering extra row and column for 0, we initialize the DP array
        dp = [[0] * (columns + 1)] * (rows + 1)

        # Intialize 0th row with "inf"
        # Instead of "inf" we can also fill it with amount + 1 as we will never go beyond target amount
        dp[0] = [float("inf")] * len(dp[0])

        # Now start filling in the actual table
        # Here we start with row 1, column 1 because we have already filled in 0th row, 0th column
        for row in range(1, rows + 1):
            for column in range(1, columns + 1):
                # until column is less than denomination of the coins, copy the same value
                # here we are considering coins[i-1], because starting value of i is 1 and
                # we want to start from accessing 0th index of coins array.
                if column < coins[row - 1]:
                    # fill with whatever was at the same column but previous row.
                    dp[row][column] = dp[row - 1][column]

                else:
                    # for column > denominations, we have two possibilities
                    # Mininum number of coins out of choose branch or do not choose branch.
                    # we get "not choose" number from previous row and same column
                    # and we get "choose" from same row subtracting current denomination from it.
                    # We apply min function over these two values to fill the actual cell
                    # In choose branch, we add 1 because we need to count a coin chosen for the denomination
                    dp[row][column] = min(dp[row - 1][column], 1 + dp[row][column - coins[row - 1]])

                print(f"Current dp array: {dp}")

        if dp[rows][columns] > amount:
            return -1

        print("DP Array: ")
        return dp[rows][columns]


# Driver code
solution = Solution()
coins, target_amount = get_input()
print(f"Input denominations: {coins}")
print(f"Input target amount: {target_amount}")
print(f"Approach 1: Exhastive search with recursion: Minimum number of coins required to achieve the target amount: {solution.coinChange_exhaustive_search_with_recursion(coins, target_amount)}")
print(f"Approach 2: Dynamic programming: Minimum number of coins required to achieve the target amount: {solution.coinChange(coins, target_amount)}")
