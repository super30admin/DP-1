public class Solution{
        public  int maxAmount(int[] intArr){
           return maxAmountSubFunc(intArr,0);
       }
       
       public  int maxAmountSubFunc(int[] intArr,int startIndex){
           if(startIndex>intArr.length-1) return 0;
           if(startIndex==intArr.length-1) return intArr[intArr.length-1];
         return Math.max(maxAmountSubFunc(intArr,startIndex+2)+intArr[startIndex],
                 maxAmountSubFunc(intArr,startIndex+3)+intArr[startIndex+1]);
       }
}
