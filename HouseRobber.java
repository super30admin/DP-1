// Time Complexity : O(n)
// Space Complexity : O(n)

//https://leetcode.com/problems/house-robber
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int arr[] = new int[nums.length+1];
        int prevMax=0;
        arr[0]=0;
        for(int i=1;i<arr.length;i++){
            prevMax = (i-1>0) ? arr[i-2] : 0;
            arr[i]= Math.max(arr[i-1],nums[i-1]+prevMax);            
        }
        return arr[nums.length];
    }
}
