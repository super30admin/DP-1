# Time Complexity : O(m*n) where m is the number of denominations available and n is the amount + 1

#  Space Complexity : O(m*n)

# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
#I maintain a 2d array where I keep the track of minimum coins required to reach the amount.


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins == None or len(coins) == 0:
            return -1

        rows, cols = len(coins) + 1, amount + 1
        table = [[0] * cols] * rows
        table[0] = [amount + 1] * (cols)
        table[0][0] = 0

        for i in range(1, rows):
            for j in range(1, cols):
                if (j < coins[i - 1]):
                    table[i][j] = table[i - 1][j]
                else:
                    table[i][j] = min(table[i - 1][j], 1 + table[i][j - coins[i - 1]])

        if (table[-1][-1] == amount + 1):
            return -1
        else:
            return table[-1][-1]





