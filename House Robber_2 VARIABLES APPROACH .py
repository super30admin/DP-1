
# 2 VARIABLES SOLUTION
# Did problem run on Leetcode: yes 
# Time Complexity: O(m*n) => O(m) as n is small 
# Space Complexity: O(1), as we are using only two variables

class Solution:
    def rob(self, nums):
        if not nums:
            return 0
        
        chosen = 0
        notChosen = 0

        for i in range(len(nums)):
            temp = chosen
            chosen = notChosen + nums[i]
            notChosen = max(temp, notChosen)
            
        return max(chosen, notChosen)

output = Solution()
print(output.rob(nums=[1,2,3,1]))

