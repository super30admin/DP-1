# time - O(N), space O(1)
# Comparing 3 values: current, previous and prev.prev and considering max of them.
def rob(nums):
    prev = curr = 0
    for num in nums:
        temp = prev
        prev = curr
        curr = max(num + temp, prev)
        # print(temp,prev, num + temp,curr)
    return curr

print(rob([1,2,3,1]))

# another way but it passed only 40 cases in leetcode and failed on other.

def robbing(nums):
    sum_odd = 0
    sum_even = 0
    for i in nums[::2]:
        sum_even += i
    for i in nums[1::2]:
        sum_odd += i
    return max(sum_even, sum_odd)

print(robbing([1,2,3,1]))

# optimal solution
# saving only previous row values
# time O(N), space- O(1)
def robber(nums):
    notchosen = chosen = 0
    for num in nums:
        temp = chosen # This represents the nums[i-2]th value
        chosen = notchosen+num # This represents the nums[i-1]th value
        notchosen = max(temp, notchosen) # Here we just plug into the formula
    return max(notchosen,chosen)