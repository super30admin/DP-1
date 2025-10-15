# Time complexity: 2^m+n n=> no. of elements in array m => amount
# At every point decide to choose or not to choose a particular element
# If choosen then update the amount substracting the choosen number
# If not choosen then just move the index pointer to + 1
# If we encounter 0 amount at any point that's what we want so add 1 to it
# If amount -ve or indx out of bound then just return infinity which will get ignored in min(left_call,right_call)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        result = self.helper(0,coins,amount)
        if result == float('inf'):
            return - 1
        return result

    def helper(self,idx,coins,amount):
        # Base
        if amount == 0:
            return 0
        if amount < 0 or idx == len(coins):
            return float('inf')

        # Logic
        # Choose
        choose = 1 + self.helper(idx,coins,amount-coins[idx])
        # Not choose
        not_choose = self.helper(idx + 1,coins,amount)

        return min(choose, not_choose)
    

# TIME AND SPACE COMPLEXITY: m * n where n=> number of coins and m=> amount
# Create a dp_matrix (a matrix because we have 2 input variables) with 1 extra col and row to include from 0 till the end
# Assign 1st row as infinity and other elements as 0
# Using tabulation and coin_change pattern standing on a current coin calculate the amount of coins used by cheking the peviously solved sub problems
# At the end return the last element which will have the min coins required to make the given amount


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        rows = len(coins)
        cols = amount
        dp_matrix = []

        for i in range(rows + 1):
            row = []
            for j in range(cols + 1):
                if i == 0:
                    row.append(float('inf'))
                else:
                    row.append(0)
            dp_matrix.append(row)

        for i in range(1,rows+1):
            for j in range(1,cols+1):
                if j < coins[i -1]:
                    dp_matrix[i][j] = dp_matrix[i - 1][j]
                else:
                    dp_matrix[i][j] = min(dp_matrix[i - 1][j],dp_matrix[i][j- coins[i-1]] + 1)

        if dp_matrix[rows][cols] == float('inf'):
            return -1
        return dp_matrix[rows][cols]