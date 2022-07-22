class Solution:
    def rob(self, nums: List[int]) -> int:
        # DP - optimized space
        # TC - O(n) SC - O(1)
        if len(nums) == 1:
            return nums[0]

        # max_robbed = [0] * len(nums)
        max_robbed_1 = nums[0]
        max_robbed_2 = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            if max_robbed_2 < max_robbed_1 + nums[i]:
                max_robbed_1, max_robbed_2 = max_robbed_2, max_robbed_1 + nums[i]

            else:
                max_robbed_1 = max_robbed_2
        return max(max_robbed_1, max_robbed_2)

    '''
        # DP TC - O(n) SC - O(n)
        if len(nums) == 1:
            return nums[0]

        max_robbed = [0] * len(nums)
        max_robbed[0] = nums[0]
        max_robbed[1] = max(nums[0],nums[1])
        for i in range(2,len(nums)):
            max_robbed[i] = max(max_robbed[i-1], max_robbed[i-2] + nums[i])

        print(max_robbed)
        return max(max_robbed)

    '''

    '''
        # recursion Time limit exceeded
        # TC - O(2**n)
        # SC - O(n/2)
        if (len(nums) == 0):
            return 0
        else:
            return self.helper(nums,0,0)

    def helper(self,nums,amount,i):
        #base
        if i >= len(nums):
            return amount
        #logic
        # choose
        case1= self.helper(nums, amount+nums[i], i+2)
        # no choose
        case2 = self.helper(nums, amount, i+1)

        return max(case1,case2)

    '''

