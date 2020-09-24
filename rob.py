def rob(self, nums: List[int]) -> int:
    """
    #Brute force:
    only recursion - Create 2 lists even and odd. add them and return max(even,odd) as result
    Polynomial in time.

    #Dynamic Programming: recursion with memoization.
    Similar problem as fibonacci numbers.
    Everytime we store sub problem and keep solving them ahead, which will speed up computations.
    Every iteration adding even and odd items alternatively and keep storing sub-solution for next iteration,
    return max out of them.

    #Time complexity: O(n)

    #Space complexity: O(n)

    """
    stash1, stash2 = 0, 0
    for item in nums:
        stash1, stash2 = stash2, max(stash1+item, stash2)
    return stash2