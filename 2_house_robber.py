class Solution:
    def rob(self, nums) -> int:
        '''
        time complexity = O(len(nums))
        space complexity = O(len(nunms))
        Working on LC = Yes
        '''
        if len(nums) == 0:  # if no house is there to rob
            return 0

        c = 2  # choose to rob or not
        # col=0 means not robbed
        # col=1 means robbed
        r = len(nums)  # total house
        dpmat = [[0 for _ in range(c)] for _ in range(r)]  # generate dpmat with all zeros
        dpmat[0][0] = 0  # if first house is not selected then no money
        dpmat[0][1] = nums[0]  # if there is only one house, we will get that amount

        for i in range(1, r):  # i is current house
            dpmat[i][0] = max(dpmat[i - 1][:])  # if curr house is not selected then max amount is
            # before curr house
            dpmat[i][1] = nums[i] + dpmat[i - 1][0]  # if curr house is selected then
            # amount=curr + prev not selected

        return max(dpmat[r - 1][:])  # return max of last row

nums=[1,2,3,1]

print(Solution.rob(Solution,nums))