#// Time Complexity : O(n) 
#// Space Complexity : O(n)
#// Did this code successfully run on Leetcode : Yes
#// Any problem you faced while coding this :No


#// Your code here along with comments explaining your approach
#we approach the below problem by looking into the common sub problems for every iteration.we have houses on the row wise and decision to rob the house(0 or 1) on the column wise.RObber can make a decision to rob a particular house i.e if he wants to rob that house he should not rob the adjacent house or else he should leave that particular house and go to the next house.The maximum value in these both scnearios will give the maximum amount of money that robber can rob from the houses without being alerted.

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0:
            return 0
        out=[[None,None] for i in range(len(nums))]
        for i in range(len(nums)):
            if i==0:
                out[i][0]=0
                out[i][1]=nums[i]
            else:
                out[i][0]= max(out[i-1][0],out[i-1][1])
                out[i][1]= out[i-1][0]+nums[i]
        return max(out[len(nums)-1][0],out[len(nums)-1][1])
        