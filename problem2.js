//// Time Complexity : O(n)
//// Space Complexity : O(1) just 3 variables
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :
// mental leaps!

//// Your code here along with comments explaining your approach

// (1) For single house [x] return x // this will be referred to as prevMax
// (2) For 2 houses [x, y] return max(x, y) // this will be currMax
// (3) For 3 houses [x, y, z] choose Max(step(1) + z, step(2) // this will be next currMax

// prevMax = 0, as case (1) nums [0]
// curMax = 0, as case (2) nums [0, 0]
// for each house in nums
//   tempCurrMax = currMax
//   currMax at step 3 will be Max(prevMax + house, curMax) // see step(3) above
//   prevMax = temp // set up for next iteration where prev is step(1) above

var rob;

rob = function(nums) {
  var currMax, i, len, prevMax, temp, x;
  prevMax = 0;
  currMax = 0;
  for (i = 0, len = nums.length; i < len; i++) {
    x = nums[i];
    temp = currMax;
    currMax = Math.max(prevMax + x, currMax);
    prevMax = temp;
  }
  return currMax;
};

//rob([1, 2, 3, 1])

//# sourceMappingURL=problem2.js.map
