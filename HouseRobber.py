class Solution:
    """
    Can be solved using DP matrix
    This can be solved using three variables to calcualate the max amount
    """
    def rob(self, nums: List[int]) -> int:
        if nums == [] or nums == None:
            return 0
        C = 0
        DC = 0
        
        for x in nums:
            temp = DC
            DC = max(C, DC)
            C = x + temp
        
        return max(C, DC)