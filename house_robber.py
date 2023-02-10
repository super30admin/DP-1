# Time Complexity :
# O(N) N is the number of houses

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We go through each of the house - at each step - the robber either decides to rob the current house or the next house. So, we select one of the houses, and then see among the remaining n-2 (from 2 houses away), what is the maximum loot that can be gained
#We also store the information of what is the best gain from a particular starting point if that has been solved and use that information if that information is required again

class Solution:
    def rob(self, nums: List[int]) -> int:
        self.info = [-1] * (len(nums) + 1)
        return self.helper(nums)

    def helper(self,nums):
        if len(nums) == 0 :
            return 0
        if len(nums) == 1:
            self.info[0] = nums[0]
            return nums[0]
        if self.info[len(nums) - 1] != -1 :
            return self.info[len(nums) - 1]
        best =  max(nums[-1] + self.helper(nums[:-2]),nums[-2] + self.helper(nums[:-3]))
        self.info[len(nums) - 1] = best
        return best
