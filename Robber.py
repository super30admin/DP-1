// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def rob(self, nums: List[int]) -> int:
            c=0 #choose
            dc=0 #dont choose
            for i in range(len(nums)):
                temp=dc #store previous dc value to keep track of dc
                dc=max(c,dc) # find maximum between dc and c
                c=temp+nums[i]
            return max(c,dc) # return max between c and dc as we keep calculating