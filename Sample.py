# Problem 1: Coin change -> Time Complexicity: O(m*n), Space Complexicity: O(m*n) (for dp array)

class Solution:

    def coinChange(self, coins: List[int], amount: int) -> int:
        
        """
        Solve using a array to store the min coins required progressively for every amount, 
        and using mix of any number of coins
        """
        
        if len(coins) == 0: return 0
        w, h = amount + 1, len(coins) + 1
        dp_mat = [[0 for x in range(w)] for y in range(h)] 

        for j in range(len(dp_mat[0])):
            dp_mat[0][j] = w

        for j in range(1, amount + 1):
            for i in range(1, len(coins) + 1):
                if coins[i-1] > j:
                    dp_mat[i][j] = dp_mat[i-1][j] # Zero case (one row above)
                else:
                    dp_mat[i][j] = min(dp_mat[i-1][j], 1+dp_mat[i][j-coins[i-1]])
                    
        result = dp_mat[len(coins)][amount]
        if result >= w: return -1
        return result
		
# Problem 2: House Robber -> Time Complexicity: O(n), Space Complexicity: O(n)

class Solution:
    
    def rob(self, nums: List[int]) -> int:
	
		"""
		Solve using a DP array by progressively varying the max amount by:
		- taking max(previous coin selector), and add value to existing amount
		"""
		
        if len(nums) == 0: return 0
        else:
            w, h = 2, len(nums)
            dp = [[0 for x in range(w)] for y in range(h)] 

            for j in range(h):
                dp[j][0] = 0 if j == 0 else max(dp[j-1])
                dp[j][1] = nums[j] if j == 0 else nums[j] + dp[j-1][0]

            return max(dp[h-1])
