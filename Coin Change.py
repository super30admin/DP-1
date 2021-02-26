#Time Complexity: O(n*m)
#Space Complexity: O(n*m)
#Notes: I couldn't figure out why my code was taking upto 2300 ms to run on leetcode while its java alternative was running quite fast
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins) + 1
        m = amount + 1
        dp = [[0 for i in range(m)] for j in range(n)]
        # Row Filling

        for t in range(1, (m)):
            dp[0][t] = 9999

        # Column Filling

        for p in range(0, (n)):
            dp[p][0] = 0

        # Now start filling from the first row and second column onwards

        for i in range(1, (n)):
            for j in range(1, (m)):
                if j < coins[
                    i - 1]:  # If the value we want is lesser than the coin amount we currently have, we simply pick the value from the above column as it would be the same
                    dp[i][j] = dp[i - 1][j]
                else:
                    # pick Min value from Choose option or Dont choose option
                    # Choose -> add 1 coin and then change the value of denomination by subtracting the value of the added coin's denomination from the original denomination and then select the value we got of the remaining denomination we calculated previously.
                    dp[i][j] = min((dp[i - 1][j]), (1 + dp[i][j - coins[i - 1]]))

        '''if dp[n-1][m-1] ==inf:
            return -1
        else:
            return dp[n-1][m-1]'''

        return -1 if dp[n - 1][m - 1] == 9999 else dp[n - 1][m - 1]
