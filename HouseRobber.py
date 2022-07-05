// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution:
    def rob(self, nums: list[int]) -> int:
        rob1, rob2 = 0, 0

        # [rob1, rob2, n, n+1,....]
        for n in nums:
            temp = max(n + rob1, rob2)
            rob1 = rob2
            rob2 = temp

        return rob2