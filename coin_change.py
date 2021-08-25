# Did this code successfully run on Leetcode : YES

# TC: O(c*a) where c is the number of different denominations of coins, a is the amount
# SC: O(a)

# approach
# initialise array of size (amount+1) with initial values (amount+1), even math.inf is fine
# for each number in range of amount -> i.e. 0 -> a, check where all we can land with adding each denomination
# base case: shortest[0] = 0 since by selecting 0 coins we can land at 0
# let coins = [1, 2, 5] and amount = 7
# from 0 we can land at 1, 2, 5
# from 1 we can land at 2, 3, 6
# and so on
# at each 'landing', we update shortest[landing] by current 'path' length
# from 0 I can land at 1 using 1 coin, at 2 using 1 coin, at 5 using 1 coin
# from 1 I can land at 2 using shortest[1]+1 = 2 coins, but we were able to land at 2 using one coin previously hence shortest path taken

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        shortest = [amount+1]*(amount+1)
        # for c in coins:
        #     shortest[c] = 1
        shortest[0] = 0
        for total in range(len(shortest)):
            for coin in coins:
                if total + coin <= amount:
                    # print((total, coin))
                    shortest[total+coin] = min(shortest[total+coin], shortest[total]+1)
        # print(shortest)
        if shortest[-1] == amount+1:
            return -1
        return shortest[-1]