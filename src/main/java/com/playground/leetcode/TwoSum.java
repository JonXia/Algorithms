package com.playground.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 一遍哈希表
 * @author JonXia     jonxia@microwu.com
 * @date 2019/4/29 11:29
 * Update History:
 * Author            Time            Content
 */
public class TwoSum {
    /*
     为了对运行时间复杂度进行优化，我们需要一种更有效的方法来检查数组中是否存在目标元素。如果存在，我们需要找出它的索引。保持数组中的每个元素与其索引相互对应的最好方法是什么？哈希表。
     在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回。
     */
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                if (map.containsKey(diff)) {
                    return new int[]{map.get(diff), i};
                }
                map.put(nums[i], i);
            }

            throw new IllegalArgumentException();
        }
    }


    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) {

        int[] ret = new Solution().twoSum(new int[]{2,6,5}, 8);
        System.out.println(integerArrayToString(ret, ret.length));
    }
}
