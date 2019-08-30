// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
    # Was not able to solve this problem directly. I have to take hints from discussion. 


// Your code here along with comments explaining your approach

class Solution:
    def rob(self, nums: List[int]) -> int:
        l = len(nums)
        # Checking two cases here first if input nums is empty than return 0 and if there is only one value return that value.
        if not l:
            return 0
        if l == 1:
            return nums[0]
        
        # Initialize another array of same size as input but with zero value
        arr = [0] * l
        
        # For 0th index we have only one option value at 0th index itself. 
        arr[0] = nums[0]
        # For 1st index we have to choose max value from first two values.
        arr[1] = max(nums[0], nums[1])
        
        # From second index we have to choose between sum of current number and 2 index past possible max value or one index behind possible max value. We have to choose max value from this two. we can dynamically choose max value this way.
        # If we choose current house than we have to skip last house and combine it with robbery till last to last house or we can choose best robbery value till last house. we choose max from it.
        for i in range(2, l):
            arr[i] = max(nums[i] + arr[i-2], arr[i-1])
            
        # Returning last value of array which is max possible robbery
        return arr[-1]