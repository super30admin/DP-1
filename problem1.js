//// Time Complexity:
//// Space Complexity:
//// Did this code successfully run on Leetcode :
//// Any problem you faced while coding this :

//// Your code here along with comments explaining your approach

// create a table of columns 0..11 and rows 1, 2, 5
// fill in the table for each element
// when you get to [11, 5] you will have the fewest # of coins

//|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 |
//|---+---+---+---+---+---+---+---+---+---+---+----+----|
//| 0 |   |   |   |   |   |   |   |   |   |   |    |    |
//| 1 |   |   |   |   |   |   |   |   |   |   |    |    |
//| 2 |   |   |   |   |   |   |   |   |   |   |    |    |
//| 5 |   |   |   |   |   |   |   |   |   |   |    |    |

// the 0 row is all infinity so the basic logic will work
//|   | 0 |   1 |   2 |   3 |   4 |   5 |   6 |   7 |   8 |   9 |  10 |  11 |
//|---+---+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----|
//| 0 | 0 | inf | inf | inf | inf | inf | inf | inf | inf | inf | inf | inf |
//| 1 |   |     |     |     |     |     |     |     |     |     |     |     |
//| 2 |   |     |     |     |     |     |     |     |     |     |     |     |
//| 5 |   |     |     |     |     |     |     |     |     |     |     |     |

// for each position
//   if current amount < current denomination
//     take row value directly above
//   else
//     take minimum of (
//       row directly above,
//       1 + [(current coin value) elements back]
//     )

// return (last column last row value)
var coinChange;

coinChange = function(coins, amount) {
  var coinIndex, currentAmount, dptable, i, j, ref, ref1;
  if (coins.length < 1) {
    return -1;
  }
  if (coins.length === 1) {
    if (amount % coins[0] === 0) {
      return amount / coins[0];
    }
    return -1;
  }
  dptable = (function() {
    var ref;
    return (function() {
      var results = [];
      for (var i = 0, ref = coins.length; 0 <= ref ? i <= ref : i >= ref; 0 <= ref ? i++ : i--){ results.push(i); }
      return results;
    }).apply(this).map(function(val) {
      return Array(amount + 1).fill(9999); // 9999 represents infinity
    });
  })();
  dptable[0][0] = 0;
// start at row 1 not row 0, which we filled with 0, inf, inf, ...
  for (coinIndex = i = 1, ref = coins.length; (1 <= ref ? i <= ref : i >= ref); coinIndex = 1 <= ref ? ++i : --i) {
    for (currentAmount = j = 0, ref1 = amount; (0 <= ref1 ? j <= ref1 : j >= ref1); currentAmount = 0 <= ref1 ? ++j : --j) {
      dptable[coinIndex][currentAmount] = (currentAmount < coins[coinIndex - 1] ? dptable[coinIndex - 1][currentAmount] : Math.min(dptable[coinIndex - 1][currentAmount], 1 + dptable[coinIndex][currentAmount - coins[coinIndex - 1]]));
    }
  }
  if (dptable[coins.length][amount] === 9999) {
    return -1;
  }
  return dptable[coins.length][amount];
};

//coinChange([2], 3)
//coinChange([1, 2, 5], 11)

//# sourceMappingURL=problem1.js.map
