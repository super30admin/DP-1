## Problem2 (https://leetcode.com/problems/house-robber/)

# Method1: Exhaustive Recursion

# n ----- no. of houses
# Time Complexity : O(2^(n)) -- At every step, we have two choice to make and the max level or the max depth of the tree is n
# Space Complexity : O(1) space. But if we consider auxiliary space of the recursion stack, it would be O(n)
# Did this code successfully run on Leetcode : TLE
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# At every house we visit, we have two choices to make to choose to rob the house or not. If we choose to rob the house, we add the house 
# money to our total robbings and we skip the next house as we cannot rob adjacent houses. We can also skip the current house and
# move to rob the next house. Here as we are doing an exhaustive approach, so we are exploring every path possible

class Solution(object):
    def helper(self, arr, idx):
        if(idx >= len(arr)):
            # no more houses
            return 0

        # not choose
        case1 = self.helper(arr, idx + 1)

        # choose
        case2 = arr[idx] + self.helper(arr, idx + 2)

        return max(case1, case2)

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return self.helper(nums, 0)
    
sol = Solution()
print("Method1: Exhautive recursion")
print(sol.rob([1,2,3,1]))
print(sol.rob([2,7,9,3,1]))
print(sol.rob([2,1,1,3,5,4]))
print(sol.rob([10]))
print(sol.rob([0]))

# Method2: Recursion with Memoization using Hashing
# n ----- no. of houses
# Time Complexity : O(n) -- At every step, we have two choice to make and the max level or the max depth of the tree is n
# Space Complexity : O(n) -- for storing the result based on index in a hashmap as our decision making variable is only the house money + O(n) -- recursion stack
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we have repeated sub problems. Here our decision making variable is only the houses money. Amount is what we want to maximize and
# return. We use hashmap to do memoization as its searching is O(1)

class Solution(object):
    def __init__(self):
        self.storeRes = {}
    def helper(self, arr, idx):
        if(idx >= len(arr)):
            # no more houses
            return 0

        if(idx in self.storeRes):
            return self.storeRes[idx]

        # not choose
        case1 = self.helper(arr, idx + 1)

        # choose
        case2 = arr[idx] + self.helper(arr, idx + 2)

        self.storeRes[idx] = max(case1, case2)

        return self.storeRes[idx]

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.storeRes = {}
        return self.helper(nums, 0)
    
sol = Solution()
print("Method2: Recursion with memoization using Hashing")
print(sol.rob([1,2,3,1]))
print(sol.rob([2,7,9,3,1]))
print(sol.rob([2,1,1,3,5,4]))
print(sol.rob([10]))
print(sol.rob([0]))


# Method3: Recursion with Memoization using 1-D Array
# n ----- no. of houses
# Time Complexity : O(n) -- At every step, we have two choice to make and the max level or the max depth of the tree is n
# Space Complexity : O(n) -- for storing the result based on index in a array as our decision making variable is only the house money + O(n) -- recursion stack
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we have repeated sub problems. Here our decision making variable is only the houses money. Amount is what we want to maximize and
# return. We use 1-D array (as decision making variable is only one index) to do memoization as its searching is O(1)

class Solution(object):
    def __init__(self):
        self.storeRes = []
    def helper(self, arr, idx):
        if(idx >= len(arr)):
            # no more houses
            return 0

        if(self.storeRes[idx] > -1):
            return self.storeRes[idx]

        # not choose
        case1 = self.helper(arr, idx + 1)

        # choose
        case2 = arr[idx] + self.helper(arr, idx + 2)

        self.storeRes[idx] = max(case1, case2)

        return self.storeRes[idx]

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.storeRes = [-1] * len(nums)
        return self.helper(nums, 0)

sol = Solution()
print("Method3: Recursion with Memoization using 1-D Array")
print(sol.rob([1,2,3,1]))
print(sol.rob([2,7,9,3,1]))
print(sol.rob([2,1,1,3,5,4]))
print(sol.rob([10]))
print(sol.rob([0]))


# Method4: Tabulation using 1-D Array
# n ----- no. of houses
# Time Complexity : O(n) -- At every step, we have two choice to make and the max level or the max depth of the tree is n
# Space Complexity : O(n) -- for storing the result based on index in a array as our decision making variable is only the house money 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# We depict our exhaustive recursion tree in the form of a table. We find the pattern, where we note the max rob amount possible till 
# current house. At any house we know we can choose to take it or skip it. If we choose to take the current house money, then we add the
# current house money to the max we robbed till two houses before the current house. 
# If we skip it, then we take the max rob till the previous house. Eventually we take the max of both of these


