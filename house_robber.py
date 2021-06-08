class Solution:
    def rob(self, nums: List[int]) -> int:
        
        #base case
        if not nums:
            return 0
        
        length_of_nums = len(nums)

        Rob_neighbor = 0
        Rob_current = nums[length_of_nums -1]

        #Creating the bottom up table

        for i in range(length_of_nums - 2,-1,-1):

            #Recursive call
            current_target = max(Rob_current,Rob_neighbor + nums[i])

            #Swapping the values

            Rob_neighbor = Rob_current
            Rob_current = current_target

        return Rob_current

#This problem invlolves finding out the maximum amount we can money to be robbed in a day. 
#Used Dynamic programming wiith Time complexity- O(n)
#Space Complexity - O(1)
