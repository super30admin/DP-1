class Solution:
    memoize = dict(list())
    # leetcode URL : https://leetcode.com/problems/coin-change/
    # Problem : 322. Coin Change
    # Time Complexity : O(len(coin)*amount)
    # Space Complexity : O(len(coin)*amount)
    def coinChange(self, coins: List[int], amount: int) -> int:
        self.memoize = dict(list())
        num_coins = self.top_down(coins, 0, amount)
        if num_coins == math.inf:
            return -1
        else:
            return num_coins
        
    def top_down(self,coins, i, amount):
        if amount == 0:
            return 0
        if i==len(coins) or 0>amount:
            return math.inf
        if (coins[i],amount) not in self.memoize.keys() :
            self.memoize[(coins[i],amount)] = min(1+self.top_down(coins,i,amount-coins[i]),self.top_down(coins,i+1,amount))
        
        return self.memoize[(coins[i],amount)]