# Take a 1D array DP upto the length of amount+1 and assign it to infinity. Assign the first element to 0.
# For each coin in coins, and each amount from 1 to amount, if the coins are lesser than or qual to the amount,
# then update the index with the minimun of the current index or the element at the i-denomination index +1.
# At last, return -1 if the element is greater than the amount else return the element at the last column.

# Time complexity: O(n*m) n= number of coins, m = amount
# Space complexity: O(m), m = amount




class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        rows = len(coins)+1
        cols = amount+1
        dp=[None for i in range(cols)]
        dp[0]=0
        for i in range(1,cols):
            dp[i]=float('inf')
       
        for i,c in enumerate(coins):
            for j in range(1,cols):
                if c<=j:
                    dp[j]=min(dp[j],dp[j-c]+1)
        if dp[cols-1] >amount:
            return -1
        else:
            return dp[cols-1]
