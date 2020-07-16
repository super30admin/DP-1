#// Time Complexity : O(mn) where m is length of the array and n is the amount.
#// Space Complexity : O(mn) where m is length of the array and n is the amount.
#// Did this code successfully run on Leetcode : Yes
#// Any problem you faced while coding this :No


#// Your code here along with comments explaining your approach
#we approach the below problem by looking into the common sub problems for every iteration.we have coin denomination on the row wise and #amount on the column wise.we start by taking the first row for denomination of 0.As for amount values greater than 0 we take it as #infinity as no number of zero coins can equate to any number.This is take as the base case.As for every iteration we have two ways i.e #by either choosing or not choosing the coin.so that is the reason we go with two dimensional array to solve this problem.we fill the #cells of this array by taking the minimum between the case of choosing either choosing or not choosing the coins.


class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        c=float('inf')
        out=[[None for i in range(amount+1)] for j in range(len(coins)+1)]
        for i in range(amount+1):
            if i==0:
                out[0][i]=0
            else:
                out[0][i]=c
        for i in range(1,len(coins)+1):
            for j in range(amount+1):
                if j<coins[i-1]:
                    out[i][j]=out[i-1][j]
                else:
                    out[i][j]=min(out[i-1][j],(out[i][j-coins[i-1]])+1)
        if out[len(coins)][amount]==float('inf'):
            return -1
        else:
            return out[len(coins)][amount]
        