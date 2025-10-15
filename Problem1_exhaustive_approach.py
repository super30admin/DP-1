#Naive approach solution: Time complexity 0(2^n*m where n is number of coins and m is amount)
import sys
class Solution(object):
    def coinChange(self, coins, amount):
        """
        The exhaustive approach takes the smallest depth of binary tree created as min number of coins to give the amount
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        re = self.helper(coins, amount, 0)
        #coins = [2], amount = 3 you can make any amount give here, 
        # if ive gone out of bounds  
        if re >= sys.maxsize:
            return -1
        return re
    
    def helper(self, coins, amount, idx):
        #base case
        if (amount==0):
            return 0
        #the amount becomes negative — this path is invalid
        if amount < 0 or idx == len(coins):
            return sys.maxsize

        #logic
        #case 1 - dont choose
        case1 = self.helper(coins, amount, idx+1)
        #case2 - choose
        #add +1 because I just chose that one coin in the current index
        case2 = 1 + self.helper(coins, amount-coins[idx], idx)

        return min(case1, case2)