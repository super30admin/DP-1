# Time limit exceeded in leetcode
# time complexity - O(2^n)
# Simple brute force approach using recursion tree.

def rob(nums):
    return helper(nums, 0, 0)


def helper( nums, i, amount):
    # Base case
    if i >= len(nums): return amount
    # case1 choose house
    case1 = helper(nums, i + 2, amount + nums[i])
    # case2 don't choose house
    case2 = helper(nums, i + 1, amount)
    return max(case1, case2)

print(rob([2,1,1,2]))