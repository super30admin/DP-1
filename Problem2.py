#Time complexity: O(n) where n is the length of input array
#Space complexity: O(1)
#Works on leetcode: yes
#Approach: Since only alternate houses can be robbed, we keep track of sum of alternate amounts using two variables.
# The "last" variable keeps memory of last maximum amount and "cur" keep tracks of the current maximum amount
class Solution:
	#Function to get the maximum amount the house robber can get
    def rob(self, nums: List[int]) -> int:
        last, cur = 0,0
        for n in nums:
            last, cur = cur, max(cur, last+n)
        return cur
    
    #Basic recursive method to get the maximum amount the robber can get
    def rob2(self,nums: List[int]) -> int:
        return self.helper(nums, 0, False, 0)
    
    #helper recursive function for base solution
    # Time = O(2^n)
    # Space = O(n) for recursive stack
    def helper(self,nums, i, lasthouse, currentsum): 
        if i>len(nums)-1:
            return currentsum
        #dont choose current home
        case1 = self.helper(nums, i+1, False, currentsum)
        #choose current home
        case2 = 0
        if not lasthouse:
            case2 = self.helper(nums, i+1, True, currentsum+nums[i])
        return max(case1,case2)
        