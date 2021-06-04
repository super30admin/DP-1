# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution(object):
    def rob(self, nums):
        # initializing the two  element with start value
        drop = 0  # 0 case
        take = nums[0]  # 1 case

        #  iterate over the houses given
        for i in range(1, len(nums)):
            # saving current 0 case value in temporary variable
            current_drop = drop
            #  for 0 case take maximum form previous 0 case and 1 case values
            drop = max(drop, take)
            #  for 1 case we will take previous 0 case
            #  (temporary variable - as we are updating the previous 0 case value)
            #  and add that to the current index house value
            take = current_drop + nums[i]
        #  return maximum between final 0 case and 1 case value
        return max(drop, take)
