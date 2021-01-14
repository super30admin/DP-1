/*

Did it run leetcode: Yes
Time Complexity: 0(N)
Space Complexity: 0(N)

Problems faced: Yes

Algorithm:
The idea behind the algorithm is that, since we cannot rob two consecutive houses,
we compare total money looted against previous house, two houses before+current house.


1. We create `value` array with size qual to nums
2. The first value of `value` array will be equal to fist value of nums array
3. Then at every positon we check max(value[i-1], value[i-2]+nums[i]) because we cannot rob
two consecutive houses to avoid alarm.
*/



class Solution {
    public int rob(int[] nums) {
        
        if(nums==null){
            return 0;
        }else if(nums.length==0){
            return 0;
        }
        else if(nums.length==1){
            return nums[0];
        }
        
        int[] values = new int[nums.length];
        values[0] = nums[0];
        values[1] = Math.max(values[0],nums[1]);
        
        for(int i=2;i<nums.length;++i){
            values[i] = Math.max(values[i-2]+nums[i],values[i-1]);
        }
        
        return values[nums.length-1];
    }
}