# Time Complexity : O(m * n) m = no.of coins , n = amount
# Space Complexity : O(m * n) m = no.of coins , n = amount
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = [[float('inf')] * (amount+1) for _ in range(len(coins)+1)]
        
        for i in range(1,len(coins)+1):
            for j in range(amount+1):
                if j == 0:
                    m[i][j] = 0
                else:
                    if coins[i-1] <= j:
                        m[i][j] = min(m[i-1][j], m[i][j-coins[i-1]] + 1)
                    else:
                        m[i][j] = m[i-1][j]
        
        return m[-1][-1] if m[-1][-1] != float('inf') else -1