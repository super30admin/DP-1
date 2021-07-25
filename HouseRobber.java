// Time Complexity : O(N), where N = length of array
// Space Complexity :O(N), where N = length of array used as memo + O(N) for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    
    // Cache to memoize result of recursive calls
    private Map<Integer, Integer> memo;
     
     public int rob(int[] nums) {
        // if theres only one element, only that can be profit 
        if(nums.length == 1)
         {
             return nums[0];
         }
         // if there are two elements, return max one out of those two
         if(nums.length == 2)
         {
             return Math.max(nums[0], nums[1]);
         }
 
         // Initialize Cache
         memo = new HashMap<>();
         // We can star from house 0 or house 1
         int startAtZero = helper(nums, 0);
         int startAtOne = helper(nums, 1);

         // result will be max of either of those
         int result = Math.max(startAtOne, startAtZero);
         
         return result;
     }
     
     private int helper(int[] a, int index)
     {
         // if index is out of array we cant have ay profit
         if(index >= a.length)
         {
             return 0;
         }
         
         //if result is already stored in cache return it
         if(memo.get(index) != null)
         {
             return memo.get(index).intValue();    
         }
         
         // we can rob two ways, init both as 0
         int profit1 = 0, profit2 = 0;
         // we can rob this house then house at index + 2
         profit1 = a[index] + helper(a, index + 2);
         //or we can rob this house then house at index + 3
         profit2 = a[index] + helper(a, index + 3);
         
         // result will be max of either of those
         int profit = Math.max(profit1, profit2);
         //strore it in cache and return
         memo.put(index, profit);
         return profit;
     }
 }