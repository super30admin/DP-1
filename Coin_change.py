# time complexity =O(N^2)
# space complexity=O(N)
#Leetcode submission: Successful
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        #array for containg the final values
        count=[amount+1]*(amount+1)
        count[0]=0
        for v in range(len(count)):
            for c in coins:
                if c <= v:
                    #finding the minimum for current amount with itself and 1 less coin to it
                    count[v]=min(count[v],count[v-c]+1)
        if count[amount]==amount+1:
            return -1
        else:
            return count[amount]