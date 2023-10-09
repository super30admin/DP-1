# linear time and contant space complexity
class Solution:
    def rob(self, nums: List[int]) -> int:
        rob1 = 0
        rob2 = 0
        
        for n in nums:
            temp = max(rob1+n,rob2)
            rob1 = rob2
            rob2 = temp
        return temp