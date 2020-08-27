class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        rows = len(coins) + 1
        columns = amount + 1
        matrix = [[99999 for i in range(columns)] for j in range(rows)]
        
        for i in range(rows):
            for j in range(1):
                matrix[i][j] = 0
                
        for i in range(1, rows):
            for j in range(1, columns):
                if(coins[i - 1] > j):
                    matrix[i][j] = matrix[i-1][j]
                else:
                    matrix[i][j] = min(matrix[i-1][j], matrix[i][j - coins[i-1]] + 1)
        
        if(matrix[len(coins)][amount] >= 99999):
            return -1
        else:
            return matrix[len(coins)][amount]
