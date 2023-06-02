#  Time Complexity : O(m*n)
# Space Complexity :O(m*n)
# Leet Code: Yes

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        nCoins = len(coins)
        mat = [[None for _ in range(amount+1)] for _ in range(nCoins+1)]
        
        mat [0][0] = 0
        for i in range(1, amount+1):
            mat[0][i] = 999999
        for i in range(1, nCoins+1):
            mat[i][0] = 0
        
        for i in range(1, nCoins+1):
            for j in range(1, amount+1):
                if coins[i-1] > j:
                    mat[i][j] = mat[i-1][j]
                else:
                    mat[i][j] = min(mat[i-1][j], 1 + mat[i][j-coins[i-1]])
        if mat[nCoins][amount] >= 999999:
            return -1
        return mat[nCoins][amount]