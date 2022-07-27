# Time Complexity : O(nm) where n is the length of the list coins adn m is the amount
# Space Complexity :O(mn) auxiliary space needed for the 2D DP matrix table 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not amount:
            return 0
        opt = [[None for _ in range(amount+1)] for _ in range(len(coins)+1)]
        opt[0][0] = 0
        for j in range(1,len(opt[0])):
            opt[0][j] = amount+1
        # print(opt)    
        for i in range(1,len(opt)):
            for j in range(len(opt[0])):
                # For all cases when j is less than coins[i-1] (we give coins[i-1] b ecause we added an extra row for coins of denomination 0, copy corresponding value from the previous row
                if j < coins[i-1]:
                    opt[i][j] = opt[i-1][j] # Copy previous row value exactly above the current element if j < coins[i-1]
                else:
                    # print(coins[i],j,opt)
                    opt[i][j] = min(opt[i-1][j], 1 + opt[i][j-coins[i-1]]) # Otherwise, select the min of the element just above the current element (when we don't select current) coin and 1+ opt[i][j-coins[i-1]] which mean we selected the current coin and we reduce the amount from j to j - coins[i-1] (i-1 because we start from 0 denomination as mentioned earlier)
        # print(opt)
        if opt[len(coins)][amount]>amount:
            return -1
        return opt[len(coins)][amount]