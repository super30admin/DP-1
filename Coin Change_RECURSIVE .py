
# RECURSIVE SOLUTION

# Time Complexity: O(2^n)
# Space Complexity: No Extra Space, Recursive Stack uses O(n)
# Did problem run on Leetcode: yes with TLE 

class Solution:
    def coinChange(self, coins, amount):
        return self.helper(coins,amount,0,0)
    
    def helper(self, coins, amount, index, minn):

        # BASE CASE
        if index > len(coins)-1 or amount < 0:
            return -1
        if amount == 0:          #exit case
            return minn

        # LOGIC
        case1 = self.helper(coins, amount-coins[index], index, minn+1)         # choose coin
        case2 = self.helper(coins, amount, index+1, minn)                      # Not-choose coin

        if case1 == -1:
            return case2
        elif case2 == -1:
            return case1
        else:
            return min(case1,case2)

output = Solution()
print(output.coinChange(coins=[1, 2, 5], amount=11))
