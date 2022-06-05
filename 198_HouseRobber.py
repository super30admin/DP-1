"""
Leetcode - https://leetcode.com/problems/house-robber (submitted)
TC- O(N), SC - 0(1)
Lecture- https://youtu.be/M5Gu3a1Ta4Q
FAQ -
What if you don't know the decision for each house you chose?
Make 1-D array that has max reward for each house and also the index of which max you choose, then iterate through those
index to find the path (choice path in this scenario) you took.

Why do we go to pre and pre-previous if we don't choose them in our most profitable path?
Pre and pre-precious will always account for if they included themselves or not, so even if they didn't include
themselves, they still be able to tell ourselves the max reward up to that point.


You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can
rob tonight without alerting the police.

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

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 400
"""

'''
Idea - Dynamic programming

Once we figure out repition in the exhausted tree (possible cases), we can start thinking of solution for the simplest
problem in DP. 

Consider our input is - [6, 9, 8, 1]

Our bottom up DP will build up right to left, [1, 8, 9, 6], our simplest problem will be - maxReward([6]) = 6,
and maxReward([6,9]) = max(6,9).
Now, maxReward([6,9,8]) = max(maxReward([6,9]) = max(6,9), maxReward([6]) + 8), '8' is the cost for that house

So generalizing it DP[i] = max(previous, pre-previous + cost).

You can approach this by keep track of the whole 1-D DP array instead of just previous and pre-previous, but this is
more optimized in space.
'''
class Solution:
    def rob(self, nums):
        if len(nums) == 1:
            return nums[0]
        prePrevious = nums[0]
        previous = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            curr = max(previous, prePrevious + nums[i])
            prePrevious = previous
            previous = curr

        return previous
