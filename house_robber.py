class Solution:
    '''
    Time Complexity: O(n)
    Space Complexity: O(n)
    '''
    def rob(self, nums: List[int]) -> int:
        temp_dict = defaultdict(int)

        # start in reverse and find the max for each house.  Ex: if you visit house a the max is...
        for i in range (len(nums), 0, -1):
            temp_dict[i] = max(nums[i-1] + temp_dict[i + 2], temp_dict[i + 1])
        return temp_dict[1]