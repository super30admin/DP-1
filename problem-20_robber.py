# Recursive Programming
# 17 cases passed
# time complexity =O(n*2)
#space complexity=O(N)
class Solution(object):
    def rob(self, nums):
        return self.helper_func(nums,0,0)

    def helper_func(self,nums,i,max_amt):
        for i in range(len(nums)):

            #edge case where we have to return
            if (i>=len(nums)) :
                return max_amt
            #choose the house and go in
            case_1 = self.helper_func(nums,i+2,(max_amt+nums[i]))

             #skip the house
            case_2=self.helper_func(nums,i+1,max_amt)

        return max(case_1,case_2)