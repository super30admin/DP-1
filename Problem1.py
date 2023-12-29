'''
Time Complexity : O(mn)
Space Complexity : O(mn)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced


// Your code here along with comments explaining your approach:

We are building a (m x n) matrix and for each possible combination in the table we are checking what is the min. possible
coins needed
'''

from collections import defaultdict

def coinChange(coins: list[int], amount: int) -> int:
    matrix = [[] for i in range(len(coins)+1)]
    matrix[0].append(0)

    for i in range(1,amount+1):
        matrix[0].append(float('inf'))

    for i in range(1,len(coins) + 1):
        for j in range(amount+1):
            if j >= coins[i-1]:
                matrix[i].append(min(matrix[i-1][j], 1 + matrix[i][j-coins[i-1]]))

            else:
                matrix[i].append(matrix[i-1][j])

    return matrix[-1][-1]

def main():
    print(coinChange([1,2,5],11))

if __name__ == "__main__":
    main()