// Time Complexity : O(n) n number of amount elememts
// Space Complexity : O(n) n is amount,   O(1) in Approach 2
// Did this code successfully run on Leetcode : Yes

var rob = function (nums) {
    if (nums.length === 0 || !nums) return 0;
    var dp = new Array(nums.length);
    for (let i = 0; i < dp.length; i++) {
        dp[i] = new Array(2);
    }

    dp[0][1] = nums[0];
    dp[0][0] = 0;

    for (let i = 1; i < dp.length; i++) {
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        dp[i][1] = dp[i - 1][0] + nums[i];
    }

    return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);

};


var rob = function (nums) {
    if (nums.length === 0 || !nums) return 0;
    let skip = 0;
    let take = nums[0];
    for (let i = 1; i < nums.length; i++) {
        let temp = skip;
        skip = Math.max(skip, take);
        take = temp + nums[i];
    }
    return Math.max(skip, take);
};





