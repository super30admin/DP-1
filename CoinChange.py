#Time Complexity: O(n^2)
#Space Complexity: O(n)
#Works on Leetcode: Yes


class Solution:
    def coinChange(self, coins, amount):
        arr =[amount+1]*(amount+1)
        arr[0] = 0
        for i in range(amount+1):
            for j in range(len(coins)):
                if coins[j]<=i:
                    arr[i] = min(arr[i], 1+arr[i-coins[j]])

        if arr[amount]>amount:
            return -1
        return arr[amount]


if __name__ == "__main__":
    coins = [1,2,5]
    amount = 11
    obj = Solution()
    print(obj.coinChange(coins, amount))