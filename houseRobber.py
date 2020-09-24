"""
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        prev, curr = 0, 0
        
        for n in nums:
            temp = max(n + prev, curr)
            prev = curr
            curr = temp
        return curr