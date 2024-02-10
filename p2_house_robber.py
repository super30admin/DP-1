class Solution:
    """
        Time Complexity: O(N)
        Space Complexity: O(1)
        Explaination:
            In dynamic problem 
                - we choose the max between prev and prev2 + curr
                - we return the max_value 
        What if you have to show the path? <------ Extra
            - we choose all the selected house and store the selected house in boolean array
            - we iterate from backward
            - if we find 1 we append it to the robbed_house array and skip the next one 
            - if we find 0 we skip it and move to the next one
            - The array we get in the end is the path array
    """
    def rob(self, houses: List[int]) -> int:
        if len(houses) < 3:
            max_loot = 0
            for i in houses:
                max_loot = max(max_loot, i)
            return max_loot
        prev2 = houses[0]
        path = list()
        path.append(1)
        prev = max(prev2, houses[1])
        max_loot = max(prev2, prev)
        if prev == max_loot:
            path.append(1)
        else:
            path.append(0)
        for i in range(2, len(houses)):
            curr = houses[i]
            max_loot = max(prev, prev2+ curr)
            if max_loot == prev2+curr:
                path.append(1)
            else:
                path.append(0)
            prev2 = prev
            prev = max_loot
        print(self.find_path(path, houses))
        return max_loot

    def find_path(self, path, houses):
        robbed_houses = list()
        i = len(path) - 1
        while i >= 0:
            if path[i] == 1:
                robbed_houses.append(houses[i])
                i = i - 2
            elif path[i] == 0:
                i = i - 1
        return robbed_houses
# class Solution:
#     """
#         Time Complexity: O(2^n)
#     """
#     def rob(self, nums: List[int]) -> int:
#         self.max = 0
#         curr = 0
#         self.helper(nums,curr)
#         return self.max
    
#     def helper(self, house, curr):
#         # Base
#         if len(house) == 0:
#             self.max = max(curr, self.max)
#             return
#         # Not Choose
#         self.helper(house[1:], curr)
#         # Choose
#         self.helper(house[2:], curr+house[0])
