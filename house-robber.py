'''
Approach:
1. Use dynamic programming to track the maximum amount that can be robbed up to each house.
2. Maintain two variables `rob1` and `rob2` to store the maximum money robbed if the current house is not robbed and if it is robbed, respectively.
3. Iterate through the list, updating the variables to reflect the best options at each step.
'''

# Time Complexity: O(n) where n is the number of houses (elements in the list)
# Space Complexity: O(1) since only two variables are used for tracking the state

from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        rob1, rob2 = 0, 0
        for n in nums:
            temp = max(n + rob1, rob2)
            rob1 = rob2
            rob2 = temp
        return rob2