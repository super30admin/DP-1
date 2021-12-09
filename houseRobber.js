// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

var rob = function (nums) {
  // We technically do not need any of the two base conditions because our for loop
  // and return statement at the end take care of both these scenarios.
  // However, given the LC test cases, having the two base conditions makes the avg runtime
  // faster in the instance that our length is 1 || 2. This is because, in those instances,
  // our function can exit early without having to performing computations within the for loop.
  if (nums.length === 1) {
    return nums[0];
  }

  if (nums.length === 2) {
    return Math.max(nums[0], nums[1]);
  }

  for (let i = 1; i < nums.length; i++) {
    nums[i] = Math.max(
      (nums[i - 2] === undefined ? 0 : nums[i - 2]) + nums[i],
      nums[i - 1]
    );
  }
  return nums[nums.length - 1];
};

console.log(rob([2]));
