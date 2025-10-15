# Time: O(2^n) The tree keeps increasing in the powers of 2
# Space: O(n) n=> length of the array worst case when we don't choose until the end
# To choose or not to choose if choosen then skip 1 element and if we don't choose then just update the index to next one
# when we choose an element add the element with the next choosen one if we choose it

class Solution:
    def rob(self, nums: List[int]) -> int:
        return self.helper(nums, 0)

    def helper(self, nums, idx):
        # base case
        if idx > (len(nums) - 1):
            return 0

        # choose
        choose = nums[idx] + self.helper(nums, idx + 2)
        # not choose
        not_choose = self.helper(nums, idx + 1)

        return max(choose,not_choose)
    

# MEMOISATION SOLUTION
# Time: O(n) => for each element the value is only calculated once and then it is reused
# Space:O(n) => the memoise array in of length n and also the recursion stack is of length n 
# The only optimisation we do add a memoization arr

class Solution:
    def rob(self, nums: List[int]) -> int:
        self.memoise = [-1] * len(nums)
        return self.helper(nums, 0)
    def helper(self, nums, idx):
        # base case
        if idx > (len(nums) - 1):
            return 0
        if self.memoise[idx] != -1:
            return self.memoise[idx]

        # choose
        choose = nums[idx] + self.helper(nums, idx + 2)
        not_choose = self.helper(nums, idx + 1)

        self.memoise[idx] = max(choose, not_choose)
        return self.memoise[idx]
    
# TABULATION SOLUTION
# Time: O(n) going through each element in the array
# Space: O(n) maintaining the dp_arr of size similar to the nums arr
# First element is similar to same as 1st element of nums and the 2nd is max of the first element and 2nd element
# What we do is calculate the value of i based on max(i-1 and adding the current element to i-2)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        dp_arr = [-1] * len(nums)
        dp_arr[0] = nums[0]
        dp_arr[1] = max(dp_arr[0],nums[1])

        for i in range(2,len(nums)):
            dp_arr[i] = max(dp_arr[i-1],nums[i] + dp_arr[i-2])
        
        return dp_arr[len(nums) - 1]
    


# OPTIMISING TABULATIOIN
# Time: O(n) going through each element in the array
# Space: O(1) only maintaning i-1 and i-2 which we need
# In the previous solution we don't really need the whole array so we just maintain the previous and current element going forward
# and at the end return the current element which is also the last one
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        prev = nums[0]
        curr = max(prev,nums[1])

        for i in range(2,len(nums)):
            temp = curr
            curr = max(temp,nums[i] + prev)
            prev = temp
        
        return curr