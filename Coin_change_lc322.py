"""
Name: Srinidhi Bhat
Time Complexity - O(n) 
Space COmplexity - O(3^n)- Every Node will have 3 paths further 

Did it run on Leetcode - TLE - time limit exceed
Logic -
1. For every coin, when choose the coin and subtract the denomination from total
When choosing the coin, increase the total by 1 coin, if the coin in choosen
"""
class Solution:
    def getMinCoins(self,coins,amount):
        minCoins = float('inf')
        if amount <0:
            return 0
        for c in coins:
            if amount-c<0:
                break
            numCoins = self.getMinCoins(coins,amount-c)+1
            minCoins = min(minCoins,numCoins)
        
        return minCoins
        
    def coinChange(self, coins: List[int], amount: int) -> int:
        coins.sort()
        minCoins = 0
        minCoins == self.getMinCoins(coins,amount)
        
        if minCoins == float("inf"):
            return -1
        
        return minCoins