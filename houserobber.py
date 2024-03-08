# time complexity is o(1) and space complexity is o(nums)

class HouseRobber:
    def FindMaxHomes(self, nums):
        home_to_rob = [0, nums[0]]
        
        for i in range(1, len(nums)):
            homes_rob = nums[i]+home_to_rob[-2]
            not_rob = home_to_rob[-1]
            home_to_rob.append(max(homes_rob,not_rob ))
        return home_to_rob[-1]
        