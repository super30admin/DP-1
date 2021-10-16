

#Time Complexity : O(mn) where m is len(coins) and n is amount
#Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0 or amount == 0:
            return 0
        mat = [0]*(amount+1)
        for i in range(amount+1):
            if i == 0:
                mat[i] = i
            else:
                mat[i] = math.inf
        
        for i in range(len(coins)):
            for j in range(amount+1):
                if j>=coins[i]:
                    mat[j] = min(mat[j], 1+mat[j-coins[i]])
        if mat[-1] == math.inf:
            return -1
        else:
            return mat[-1]
        