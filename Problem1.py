#Time Complexity : O(m*n)
#Space Complexity : O(amount)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = amount + 1
        m = len(coins) + 1
        mat = [amount + 1] * (n)
        mat[0] = 0
        
        for i in range(0,len(coins)):
            for j in range(coins[i],len(mat)):
                mat[j] = min(mat[j],mat[j-coins[i]] + 1)
        
        if mat[-1] == amount + 1:
            return -1
        else:
            return mat[-1]
        