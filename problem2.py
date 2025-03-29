# Problem2 (https://leetcode.com/problems/house-robber/)

# STARTING WITH BRUTE FORCE - RECURSIVE
# TC : O(2^n)
#   For each house, the algorithm makes two recursive calls (either rob or skip)
#   This creates a binary decision tree with a height of n
#   Without memoization, each path is recalculated, leading to exponential time complexity

# SC : O(n)
# The recursion stack can go as deep as n (the number of houses)
# Maximum stack depth occurs when following a path through all houses

# Approach:
# Recursive with backtracking: The algorithm uses a recursive helper function to explore all possible combinations of houses to rob
# Decision tree: At each house i, it makes two choices:
#   - Skip the current house (case0)
#   - Rob the current house and skip the next one (case1)
# Base case: When we've gone through all houses (i >= len(nums)), return the current amount robbed
# Optimal substructure: The final solution returns the maximum amount possible from these two choices

# On LeetCode it shows that the time limit exceeds

def rob(self, nums):
    # Main function that initializes the recursive helper
    # nums: list of house values
    # Returns the maximum amount that can be robbed
    return self.helper(nums, 0, 0)
    
def helper(self, nums, i, robbings):
    # Recursive helper function that explores all possible combinations
    # nums: list of house values
    # i: current house index we're considering
    # robbings: cumulative amount robbed so far
    
    # base case
    if i >= len(nums):
        # If we've processed all houses, return the total amount robbed
        return robbings
    
    # logic
    case0 = self.helper(nums, i + 1, robbings)
    # case0: Skip the current house (i) and move to the next house (i+1)
    # The robbing amount remains unchanged

    case1 = self.helper(nums, i + 2, robbings + nums[i])
    # case1: Rob the current house (i) and move two houses ahead (i+2)
    # Add the current house value (nums[i]) to the robbing amount
    
    return max(case0, case1)
    # Return the maximum amount possible between the two choices:
    # either skip the current house or rob it

#________________________________________________________________________

# THEN THE TABULATION

# Time Complexity: O(n)
# The algorithm makes a single pass through the array of houses
# Each house is processed once with constant-time operations

# Space Complexity: O(n)
# The algorithm uses an additional array dp of size n to store intermediate results

# Approach: Dynamic Programming (Bottom-Up)
# This solution uses dynamic programming with tabulation (bottom-up approach)
# We build a table (dp array) where each cell represents the maximum amount that can be robbed up to that house
# For each house, we have two options:
#   - Skip the current house: take the maximum amount from the previous house (dp[i-1])
#   - Rob the current house: take its value plus the maximum amount from two houses ago (nums[i] + dp[i-2])
# We choose the maximum of these two options for each house
# The final answer is in dp[n-1], representing the maximum amount that can be robbed from all houses

# On LeetCode could submit the code

def rob(self, nums):
        # Get the total number of houses
        n = len(nums)
        
        # If there's only one house, return its value
        if n == 1:
            return nums[0]

        # Initialize a dynamic programming array where dp[i] represents 
        # the maximum amount that can be robbed up to house i    
        dp = [0] * n
        
        # Base case: the max amount for the first house is just its value
        dp[0] = nums[0]
        # For the second house, take the maximum between first and second house values
        dp[1] = max(nums[0], nums[1])
        
        # Iterate through remaining houses
        for i in range(2, n):
            # For each house, decide whether to rob it or not
            # If we rob it, we add its value to the max amount from two houses ago (dp[i-2])
            # If we don't rob it, we take the max amount from the previous house (dp[i-1])
            # Choose the maximum of these two options
            dp[i] = max(dp[i-1], nums[i] + dp[i-2])


        # Return the maximum amount that can be robbed up to the last house    
        return dp[n-1]