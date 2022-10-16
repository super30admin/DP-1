# Sometime's it give's TLE but it works.
# Would be a great help if you can help me implementing the same code using a 2d array. Tried pinging in the slack group but no one responded back

# Time: O(mn)
# Space: O(mn)

class Solution:
    dp=dict(list())
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        self.dp=dict(list())
        
        ans=self.coinChangeRecur(coins,0,amount)
        if ans==math.inf:
            return -1
        else:
            return ans
        
    def coinChangeRecur(self,coins, index, amount):
        
        #base
        #valid
        if (amount==0):
            return 0
        
        #invalid
        if amount < 0 or index==len(coins):
            return math.inf
        
        #recurse
        #Select
        
        if (index,amount) not in self.dp.keys():
            
            select=self.coinChangeRecur(coins,index,amount-coins[index])
            if select is not math.inf:
                select+=1

            #notselect

            notSelect=self.coinChangeRecur(coins,index+1,amount)
            
            self.dp[(index,amount)]=min(select,notSelect)
        
        return self.dp[(index,amount)]