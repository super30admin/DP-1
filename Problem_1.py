'''
Time Complexity - O(n) we are iterating all the houses
Space Complexity - O(n) same as the number of houses

This code works on leetcode
'''


class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [0 for i in range(len(nums))] #create the 1D array
        dp[0] = nums[0] #value at first house will be that of the loot at first house
        for i in range(1, len(nums)): #iterate over all the elements
            rob, NotRob = nums[i], 0 #if we choose to rob a house the value is the loot present currently
            if i > 1:
                rob += dp[i-2] #we cannot loot the adjacent house if we choose to loot a house
            notRob = 0 + dp[i-1] #if we dont loot the current house we can loot the next house
            dp[i]= max(rob, notRob) #total looted value is total is max of if we loot or not loot the house
        return dp[len(nums)-1] if dp[len(nums)-1] > 0 else 0 #return the value at last index of the DP arra



        