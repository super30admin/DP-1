//time complexity : O(n) n=number of houses
//space complexity : O(n)
//I don't face any problems
//runs successfully on leetcode

public class HouseRobber198LeetCode {

    //bottom up approach part 1 starting from start
    int[] dp;

    public int rob(int[] nums) {

        dp = new int[nums.length];
        if(nums.length==1){
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length;i++){

            int choose = nums[i] + dp[i-2];
            int notChoose = dp[i-1];
            int maximumRobbary = Math.max(choose, notChoose);
            dp[i] = maximumRobbary;

        }
        return dp[nums.length-1];

    }


////     bottom up approach part 1 starting from end
//     int[] dp;

//     public int rob(int[] nums) {

//         dp = new int[nums.length+2];

//         for(int i=nums.length-1;i>=0;i--){
//             int choose = nums[i] + dp[i+2];
//             int notChoose = dp[i+1];
//             int maximumRobbary = Math.max(choose, notChoose);
//             dp[i] = maximumRobbary;
//         }

//         return dp[0];
//     }



    // Top Down Approach
//     int[] dp;
//     public int rob(int[] nums) {

//         dp = new int[nums.length];
//         for(int i=0;i<nums.length;i++){
//             dp[i] = -1;
//         }
//         return rob(nums, 0);
//     }

//     public int rob(int[] nums, int index){

//         if(index>nums.length-1){
//             return 0;
//         }

//         if(dp[index]!=-1){
//             return dp[index];
//         }
//         int choose = nums[index] + rob(nums, index+2);

//         int notChoose = rob(nums, index+1);
//         int maximumRobbary = Math.max(choose, notChoose);
//         dp[index] = maximumRobbary;
//         return maximumRobbary;
//     }

//     Map<List<Integer>, Integer> map;
//     public int rob(int[] nums) {

//         map = new HashMap<>();
//         return rob(nums, 0);
//     }

//     public int rob(int[] nums, int index){

//         if(index>nums.length-1){
//             return 0;
//         }
//         int[] temp = Arrays.copyOfRange(nums, index, nums.length-1);

//         Integer[] boxedArray = Arrays.stream(temp).boxed().toArray(Integer[]::new);
//         List<Integer> tempList  = Arrays.asList(boxedArray);

//         if(map.containsKey(tempList)){
//             return map.get(tempList);
//         }

//         int choose = nums[index] + rob(nums, index+2);

//         int notChoose = rob(nums, index+1);
//         int maximumRobbary = Math.max(choose, notChoose);
//         map.put(tempList, maximumRobbary);
//         return maximumRobbary;
//     }
}
