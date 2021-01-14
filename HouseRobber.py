# Time complexity : O(n)
# Space complexity : O(n)
# Logic : at a prticular index, we have two options we can either include the current house or not include the current house. We have to choose the one which gives us max value. max(gold[cur - 2] house + gold[current house], gold[cur - 1] house). The first parameter is when we include the current house so we dont include the current - 1 house and the second parameter is we don't include the current house so just include the current - 1 house
# It got accepted on leetcode

class Solution:
	def houseRobber(self, arr):
		if len(arr) == 0:
			return 0
		if len(arr) == 1:
			return arr[0]
		dp_arr = [0] * len(arr)
		dp_arr[0] = arr[0]
		dp_arr[1] = max(arr[0], arr[1])
		for i in range(2, len(arr)):
			dp_arr[i] = max(dp_arr[i - 1], dp_arr[i - 2] + arr[i])
		return dp_arr[-1]

if __name__ == '__main__':
	hR = Solution()
	print(hR.houseRobber([2,7,9,3,1]))