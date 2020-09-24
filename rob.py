def rob(self, nums: List[int]) -> int:
    """
    #Brute force:
    only recursion - Create 2 lists even and odd. add them and return max(even,odd) as result
    Exponetial in time. 2^n.

    #Dynamic Programming: bottom up approach
    Similar problem as fibonacci numbers.
    Everytime we store sub problem and keep solving them ahead, which will speed up computations.
    Every iteration add even and odd items alternatively and keep storing sub-solution with max for next iteration,
    return max out of them.

    #Time complexity: O(n)

    #Space complexity: O(n)

    """
    stash1, stash2 = 0, 0
    for item in nums:
        stash1, stash2 = stash2, max(stash1+item, stash2)
    return stash2