class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
#         #recursion>>TLE
#         #base
#         if not nums:
#             return 0
        
#         def helper(nums,index,maxsum):
#             #since in case2, we are doing index+2>>s index can go beyound length as well
#             #bound it and return answer at that moment
#             if index>=len(nums):
#                 return maxsum
#             #skip house>>free to count next house>>no change in sum
#             case1=helper(nums,index+1,maxsum)
#             #take house>>need to select next alternate house>>add that house value to                   currentsum
#             case2=helper(nums,index+2,maxsum+nums[index])
#             #return max from these cases
#             return max(case1,case2)
#         #calling helper function
#         return helper(nums,0,0)
    
    
#     DP
#     O(N)
#     O(1) #just using two variables to store variables at each stage no need to maintaining array
        if not nums:
            return 0
        skip=0
        take=0
        for i in range(len(nums)):
            #maintain prev robbed house value
            prevskip=skip
            #maximise value
            skip=max(skip,take)
            #if taking current house, add previous robber house value that was not adjacent and add current rob house value
            take=nums[i]+prevskip
        
        return (max(skip,take))
            