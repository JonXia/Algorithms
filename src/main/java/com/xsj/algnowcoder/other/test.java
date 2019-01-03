package com.xsj.algnowcoder.other;

import java.lang.reflect.Array;

public class test {

    public static void main(String[] args) {
        int[] intArray = new int[]{1,2,3,1};// 新建一个数组用来保存num每一位的数字

        MySolution m=new MySolution();
        m.nextPermutation(intArray);

        for (int i = 0; i < intArray.length; i++) {// 遍历打印int[],察看运行结果.
            System.out.print(intArray[i] + " ");
        }
    }

    public static class MySolution {
        public void nextPermutation(int[] ints) {
            int i = ints.length-2;
//            坐标移到倒数第二个
            while ( ints[i] >= ints[i + 1] && i >= 0) {
//                倒数第二个比第一个大
                i--;
                if (i<0) return;
            }

            if (i >= 0) {
//                如果没遍历完
                int j = ints.length - 1;
//                就和倒数第一的比
                while (j >= 0 && ints[i] >= ints[j]) {
//                倒数第一个
                    j--;
//                    比完，游标移动
                }

                swap(ints, i, j);
            }

            reverse(ints, i + 1);
        }

        private void reverse(int[] nums, int start) {
            int end = nums.length - 1;
            while (start <= end) {
                int tmp = nums[start];
                nums[start++] = nums[end];
                nums[end--] = tmp;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
