#time complexity: O(amount*n)
#space complexity: o(amount)
class Solution:
    def coinChange(self, coins, amount: int) -> int:
        lst = [amount+1]*(amount+1)
        lst[0] = 0
        for i in range(1,len(lst)):
            for el in coins:
                if i-el >=0:
                    lst[i] = min(lst[i-el]+1,lst[i])
        if lst[amount] > amount:
            return -1
        return lst[amount]