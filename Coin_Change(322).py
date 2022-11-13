# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        n = len(coins)
        calc_matrix = [[0 for i in range(amount+1)] for j in range(n+1)]

        # initializing the first row to a value of infinity(amount+1 is similar to infinity as it would be out of reach of the program)
        for i in range(1,amount+1):
            calc_matrix[0][i] = amount+1

        # as we have taken 0 padding in both rows and columns we start from the actual values (1,1)
        # we go over the columns of a row if the amount is greater than the current coin,
        # we just copy the number of coins from the previous row of the same column
        # as the curr coin won't add to the coins in any way ---
        # we select the minimum of ((case if we dont select the curr coin)the number of coins from the previous row of the same column
        # and (if we select the coin)the column of the current row where col = amount-value of curr coin
        # so we check which is smaller and if the value(+1) in the same row is smaller we select that
        # +1 because that config was before we selected the curr coin so if we select that,we need to add it to the count
        # and we go back curr_coin columns as we are left with that amount once we selected curr_coin
        # and that column has the minimum coins required for that amount
        for coin_idx in range(1,n+1):
            for amount_idx in range(1,amount+1):
                if coins[coin_idx-1] > amount_idx:
                    calc_matrix[coin_idx][amount_idx] = calc_matrix[coin_idx-1][amount_idx]
                else:
                    calc_matrix[coin_idx][amount_idx] = min(calc_matrix[coin_idx][amount_idx-coins[coin_idx-1]]+1,calc_matrix[coin_idx-1][amount_idx])

        # if the final count has exceeded the amount, return -1 since it will exceed only when the
        # combination of coins cant reach the target as it will just be copied from the 0th column
        if calc_matrix[n][amount] > amount:
            return -1

        return calc_matrix[n][amount]