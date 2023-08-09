// Time Complexity : O (max(maxNum, n)) time is max of the max number and the number of elements
// Space Complexity : O (N) for new array with earnings from each element
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class DeleteAndEarn{
    public static int deleteAndEarn(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int maxNum = 0;
        for(int num: nums){
            maxNum = Math.max(maxNum, num);
        }
        int[] arr = new int[maxNum + 1];
        for(int num: nums){
            arr[num] += num;
        }
        int skip = 0; int take = 0; int prevSkip = 0;
        for(int i = 0; i < arr.length; i++){
            prevSkip = skip;
            skip = Math.max(prevSkip, take);
            take = prevSkip + arr[i];
        }
        return Math.max(skip, take);

    }
    public static void main(String[] args) {
        int [] nums = {3, 4, 2};
        int result = deleteAndEarn(nums);
        // System.out.println(result);

        
    }
}