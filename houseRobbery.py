# here,  only one input changes so only 1-D array is required
# How I thought of this was, the max money will be robbed by calculating maximum from previous robbery and robbery before that and storing it in dp array.
# Time Complexity: O(n)
#Space Complexity: O(n)
def housRob(arr):
    dp = [0 for i in range(len(arr))]
    print(dp)
    if len(arr) == 0 or arr is None:
        return 0
    if len(arr) == 1:
        return arr[0]
    dp[0] = arr[0]
    dp[1] = max(arr[0],dp[1])
    for i in range(2,len(arr)):
        dp[i] = max(dp[i-1],arr[i]+dp[i-2])
    return dp[-2]

arr = [1,2,3,1]
rob = housRob(arr)
print(rob)

