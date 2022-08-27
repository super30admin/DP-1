"""
Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Complexity Analysis:
    Recursive: 
        Time Complexity: O(2^n)
        Space Complexity: O(1)
        
    DP:
        Time Complexity: O(n)
        Space Complexity: O(n)
        
    DP optimized:
        Time Complexity: O(n)
        Space Complexity: O(1)
"""


def rob_recursive(nums):
    def helper(nums, amount, i):
        # base
        if i >= len(nums):
            return amount

        # recursive
        choose = helper(nums, amount + nums[i], i + 2)
        not_choose = helper(nums, amount, i + 1)

        return max(choose, not_choose)

    if not nums or len(nums) == 0:
        return 0

    if len(nums) == 1:
        return nums[0]

    amount, i = 0, 0
    return helper(nums, amount, i)


def rob_dp(nums):
    if not nums or len(nums) == 0:
        return 0

    if len(nums) == 1:
        return nums[0]

    n = len(nums)
    dp = [0] * n
    dp[0], dp[1] = nums[0], max(nums[0], nums[1])
    for i in range(2, n):
        dp[i] = max(dp[i-1], dp[i-2] + nums[i])

    return dp[-1]


def rob_opt(nums):
    if not nums or len(nums) == 0:
        return 0

    if len(nums) == 1:
        return nums[0]

    val1, val2 = nums[0], nums[1]
    for i in range(2, len(nums)):
        temp = max(val2, nums[i] + val1)
        val1 = val2
        val2 = temp

    return val2


nums = [1, 2, 3, 1]
print(rob_recursive(nums))
print(rob_dp(nums))
print(rob_opt(nums))
