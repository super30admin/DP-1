// House Robber

/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    if (nums.length == 2) return Math.max(nums[0], nums[1]);

    let currMax = 0,
        prevMax = 0;

    for (const num of nums) {
        let temp = currMax;
        currMax = Math.max(prevMax + num, currMax);
        prevMax = temp;
    }
    return currMax;
};
