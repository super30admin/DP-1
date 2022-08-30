'''
322. Coin Change

TIME COMPLEXITY: O(M+N)
SPACE COMPLEXITY: O(N) where N = amount
LEETCODE: Yes
DIFFICULTIES: None
'''


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)
        c = amount + 1
        r = n + 1
        
        m = [[0 for i in range(0,c)] for j in range(0,r)]
        
        for i in range(0,r):
            m[i][0] = 0 
        
        for j in range(0, c):
            m[0][j] = amount + 1
        
        
        for i in range(1,r):
            for j in range(1,c):
                taken = m[i-1][j]
                
                not_taken = amount + 1
                if j - coins[i-1] >= 0:
                    not_taken = 1 + m[i][j - coins[i-1]]
                
                m[i][j] = min(taken, not_taken)           
        
        if m[r-1][c-1] > amount:
            return -1
        return m[r-1][c-1]
        
