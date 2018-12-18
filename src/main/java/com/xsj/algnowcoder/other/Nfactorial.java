package com.xsj.algnowcoder.other;

/**
 * @program: alg-nowcoder
 * @description: 递归求N的阶乘
 * @author: John_Xia
 * @create: 2018-12-18 21:12
 */
public class Nfactorial{
    public static void main(String[] args){
        int N = 10;
        for(int n = 0; n <= N; n++){
            int fact = factorial(n);
            System.out.println(n + " 的阶乘值是： " + fact);
        }
    }

    // 一个方法的方法体内调用该方法本身就是递归方法。
    public static int factorial(int n){
        if(n < 1) {
            return 1;
        }
        return factorial(n-1) * n;
    }
}