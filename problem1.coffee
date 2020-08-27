#// Time Complexity: O(n^2) we are filling out a NxN array of amounts and coin denominations
#// Space Complexity: O(n^2) we are creating a NxN array to hold answers
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
#  off-by-1 error when indexing into coin array
#  catch returning infinity (answer not found basically)
#
#
#// Your code here along with comments explaining your approach
#
# create a table of columns 0..11 and rows 1, 2, 5
# fill in the table for each element
# when you get to [11, 5] you will have the fewest # of coins
#
#|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 |
#|---+---+---+---+---+---+---+---+---+---+---+----+----|
#| 0 |   |   |   |   |   |   |   |   |   |   |    |    |
#| 1 |   |   |   |   |   |   |   |   |   |   |    |    |
#| 2 |   |   |   |   |   |   |   |   |   |   |    |    |
#| 5 |   |   |   |   |   |   |   |   |   |   |    |    |
#
# the 0 row is all infinity so the basic logic will work
#|   | 0 |   1 |   2 |   3 |   4 |   5 |   6 |   7 |   8 |   9 |  10 |  11 |
#|---+---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----|
#| 0 | 0 | inf | inf | inf | inf | inf | inf | inf | inf | inf | inf | inf |
#| 1 |   |     |     |     |     |     |     |     |     |     |     |     |
#| 2 |   |     |     |     |     |     |     |     |     |     |     |     |
#| 5 |   |     |     |     |     |     |     |     |     |     |     |     |
#
# for each position
#   if current amount < current denomination
#     take row value directly above
#   else
#     take minimum of (
#       row directly above,
#       1 + [(current coin value) elements back]
#     )
#
# return (last column last row value)

coinChange = (coins, amount) ->
  return -1 if coins.length < 1
  if coins.length == 1
    return amount / coins[0] if amount % coins[0] == 0
    return -1

  dptable = do -> [0..coins.length].map (val) ->
    Array(amount+1).fill(9999) # 9999 represents infinity
  dptable[0][0] = 0

  for coinIndex in [1..coins.length] # start at row 1 not row 0, which we filled with 0, inf, inf, ...
    for currentAmount in [0..amount]
      dptable[coinIndex][currentAmount] =
        (if currentAmount < coins[coinIndex-1]
           dptable[coinIndex-1][currentAmount]
         else
           Math.min(dptable[coinIndex-1][currentAmount],
             1 + dptable[coinIndex][currentAmount-coins[coinIndex-1]]))

  return -1 if dptable[coins.length][amount] == 9999
  dptable[coins.length][amount]

#coinChange([2], 3)
#coinChange([1, 2, 5], 11)
