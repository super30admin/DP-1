# // Time Complexity :O(amount*number of coins)
# // Space Complexity :O(amount)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach
from typing import List
from functools import lru_cache
import math
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        @lru_cache(None)
        def dp(amount):
            if amount == 0:
                return 0
            
            ans = math.inf
            for coin in coins:
                if amount >= coin:
                    ans = min(ans, dp(amount - coin) + 1)
            return ans
        
        ans = dp(amount)
        return -1 if ans == math.inf else ans


solution = Solution()
print(solution.coinChange([2],3))