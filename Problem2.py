#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO
class Solution:
    def rob(self, nums: List[int]) -> int:
        keep = 0
        discard = 0
        
        for i in nums:
            temp = discard
            discard = max(discard,keep)
            keep = i + temp
            
        return max(keep,discard)