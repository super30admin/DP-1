class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        ## N = len(coins)
        ## M = Amount
        ## time complexity = O(NxM)
        ## space complexity = O(NxM)
        
        mat = [[0]*(amount+1) for i in range(len(coins)+1)]
        
        for i in range(len(mat[0])):
            if i == 0 :
                mat[0][i] = 0
            else:
                mat[0][i] = amount + 1
        
        coins.insert(0,0)
        for i in range(1, len(coins)):
            for j in range(1, len(mat[i])):
                if j >= coins[i]:
                    mat[i][j] = min(mat[i-1][j], 1 + mat[i][j - coins[i]])
                else:
                    mat[i][j] = mat[i-1][j]

        
        if mat[len(coins)-1][amount] == amount + 1:
            return -1
        return mat[len(coins)-1][amount]
        