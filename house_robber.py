"""
Time Complexity: O(n)
Space Complexity: O(1)
Did your code run on leetcode? : yes
issues faced: 
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums == None or len(nums)== 0:return 0
        C,DC,temp= 0,0,0
        for _ in nums:
            temp = DC
            DC = max(C,DC)
            C = _ + temp 
        return max(C,DC)