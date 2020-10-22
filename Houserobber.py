"""
two choice:
selecting i house and add with i-2 house value
not selecting i so having previous (i-1) and previous sum 

memorization can be eleminated with just two variable that store i-1 and i-2 value

Time complexity O(n)
Space constant O(1)

"""
class Houserobber:
    def rob(self, nums: List[int]) -> int:
        if (len(nums) == 0):
            return 0
        prev1 = 0
        prev2 = 0
        for num in nums:
            temp=prev1
            prev1 = max(prev2 + num, prev1);
            prev2 = temp
        return prev1
