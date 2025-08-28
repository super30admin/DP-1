'''
at each house, I have 2 options to make:
    1) Dont rob this house
        - then I can earn maximum of amounts earned from decison made from prev house
            - that can be either rob or not rob prev house
    2) Rob this house
        - then I can earn curr house val + amount earned from not robbing prev house
Finally, return the max of the 2 possibilities. 
Time complexity: O(N) - iterating over all houses. 
Space Complexity; O(1) - array of size 2 
'''
class Solution:
    def rob(self, nums: List[int]) -> int:
        dp_state = [0,0]

        for house_amount in nums:
            curr_dp_state = [0,0]
            # dont rob this house
            curr_dp_state[0] = max(dp_state) #either rob the prev house or not
            # rob this house
            curr_dp_state[1] = house_amount+dp_state[0] #curr_house money + dont rob the prev house
            #update the dp_state
            dp_state = curr_dp_state

        return max(dp_state)