# Time Complexity - O(n)
# Space Complexity - O(n)


class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 1 :
            return nums[0]
        elif len(nums) == 2 :
            return (max(nums[0],nums[1]))
        arr = [0] * len(nums)
        arr[0] = nums[0]
        arr[1] = max(nums[0], nums[1])
        for i in range(2,len(nums)):
           
            arr[i] = max(arr[i-2] + nums[i],arr[i-1]) 

        return arr[len(nums)-1]
            
            


            