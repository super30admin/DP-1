# Approach 1
# Brute Force Approach - exponential Time complexity 
# Space complexity is O(depth of recursive tree)
# Time limit exceeded 
class Solution:
    
    def __helper(self, coins: List[int], amount: int, index: int) -> int:
    
        # BASE
        # the case where a result would be possible         
        if (amount == 0):
            return 1
        
        # the case where a result is never possible
        if (amount < 0 or index == len(coins)):
            return 0

        # LOGIC
        # case where you do not pick the coin at the index 
        # so the coin is ignored but amount remains the same   
        no_pick_case = self.__helper(coins, amount, index + 1)  

        # case where you pick the coin at the index
        # so we still use the coin and amount is reduced by the coin at the index
        pick_case = self.__helper(coins, amount - coins[index], index)
        
        # return the sum since we want total ways to reach an aamount 
        return no_pick_case + pick_case
        
    def change(self, amount: int, coins: List[int]) -> int:
        if (coins == None):
            return 0
        
        # coins array, 
        return self.__helper(coins, amount, 0)
        
        
# Approach 2 - DP 
# Time complexity - O (#rows * #columns)
# Space complexity - O (#rows * #columns)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if (coins == None):
            return 0
        
        rows = len(coins) + 1 # added 1 to cater for cases where 0 is to be made from given coins
        columns = amount + 1
        matrix = [[0]*(columns)]*rows
        
        for i in range(rows):
            matrix[i][0] = 1
        
        for i in range(1, rows):
            for j in range(1, columns):
                # coins is 1D array
                if (j < coins[i-1]):
                    matrix[i][j] = matrix[i-1][j]
                else: 
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-coins[i-1]] 
        
        # return the last value in the 2D array
        return matrix[rows - 1][columns - 1]
        # print(len(coins))
        # print(len(matrix))
        # print(len(matrix[0]))
        
