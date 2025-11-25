'''
In this problem, I initialized previous value with first element of nums and current value with second element of nums.
Then, iteratively compared and updated previous and current values along the length of nums array and returned max amount at the end of iteration. 
'''
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1: return nums[0]
        # storing the first element
        prevMax = nums[0]
        # comparing first element and second elemnt and storing the maximum of them
        currentMax = max(nums[0], nums[1])

        for i in range(2, n):
            temp = currentMax
            currentMax = max(currentMax, prevMax + nums[i])
            prevMax = temp
        return currentMax

'''
Time Complexity: O(n)
Since we are iterating on an array of length n
Space Complexity: O(1)
Here I only used 2 variables not any arrays to store the max values
'''