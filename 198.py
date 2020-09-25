// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution:
    def rob(self, nums: List[int]) -> int:
        arr = []
        if nums == []:
            return 0
        arr.append(0)
        arr.append(nums[0])
        for i in range(2,len(nums)+1):
            arr.append( max(arr[i-1],arr[i-2]+nums[i-1]))
        return arr[-1]
                