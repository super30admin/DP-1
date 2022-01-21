#Time Complexity: O(n)
#Space Complexity: O(n)
#Works on Leetcode: Yes


class Solution:
    def rob(self, nums):
        if nums == None or len(nums) == 0:
            return 0

        if len(nums) == 1:
            return nums[0]
        
        if len(nums) == 2:
            return max(nums[0], nums[1])

        arr = [0]*(len(nums))
        arr[0] = nums[0]
        arr[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            arr[i] = max(nums[i]+arr[i-2], arr[i-1])

        return arr[-1]        

if __name__ == "__main__":
    nums = [1,2,3,1]
    obj = Solution()
    print(obj.rob(nums))