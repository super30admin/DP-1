// space complexity - o(n)
    	//time - o(n)
      //Ran on leeetcode successfully : Yes
      // Problem faced  : No
    	//Approach : linear memuization

      class Solution {
    public int rob(int[] nums) {

        if(nums == null || nums.length ==0) return 0;
        if(nums.length == 1) return nums[0];

        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        arr[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            arr[i] = Math.max(arr[i-1], nums[i] + arr[i-2]);
        }

        return arr[nums.length-1];
    }

 //Same solution as above, instead of taking extra array modify input array

    public int rob(int[] nums) {

        if(nums == null || nums.length ==0) return 0;
        if(nums.length == 1) return nums[0];

        nums[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            nums[i] = Math.max(nums[i-1], nums[i] + nums[i-2]);
        }

        return nums[nums.length-1];
    }
}
