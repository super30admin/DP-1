import sys
from typing import List
#Time Complexity : O(m*n), where m is number of elements in the coins,n is target
#Space Complexity : O(m*n), where m is number of elements in the coins,n is target
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Nothing specific

class Solution:
        
        
    def actualsol(self,ind: int,coins: List[int],target: int, memo)->int:
        #Base Cases of recursion 
        if(ind==len(coins)):
            if(target==0):
                return 0
            if(target!=0):
                #This combination is not possible
                return sys.maxsize
        if(target<0):
            return sys.maxsize
        
        if memo[ind][target] != None:
            return memo[ind][target]
        
        #Actual logic apart from base case
        #This is including the coin at that index
        l = 1 + self.actualsol(ind,coins,target-coins[ind], memo)
        #This is not including the coin at that index
        r=self.actualsol(ind+1,coins,target, memo)
        memo[ind][target] = min(l,r)
        return memo[ind][target]
    
    
    def coinChange(self, coins: List[int], amount: int) -> int:
        if(len(coins)==0 ):
            #Here there is no coins denomination
            #This is default case where there is no combination possible
            return -1
        elif(amount<0):
            #Here the given amount is negative
            #This is default case where there is no combination possible
            return -1
        else:
            memo=[[None for i in range(amount+1)] for j in range(len(coins)+1)]
            ans=self.actualsol(0,coins,amount, memo)
            # print(memo)
            if(ans>=sys.maxsize):
                return -1
            else:
                return ans
        
        