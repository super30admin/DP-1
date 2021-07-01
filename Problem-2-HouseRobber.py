class Solution:
    def rob(self, nums) :
        skip = 0
        take = nums[0]

        for i in range(1, len(nums)):
            temp = skip
            # Case 0

            skip = max(skip, take)
            # Case1
            take = temp + nums[i]

        return max(skip, take)

sol=Solution()
houses = [1,4,6,7,9]
print (sol.rob(houses))