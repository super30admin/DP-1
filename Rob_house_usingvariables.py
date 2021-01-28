# Time complexity: O(n*m) = O(n)
# Space complexity: O(1)
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        c = 0
        dc = 0
        
        # traverse the list
        for i in nums:
            # keep prev value of dc in temp
            temp = dc
            # update dc value with max of both c and dc value
            dc = max(c, dc)
            # update c with (i + temp)
            c = i + temp
            
        
        # return the max of last C and DC values
        return max(c, dc)