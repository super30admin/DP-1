'''
Time Complexity: O(N*range(amount))
Space Complexity: O(N*range(amount))
'''
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        matrix = [0]*(len(coins)+1)
        for i in range(len(matrix)):
            matrix[i] = [0]*(amount+1)
        for i in range(1,amount+1):
            matrix[0][i] = float('inf')
        for i in range(1, len(matrix)):
            for j in range(1, amount+1):
                if(j<coins[i-1]):
                    matrix[i][j] = matrix[i-1][j]
                else:
                    matrix[i][j] = min(matrix[i-1][j], 1+matrix[i][j-coins[i-1]])
        ans = matrix[len(coins)][amount]
        if(ans==float('inf')):
            return -1
        return ans
        
        