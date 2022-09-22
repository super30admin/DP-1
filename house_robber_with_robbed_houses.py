# TC: O(n)
# SC: O(1)

class Solution:
    def rob(self, nums: List[int]):
        skip = 0
        take = 0
        temp = 0
        take_arr = []
        skip_arr = []
        temp_arr = []

        for i in range(len(nums)):
            temp = skip
            skip = max(skip, take)
            if skip == take:
                temp_arr = skip_arr
                skip_arr = take_arr
                temp_arr.append(nums[i])
                take_arr = temp_arr
            take = temp + nums[i]

            if max(skip, take) == skip:
                return skip, skip_arr
            else:
                return take, take_arr