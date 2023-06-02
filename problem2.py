#Time complexity is: O(n)
#Space Complexity is: O(n)
#Code ran successfully on leetcode
#Faced no problems while coding this

#House robber problem
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #If the length of the nums is less than 2, we return nums[0]
        if(len(nums)<2):
            return nums[0]
        #creating a dp array with 0 as initial values
        self.dp=[0 for i in range(len(nums))]
        #Assigning the first value to nums[0]
        self.dp[0]=nums[0]
        #Here we are assigning the dp[1] with max of first and second values in nums[1]
        self.dp[1]=max(self.dp[0],nums[1])
        #Looping throught he other values in the nums array
        for i in range(2,len(nums)):
            #Here we are going to take the max of the previous and nums[i]+dp[i-2]
            self.dp[i]=max(self.dp[i-1],self.dp[i-2]+nums[i])
        #FInally we are returning the top value in the dp
        return self.dp.pop()

