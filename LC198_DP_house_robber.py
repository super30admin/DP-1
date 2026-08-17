#  Time Complexity : O(n)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : yes
#  Any problem you faced while coding this : No

# Approach: built a dp[i] as the minimum coins needed to make amount i, checking every coin for each amount


def rob(nums: list[int]) -> int:
    n = len(nums)
    if n == 1:
        return nums[0]
    prev = nums[0]
    curr = max(nums[0], nums[1])

    for i in range(2, n):
        temp = curr
        curr = max(temp, nums[i] + prev)
        prev = temp

    return curr
