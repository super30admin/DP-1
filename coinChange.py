"""
Problem 322:
TC - O(r*c)
SC - O(r*c)
"""

coin = [1, 2, 5]
t = 11


def coinChange(coins, target):
    r, c = len(coins) + 1, target + 1
    # mat = [0*c]*r
    mat = [[0 for x in range(c)] for y in range(r)]
    for j in range(1, c):
        mat[0][j] = target + 1

    for i in range(1, r):
        for j in range(1, c):
            if j < coins[i - 1]:
                # if j is less than coins then copy r from above
                mat[i][j] = mat[i - 1][j]
            else:
                mat[i][j] = min(mat[i - 1][j], 1 + mat[i][j - coins[i - 1]])
    # return -1 if result is inf
    if mat[r - 1][c - 1] == target + 1: return -1
    # return value at last r and c
    return mat[r - 1][c - 1]


print(coinChange(coin, t))