class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if(len(nums) == 1):
            return nums[0]

        if(len(nums) == 2):
            return max(nums[0], nums[1])
        # method: Tabulation
        totalRob = [-1] * len(nums)

        # for every house we can choose it and skip adjacent or we skip current and move to 
        # the next, keep noting the max possible total rob till the current house

        # for the first house max would be the money of first house
        totalRob[0] = nums[0]
        totalRob[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            # to find max till current house, either we can get from the max till previous 
            # house or current house money + max till two house before the current 
            totalRob[i] = max(totalRob[i - 1], nums[i] + totalRob[i - 2])

        return totalRob[len(nums) - 1]


sol = Solution()
print("Method4: Tabulation using 1-D Array")
print(sol.rob([1,2,3,1]))
print(sol.rob([2,7,9,3,1]))
print(sol.rob([2,1,1,3,5,4]))
print(sol.rob([10]))
print(sol.rob([0]))


# Method5: Tabulation using 2 variables
# n ----- no. of houses
# Time Complexity : O(n) -- At every step, we have two choice to make and the max level or the max depth of the tree is n
# Space Complexity : O(1) -- for storing the max rob till previous house and two before previous house
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# The algo is same as before. Just here we only keep track of max rob till previuos house and max rob till two house previous instead
# of noting max for all the houses.

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if(len(nums) == 1):
            return nums[0]

        if(len(nums) == 2):
            return max(nums[0], nums[1])
        # method: Tabulation

        # for every house we can choose it and skip adjacent or we skip current and move to 
        # the next, keep noting the max possible total rob till the current house

        # for the first house max would be the money of first house
        secondLast = nums[0]
        last = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            # to find max till current house, either we can get from the max till previous 
            # house or current house money + max till two house before the current

            temp = max(last, nums[i] + secondLast)
            secondLast = last
            last = temp

        return last


sol = Solution()
print("Method5: Tabulation using 2 variables")
print(sol.rob([1,2,3,1]))
print(sol.rob([2,7,9,3,1]))
print(sol.rob([2,1,1,3,5,4]))
print(sol.rob([10]))
print(sol.rob([0]))


# Tracking the path using tabulation

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if(len(nums) == 1):
            print("Path: ", [0, nums[0]])
            return nums[0]

        if(len(nums) == 2):
            path = [0, nums[0]]
            if(nums[1] > nums[0]):
                path[0] = 1
                path[1] = nums[1]
            print("Path: ", path)
            return max(nums[0], nums[1])
        # method: Tabulation
        totalRob = [-1] * len(nums)

        # for every house we can choose it and skip adjacent or we skip current and move to 
        # the next, keep noting the max possible total rob till the current house

        # for the first house max would be the money of first house
        totalRob[0] = [nums[0], 1]
        totalRob[1] = [nums[0], 0]#nums[1] not selected
        if(nums[1] > nums[0]):
            #nums[1] selected
            totalRob[1][0] = nums[1]
            totalRob[1][1] = 1

        for i in range(2, len(nums)):
            # to find max till current house, either we can get from the max till previous 
            # house or current house money + max till two house before the current 
            totalRob[i] = [totalRob[i - 1][0], 0] # if previuos is greater
            if(nums[i] + totalRob[i - 2][0] > totalRob[i - 1][0]):
                # if current + previous two is greater
                totalRob[i][0] = nums[i] + totalRob[i - 2][0]
                totalRob[i][1] = 1
            # totalRob[i] = max(totalRob[i - 1], nums[i] + totalRob[i - 2])

        path = []
        i = len(nums) - 1
        res = totalRob[len(nums) - 1][0]
        while(i >= 0):
            if(totalRob[i][1] == 0):
                # current house not robbed, go to previous house
                i -= 1
            else:
                # current house is robbed
                path.append((i, nums[i])) # house index, house money
                i -= 2

        print("Path: ", path)
        return res
    
sol = Solution()
print("Tracking path using tabulation")
print(sol.rob([1,2,3,1]))
print(sol.rob([2,7,9,3,1]))
print(sol.rob([2,1,1,3,5,4]))
print(sol.rob([10]))
print(sol.rob([20, 16]))
print(sol.rob([16, 20]))
print(sol.rob([0]))
print(sol.rob([2,7,9,3,1,4,7,8,9,7]))


# Tracking the path using memoization

class Solution(object):
    def __init__(self):
        self.storeRes = []
    def helper(self, arr, idx):
        if(idx >= len(arr)):
            # no more houses
            return 0

        if(self.storeRes[idx][0] > -1):
            return self.storeRes[idx][0]

        # not choose
        case1 = self.helper(arr, idx + 1)

        # choose
        case2 = arr[idx] + self.helper(arr, idx + 2)

        # store the flag what gave us the max rob at that idx
        # Choosing it gave or not choosing it gave
        # by default setting it as not choosing the current gave us the max rob
        self.storeRes[idx] = [case1, 0]
        if(case2 > case1):
            # max rob was due to choosing to rob the current house
            self.storeRes[idx] = [case2, 1]
        # self.storeRes[idx] = max(case1, case2)

        return self.storeRes[idx][0]

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.storeRes = [(-1, 1)] * len(nums)
        
        res = self.helper(nums, 0)
        # so first index will have the max rob possible to have using the entire array
        # so we trace the path from the start
        i = 0
        path = []
        while(i < len(nums)):
            if(self.storeRes[i][1] == 0):
                # this house was skipped move to check the next one
                i += 1
            else:
                # this house was robbed
                path.append((i, nums[i]))
                i += 2
        
        print("Path: ", path)

        return res
    
sol = Solution()
print("Tracking path using memoization")
print(sol.rob([1,2,3,1]))
print(sol.rob([2,7,9,3,1]))
print(sol.rob([2,1,1,3,5,4]))
print(sol.rob([10]))
print(sol.rob([20, 16]))
print(sol.rob([16, 20]))
print(sol.rob([0]))
print(sol.rob([2,7,9,3,1,4,7,8,9,7]))