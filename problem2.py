# Time Complexity: O(N * S) where S is the Amount and N is the size of the coin array
# Space Complexity: O(SN) where S is the Amount and N is the size of the coin array
# Passed Leetcode but was slow. Maybe because of the call stack

class Solution:
    
    def recurse(self, arr, amount):
        
        if amount == 0:
            return 0
        if amount < 0:
            return -1
        
        min_coins = -1
        for i in range(len(arr)):
            curr_amount = amount - arr[i]
            
            if curr_amount in self.m:
                coins = self.m[curr_amount]
            else:
                coins = self.recurse(arr, curr_amount)
                if coins == -1:
                    self.m[curr_amount] = -1
                else:
                    coins += 1
                    self.m[curr_amount] = coins
                    
            if coins != -1:
                if min_coins == -1: 
                    min_coins = coins
                else:
                    if coins < min_coins:
                        min_coins = coins
        return min_coins
                    
        
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        
        if len(coins) == 0:
            return -1
        self.m = {}
        return self.recurse(coins, amount)