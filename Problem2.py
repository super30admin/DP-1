#     // Time Complexity : O(n) where n is the number of houses
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
class Problem2(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # the possibility combinations are start with index 0 next it can be any house except 1st index
        # lets say we have [5,2,3,18,2] if start with 5 then 5+3+2 or 5+18 this is max 
        # the trick part is to indetify from which index to start and which index to skip 
        # we have to exhaustivly check every possiblities with a condition if selected x index we cannot select the x+1 index later
        # check the max amount at every house if seleted this house what's the max, if not selected this house what's the max 
        # if selected house 5 the max amount earned is 5, if selected 2 the max earnings here is 2 as we cannot rob house with 5
        # if selected 3 the max earnings is 3 + 2 steps back 5 3+5 8 , if not selected is previous house 2 so max of 8,2 its 2 so we select this house 
        # to generalize, if select the house the coniditon will be earnings[i] = earn[thishouse] + earnings[i-2] if not selected the earnings[i] = earnings[i-1]
        # check the max of these two cases and update the earnings array
        # we don't need to store the whole earnings array from start of the house, we just need the prev two houses earnings to calculate the next 

        n = len(nums)
        if n == 0:
            return 0
        if n == 1:              # only one house
            return nums[0]

        prev = nums[0]
        curr = max(nums[0], nums[1])

        for i in range(2,len(nums)):
            temp = curr
            case1 = curr
            case2 = nums[i] + prev

            curr = max(case1,case2)
            prev = temp
            # print(case1,case2, curr)

        return curr 
