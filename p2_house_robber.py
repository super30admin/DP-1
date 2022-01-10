"""
// Time Complexity : O(N)  N : number of houses
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

"""

class Solution:
    def rob(self, nums: List[int]) -> int:
        dparr = [[0 for i in range(2)] for j in range(len(nums))]
        dparr[0][1] = nums[0]
        for i in range(1,len(nums)):
            dparr[i][0] = max(dparr[i-1][0], dparr[i-1][1])
            dparr[i][1] = dparr[i-1][0] + nums[i]
        return max(dparr[len(dparr) -1][0],dparr[len(dparr) -1][1])