package com.xsj.algnowcoder.other;

/**
 * @program: alg-nowcoder
 * @description: 递归二分查找元素的位置(not index)
 * @author: John_Xia
 * @create: 2018-12-18 21:12
 */
public class CheckIndex {
    /**
     * @param array 查询的数组
     * @param start 开始位置
     * @param end 结束位置
     * @param find 要查找的值
     * @return 值在数组中的位置
     */
    public static int search(int[] array, int start, int end, int find){
        if(array == null){
            return -1;
        }
        // 中间的位置
        int middle = (start + end) / 2;
        if(start <= end){
            // 中间值等于要查找的值，直接返回
            if(array[middle] == find){
                return middle + 1;
                // 中间值小于要查找的值，就在中间值后面继续查找
            }else if(array[middle] < find){
                return search(array, middle + 1, end, find);
            }else{//中间值大于要查找的值，就在中间值前面继续查找
                return search(array, start, middle -1, find);
            }
        }
        // 未查找到，返回-1
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{2,1,3,4,5},0,4,2));
    }
}
