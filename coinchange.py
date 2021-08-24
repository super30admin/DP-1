# Time Complexity : 
# Space Complexity : 
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : I am not getting the logic for all test cases`~


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        if len(coins) == 1 and coins[0] < amount:
            return -1
        
        
        return -1