# from subprocess import REALTIME_PRIORITY_CLASS
# from typing import List
# from unittest import result
# LC: yes
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # TC: O(2^n+m)
        # SC: O(n+m)
        # if not coins: return -1
        # result = 0
        def helper(coins, amount, index, coinsUsed):
            if amount == 0: return coinsUsed
            if amount < 0 or index == len(coins): return -1
            # choose
            case1 = helper(coins, amount-coins[index], index, coinsUsed+1)
            # not choose
            case2 = helper(coins, amount, index+1, coinsUsed)
            # if case1 and case2:
            if case1 == -1: return case2
            if case2 == -1: return case1
            # elif case1 == -1 and case2 == -1: return
            else: return min(case1, case2)
            
        return helper(coins, amount, 0, 0)

# sol = Solution()
# print(sol.coinChange([1,2,5],11))

# TC: mxn 
# SC: mxn
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = amount + 1
        n = len(coins) + 1
        table = [[0 for i in range(m)] for i in range(n)]
        for i in range(m):
            table[0][i] = amount + 1
        for i in range(1,len(table)):
            for j in range(1, len(table[0])):
                # if the current amount is less than the current coin take values from above
                if not (j >= coins[i-1]):
                    # print(True)
                    table[i][j] = table[i-1][j]
                else:
                    # choose or not choose the current coin
                    table[i][j] =  min(table[i-1][j], 1 +  table[i][j-coins[i-1]])
        print(table)
        return table[-1][-1] if table[-1][-1] != (amount+1) else -1
    
# TC: mxn (m is columns and n is number of coins)
# SC: m
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = amount + 1
        n = len(coins) + 1
        table = [amount + 1] * (amount + 1)
        for i in range(len(table)):
            for c in coins:
                if i >= c:
                    table[i] = min(table[i], table[i - c])
        return table[-1] if table[-1] != (amount +1) else -1      