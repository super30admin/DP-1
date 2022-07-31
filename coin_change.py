# Time Complexity : O(mn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0 or amount == 0:
            return 0
        sol_mat = []
        for i in range(len(coins) + 1):
            temp_row = []
            for j in range(amount + 1):
                # For i = 0 i.e First Row
                if i == 0:
                    temp_row.insert(j, 0 if j == 0 else amount + 1)
                else:
                    # if coin  >  amount required then  don't choose
                    if coins[i - 1] > j:
                        temp_row.insert(j, sol_mat[j])
                    else:
                        temp_row.insert(j, min(sol_mat[j], temp_row[j - coins[i - 1]] + 1))
            sol_mat = temp_row
            del temp_row
        res = sol_mat[amount]
        if res > amount:
            return -1
        return res


if __name__ == "__main__":
    # coins = [1, 2, 5]
    # amt = 11
    coins = [2]
    amt = 3
    print(Solution().coinChange(coins, amt))
