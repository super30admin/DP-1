# Time Complexity : O(N) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I will maintain two variables to keep track of the maximum amount that can be robbed up to the current house.
# At each house, I have two choices: either rob the current house and add its value to the maximum amount from two houses ago,
# or skip the current house and take the maximum amount from the previous house.
# I will update the two variables accordingly as I iterate through the list of house values.

from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        rob1, rob2 = 0, 0

        for n in nums:
            rob1,rob2 = rob2,max(rob2,rob1+n) 
        return rob2
        