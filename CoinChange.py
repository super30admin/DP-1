# Time Complexity : It is O(m*n) looping through matrix of m*n.
# Space Complexity : Creating the matrix of O(m*n) to have all the possibilities of coint to make an amount
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

from typing import List
import numpy as np

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
              
        coinAmountMap = np.full([len(coins) + 1, amount + 1], 0)
        for i in range(amount +1):
            coinAmountMap[0][i] = 99999
        
        for row in range(1,len(coins)+1,1):
            for col in range(1,amount+1,1):
                if coins[row-1] == col:
                    coinAmountMap[row][col]=1
                elif col < coins[row-1]:
                    coinAmountMap[row][col]=coinAmountMap[row-1][col]
                else:
                    coinAmountMap[row][col]= min(coinAmountMap[row-1][col],1+coinAmountMap[row][col-coins[row-1]])
                
        if coinAmountMap[len(coins),amount] ==   99999:
            return -1
        else:
            return coinAmountMap[len(coins),amount]
           
        
        

obj = Solution();

#print(obj.coinChange([2],3))
print(obj.coinChange([1,2,5],11))
#print(obj.coinChange([1],0))