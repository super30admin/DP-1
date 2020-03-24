"""
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach
Algorithm explanation
1) The core idea of the approach is that we have to take a decision 
whether or not we use the current state and since we need to select alternative 
values, we use two pointers prev1 and prev2 to keep track of the total amount robbed
2) Initiate prev1=0,prev2=0
3) Iterate over the nums
    - Update temp = prev1
    - Update prev1 = max(prev2 + current amount, prev1(prev_amt))
    - Update prev2 = temp
4) Return prev1
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        """
        [2,7,9,3,1] 
        prev1 = 0, prev2 = 0
        temp = 0, prev1 = max(0 + 2,0)  = 2, prev2 = 0
        temp = 2, prev1 = max(0 + 7, 2) = 7, prev2 = 2
        temp = 7, prev1 = max(2 + 11,7) = 13, prev2 = 7
        """
        prev1,prev2 = 0,0
        for i in nums:
            temp = prev1
            prev1 = max(prev2+i,prev1)
            prev2 = temp
        return prev1