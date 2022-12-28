# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        min_coin=[amount+1]*(amount+1)
        min_coin[0]=0
        for a in range(1,amount+1):
            for c in coins:
                if(a-c>=0):
                    min_coin[a]=min(min_coin[a],1+min_coin[a-c])
        return min_coin[amount] if (min_coin[amount]!=amount+1) else -1
            