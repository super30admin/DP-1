class Solution:
    memoize = list()
    # leetcode URL : https://leetcode.com/problems/house-robber/
    # Problem : 198. House Robber
    def rob(self, nums: List[int]) -> int:
        self.memoize= [-1]*len(nums) # only for recursive
        # Please uncomment each return to run for each method
        #return self.rob_reverse(len(nums)-1,nums)
        #return self.rob_recurse(0,nums)
        #return self.bottom_up_straight(nums)
        return self.bottom_up_reverse_with_no_extra_array(nums)
        
    # Time Complexity : O(n)
    # Space Complexity : O(1) 
    def bottom_up_reverse_with_no_extra_array(self,nums):
        i = len(nums)-1
        
        nums[i-1] = max(nums[i],nums[i-1])
        i = i-2
        while(i>=0):
            nums[i]  = max(nums[i]+nums[i+2],nums[i+1])
            i = i-1
        return nums[0]
    # Time Complexity : O(n)
    # Space Complexity : O(n)           
    def bottom_up_straight(self,nums):
        bottom_up = list()
        if len(nums)>=1:
            bottom_up.append(nums[0])
        if len(nums)>=2:
            bottom_up.append(max(nums[0],nums[1]))
        
        for i in range(2,len(nums)):
            bottom_up.append(max(bottom_up[i-1],nums[i]+bottom_up[i-2]))
        
        return bottom_up[-1]
    
    # Time Complexity : O(n)
    # Space Complexity : O(n)        
    def rob_recurse(self,i,house_amount):
        #base cases
        if i>=len(house_amount):
            return 0
        
        #recursion
        if self.memoize[i]!=-1:
            return self.memoize[i]
        else:
            self.memoize[i] = max((house_amount[i] + self.rob_recurse(i+2,house_amount)) , (self.rob_recurse(i+1,house_amount)))
            return self.memoize[i]

    # Time Complexity : O(n)
    # Space Complexity : O(n)  
    def rob_reverse(self,i,house_amount):
        #base cases
        if i<0:
            return 0
        
        #recursion
        if self.memoize[i]!=-1:
            return self.memoize[i]
        else:
            self.memoize[i] = max(house_amount[i] + self.rob_reverse(i-2,house_amount) , self.rob_reverse(i-1,house_amount))
            return self.memoize[i]
  