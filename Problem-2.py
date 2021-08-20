# House Robber

# Time Complexity : O(N), N: length of nums i.e. number of houses
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
def rob(self, nums: List[int]) -> int:

    # `dp` array at index `i` maintains the most profit achieved so far for house `i+1`
    dp = [0 for _ in range(len(nums)+1)]
    dp[1] = nums[0]

    for i in range(2, len(nums)+1):

        # The profit would be a max of previous house (without the current house), and one before the adjacent + current house
        dp[i] = max(dp[i-1], dp[i-2] + nums[i-1])

    return dp[-1]