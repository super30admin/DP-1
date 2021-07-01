#brute force
#time comp-O(n**m) n= len(coins) m=amount/min(coins)
#space- O(1) ? not sure on space complexity
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n=len(coins)
        return self.coin_change(coins,0,amount,0)
        
    def coin_change(self,coins,index,amount,num_of_coins):
        if amount==0:
            return num_of_coins
        if amount<0 or index >= len(coins):
            return -1
        #to choose
        case1=self.coin_change(coins,index,amount-coins[index],num_of_coins+1)
        #to not choose
        case2=self.coin_change(coins,index+1,amount,num_of_coins)
        if case1==-1:
            return case2
        if case2==-1:
            return case1
        return min(case1,case2)
        
        
        
