// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :
    # Brute force solution is missing some test cases. Wasn't able to find dynamic algorithm.


// Your code here along with comments explaining your approach
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # Sorting the coins from max to min order
        sortedCoins = sorted(coins, reverse = True)
        remained = amount
        minCoins = 0
        # if amount is zero returning 0
        if amount == 0 :
            return 0
        for i in range(len(sortedCoins)):
            # checking if from the coin itself we can create the amount. If its true returning past mincoins and current calculated coin.
            if remained % sortedCoins[i] == 0:
                return minCoins + ( remained // sortedCoins[i] )
            
            # Skipping the coin if coin is biggere than remained amount.
            if sortedCoins[i] > remained:
                continue
            else:
                # If remained and coin value is same returning min coins + 1 coin.
                if remained == sortedCoins[i]:
                    minCoins += 1
                    return minCoins
                # updating mincoins and remaining amount
                minCoins += remained // sortedCoins[i]
                remained = remained % sortedCoins[i]
                
        return -1
    # This approach does not work when amount is possible with combination of smaller coin.
                
                