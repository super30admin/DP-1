'''
The choice of robbing a house or not robbing creates a tree with these 2 branches.
Hence dp is useful by keeping track of choice made for the house before and the best decision to 
get the maximum loot.

Since the houses can be only robbed in a sequence we only need to track the best
decisions for previous house to make the best decision for current house.

Time complexity: O(n)
Space complexity: O(1)
'''
class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [0, 0]

        for house in nums:
            rob = dp[1] + house
            noRob = max(dp[0], dp[1])
            dp = [rob, noRob]

        return max(dp)