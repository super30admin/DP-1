'''

## Problem 198: House Robber

## Author: Neha Doiphode
## Date:   07-06-2022

## Description:
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.


## Approach:

    Input: [2, 7, 9, 8, 1, 1, 5]

            0                         1   (don't choose or choose)

    2       0                         2
    7    max(0, 2)                Input[(0, 1)] = 0 + 7 (since we can not choose adjecent houses)
    9    max[(7, 0), (7, 1)]      Input[(2, 1)] = 2 + 9 (since we can not choose adjecent houses)
    8      7                          7 + 8
    1      15                         11 + 1
    1      15                         15 + 1
    5      16                         15 + 5

## Examples:
    Example 1:
        Input: nums = [1,2,3,1]
        Output: 4
        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
        Total amount you can rob = 1 + 3 = 4.

    Example 2:
        Input: nums = [2,7,9,3,1]
        Output: 12
        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
        Total amount you can rob = 2 + 9 + 1 = 12.

    Example 3:
        Input: nums = [1, 1]
        Output: 1

    Example 4:
        Input: nums = [1, 3, 1]
        Output: 3

    Example 5:
        Input: nums = [1, 1, 1]
        Output: 2

## Constraints:
    1 <= nums.length <= 100
    0 <= nums[i] <= 400

## Time complexity: O(n), where n is number of houses.

## Space complexity: O(n), where n is number of houses.
                            Note: Can be optimized it further to just store previous iteration results instead of whole array.
                            Improves to O(1).

'''

from typing import List

def get_input():
    print("Enter the list of houses with respective amounts stashed(with spaces): ", end = "")
    inp_list = input()
    inp_list = [int(value) for value in inp_list.split()]
    return inp_list

class Solution:
    def rob(self, nums: List[int]) -> int:
        skip = 0
        take = nums[0]

        for row in range(1, len(nums)):

            # Store initial
            previous_skip = skip
            skip = max(skip, take)
            take = previous_skip + nums[row]

        return max(skip, take)

# Driver code
solution = Solution()
inp_list = get_input()
print(f"Input list of houses: {inp_list}")
print(f"Dynamic programming: Maximum amount of money that can be robbed: {solution.rob(inp_list)}")
