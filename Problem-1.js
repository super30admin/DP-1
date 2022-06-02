// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
 var coinChange = function(coins, amount) {
    const table = new Array(amount + 1)
    for (let i=0; i<table.length; i++) {
        table[i] = Infinity;
    }
    table[0] = 0;

    coins.forEach(coin => {
        for (let i=coin; i< table.length; i++) {
            table[i] = Math.min(table[i], (1 + table[i-coin]));
        }
    });

    return table[table.length-1] !== Infinity ? table[table.length-1] : -1;
};