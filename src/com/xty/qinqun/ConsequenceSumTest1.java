package com.xty.qinqun;

/**
 * Created by Administrator on 2017/11/5 0005.
 */
public class ConsequenceSumTest1 {

    public static void main(String[] args) {
        //用分治算法
        int [] intArray = {1,2,-4,5,6,-7,10};
        int [] intArray2 = {1,2,-4,5,6,-7,1};

        ConsequenceSumTest1 test1 = new ConsequenceSumTest1();
        int sum = test1.calculateConsequence(intArray,0,intArray.length -1);
        System.out.println("first consequence sum = >" + sum);

        int sum2 = test1.calculateConsequence(intArray2,0,intArray2.length -1);
        System.out.println("second consequence sum = >" + sum2);


        System.out.println("<=============line calcalate=========== = >");
        sum = test1.lineCalculate(intArray);
        System.out.println("line calculate first consequence sum = >" + sum);
        sum = test1.lineCalculate(intArray2);
        System.out.println("line calculate second consequence sum = >" + sum);
    }

    public int lineCalculate(int[] array){
        int thisSum = 0, maxSum = 0;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            thisSum += array[i];
            if (thisSum > maxSum){ //计算连续最大sum
                maxSum = thisSum;
            }else if (thisSum < 0){  //前面连续sum小于0  丢弃 重新计算
                thisSum = 0;
            }
        }
        return maxSum;
    }

    public int calculateConsequence(int[] array,int left,int right){

        if (array == null || array.length == 0){
            try {
                throw  new Exception("not init array");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

       if (left == right){    //基准情形
           if (array[left] > 0){
               return array[left];
           }else{
               return 0;
           }
       }

        int center = (left + right)/2;
        int leftSum = calculateConsequence(array,left,center);
        int rightSum = calculateConsequence(array,center+1,right);

        int leftBorderSum = 0, maxLeftBorderSum = 0;
        for(int i = center; i >= left ; i--){  //请注意是连续 和
            leftBorderSum += array[i];
            if (leftBorderSum > maxLeftBorderSum){
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int rightBorderSum = 0, maxRightBorderSum = 0;
        for (int i = center+1; i <= right; i++){
            rightBorderSum += array[i];
            if (rightBorderSum > maxRightBorderSum){
                maxRightBorderSum = rightBorderSum;
            }
        }

        return returnMaxSum(leftSum,rightSum,maxLeftBorderSum + maxRightBorderSum);
    }

    public int returnMaxSum(int leftSum,int rightSum,int sum){
        if (leftSum > rightSum && leftSum > sum){
            return leftSum;
        }else if (rightSum > leftSum && rightSum > sum){
            return rightSum;
        }else {
            return sum;
        }
    }
}
