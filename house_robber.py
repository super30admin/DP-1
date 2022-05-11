'''
Approach: Following the right to left approach, at end there only 2 options, next house is the last house and next_next is empty set to 0. Now, iterate in reverse and find max of next and next_next + nums[i]. move next_next to next and next to current. when current reaches 0, return rn

Time complexity:O(N)
Space complexity: O(1)

Passes all testcases in leetcode


'''

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0: return 0
        
        rnn = 0
        rn = nums[-1]
        
        for i in range(len(nums)-2,-1,-1):
            curr = max(rn, rnn+nums[i])
            rnn = rn
            rn = curr
        return rn
            
        
