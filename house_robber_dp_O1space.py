# Time Complexity : O(n) where is n is number of houses
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0: return 0
        if len(nums) < 2: return nums[0]
        
        notChoose = nums[0]
        choose = nums[1]
        
        for i in range(2, len(nums)):
            tempChoose = choose
            choose = max(tempChoose, notChoose + nums[i])
            notChoose = max(tempChoose, notChoose)
            
        return max(choose, notChoose)