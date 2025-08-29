"""
TC: O(N) {we only iterate through the len of nums}
SC: O(1) {No extra space was used}

Approach:

We need to look previous for upto two places, hence we initialize the vars prev1 and prev2.
Then we iterate throught the nums array and for each house, we take max of the amount if we rob the hous two blocks away and the curr house
or just the curr house

Finally at the end, we would have the total amount in the var prev1

The problem ran successfully on Leetcode.
"""

from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        prev1, prev2 = 0, 0

        for each in nums:
            temp = max(prev2+each, prev1)
            prev2 = prev1
            prev1 = temp
        
        return prev1
        

