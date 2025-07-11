# TimeCompledxity:O(amount)
# SpaceCompleity:O(amount)
# Approach:
# Try greedy it fails([1,2,6,4,7] with greeedy 1+2+7)
# Exaushite approach: Try all combinations by picking and not picking O(pow(2,m+n))
# DP:if you see ecautive tree there are multiple repeated sub problmes
#   dp[x] = min(dp[x], dp[x - coin] + 1)
#   min of not picking coin or picking coin and number of summ of number of coins remeaning



class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # dp[i] min coins we useed to make i
        #
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        for coin in coins:
            # try to use differ coin to get result
            for x in range(coin, amount + 1):
                
        return dp[amount] if dp[amount] != float('inf') else -1


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        #recursive exaushtive approach with time complexity 2**(m+n) why consider elcoins to have 1 as fisrsty coinn youm pick untill uyou hit tagert and then dont pick eahc andd every other element

        def helper(idx, coins, amount):
            #base
            #changing elements idx and amount
            if amount==0:return 0
            if amount<0 or idx>=len(coins):return  2**31 - 10


            #logic
            #pick
            p=helper(idx,coins,amount-coins[idx])+1
            #notPick
            np=helper(idx+1,coins,amount)
            return min(p,np)
        ans=helper(0,coins,amount)
        if ans==2**31 - 10:
            return -1
        return ans
