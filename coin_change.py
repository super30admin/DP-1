# Time Complexity:- O(amount*c) amount is the amount given to us that we have to make,c=no. of different denominations of coins we have
# Space Complexity:- O(amount*c) extra space we create for the memoization table
# Approach:- At every point in the algorith we have two choices we can take a coin of the same denomination or
# we can take a coin of different denomination. The problem is to see if we can build the amount using the coins we have
# and optimization the problem asks us to make is the minimum no. of change needed to make that amount.
# Base Case:- We start building our amt and it reaches amount this is a valid base case and we have to count the number of
# changes that gave this solution, Invalid base cases:- our amt exceeds amount or we dont have any coins to use we cant make the amount in these cases we should not include the change needed in this case.
import sys

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        #lru_cache inbuilt memoization
        @lru_cache(maxsize=None)
        def cc(amt,i):
            #Invalid Base Case
            if i==len(coins):
                return sys.maxsize
            #Valid Base Case- Count the change that led to this solution
            if amt==amount:
                return 0
            taken=sys.maxsize
            if amt<=amount:
                #Include a coin of the same denomination
                taken=1+cc(amt+coins[i],i)
            #Include a coin of different denomination and take the min of the previous solution
            return min(taken,cc(amt,i+1))
        res=cc(0,0)
        if res==sys.maxsize:
            return -1
        return res
        
        #Recursive+Tabulation
        self.memo=[]
        for i in range(len(coins)):
            self.memo.append([-1]*(amount+1))
        def cc(amt,i):
            if i==len(coins) or amt>amount:
                return sys.maxsize
            if amt==amount:
                return 0
            if self.memo[i][amt]==-1:
                self.memo[i][amt] = min(1+cc(amt+coins[i],i),cc(amt,i+1))
                return self.memo[i][amt]
            return self.memo[i][amt]
        res=cc(0,0)
        if res==sys.maxsize:
            return -1
        return res
            
    