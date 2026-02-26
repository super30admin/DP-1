class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0

        #in case of just 2 houses, rob the max one.
        if len(nums) == 2:
            return max(nums)

        #Let us have 2 variables, choose, not choose.
        c,nc = nums[0],0

        for i in range(1,len(nums)):
            tempC = c #Need to store choose in a temp variable as we are going to modify it below.

            #If we plan to choose the current number, then we can't choose the previous one.
            c = nums[i] + nc

            #if we do not choose the current number, then simply choose the max of the prev iteration.
            nc = max(tempC, nc)

        return max(c,nc)

# TC : O(n)
# SC : O(1)