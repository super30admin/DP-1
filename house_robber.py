#Tume complexity: O(n): where n: # of houses
#Space complexity: O(n)
#Worked on leetcode
#This algorithm uses dynamic programming, by first calculating the optimal value when
# a house is not chosen, versus when a house is chosen, for each house iteratively.
# It then takes the maximum value of when all houses are covered, and we decide whether
# or not to choose it.

class Solution:
    def rob(self, nums: List[int]) -> int:

        if nums == [] or len(nums) == 0:
            return 0

        dp = [[0 for _ in range(2)] for _ in range(len(nums))]

        dp[0][0] = nums[0]  # money for 1st house

        for house_idx in range(1, len(nums)):
            dp[house_idx][0] = dp[house_idx - 1][1] + nums[house_idx]  # choose current house
            dp[house_idx][1] = max(dp[house_idx - 1][0], dp[house_idx - 1][1])  # don't choose current house

        result = max(dp[len(nums) - 1])  # max of last row

        return result



