//Passed all the test cases on Leet Code
//Time Complexity : O(n)
//A robber has basically two options available either it will rob the current house or it wont rob the current house .
//In the first case the robber cannot go to i-1 house but can access house previous to i-2 and so on
//In second case the robber getsall the possible loot from robbery of i-1 and all the following buildings.
//Basic recursive solution : rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )
public class Houserobber {
    public static int rob(int[] nums) {
        if(nums == null || nums.length<1){
            return 0;
        }

        if(nums.length ==1){
            return nums[0];
        }

        int[] cache = new int[nums.length+1];
        //Base cases are declared
        cache[0]=nums[0];
        cache[1]=Math.max(nums[0],nums[1]);

        for(int i =2;i<nums.length;i++){
            cache[i] = Math.max(cache[i-2]+nums[i],cache[i-1]);
        }

        return cache[nums.length-1];

    }
    public static void main (String[] args) {
        int[] nums = {5,3,4,11,2};
        System.out.println(rob(nums));


    }
}
