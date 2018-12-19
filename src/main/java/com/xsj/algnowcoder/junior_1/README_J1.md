## 认识时间复杂度
常数时间的操作： 一个操作如果和数据量没有关系， 每次都是固定时间内完成的操作， 叫做常数操作。

时间复杂度为一个算法流程中， 常数操作数量的指标。 常用O（读作big O） 来表示。 具体来说， 在常数操作数量的表达式中，
只要高阶项， 不要低阶项， 也不要高阶项的系数， 剩下的部分如果记为f(N)， 那么时间复杂度为O(f(N))。

评价一个算法流程的好坏， 先看时间复杂度的指标， 然后再分析不同数据样本下的实际运行时间， 也就是常数项时间

## 常用排序的时间复杂度
- Bubble，Insert，Selection 时间复杂度O(N^2)， 额外空间复杂度O(1)
- Shell排序
希尔排序中对于增量序列的选择十分重要，直接影响到希尔排序的性能。我们上面选择的增量序列{n/2,(n/2)/2...1}(希尔增量)，其最坏时间复杂度依然为O(n2)，一些经过优化的增量序列如Hibbard经过复杂证明可使得最坏时间复杂度为O(n3/2)。
- 归并排序
时间复杂度O(N*logN)， 额外空间复杂度O(N)

## 排序的思想
1. 冒泡，以从小到大排序为例，每次都把两个数之间最大的交换到后面，重复此过程，直到这个最大的到了当前数组的最后面，然后排除排好序的值，继续在未排好序的数组中寻找最大值，重复此过程。

2. 选择，..,遍历原数组，把认为最小的交换位置到最前面，重复此过程到遍历完成，把排好序的值排除，继续在未排好序的数组里面找最小值，重复此过程。

3. 插入，..，遍历原数组，从头开始，每次把两个数之间最小的交换到前面，然后继续寻找下一个元素，重复上个过程，操作已经排好序的数组找到这个元素的正确位置

4. 归并，把两个数组分为两个子数组，在子数组里排好序，再做一个help数组，把子数组的元素按顺序merge到help数组里。

5. 希尔排序（shell sort）这个排序方法又称为缩小增量排序，是1959年D·L·Shell提出来的。该方法的基本思想是：设待排序元素序列有n个元素，首先取一个整数increment（小于n）作为间隔将全部元素分为increment个子序列，所有距离为increment的元素放在同一个子序列中，在每一个子序列中分别实行直接插入排序。然后缩小间隔increment，重复上述子序列划分和排序工作。直到最后取increment=1，将所有元素放在同一个子序列中排序为止。

由于开始时，increment的取值较大，每个子序列中的元素较少，排序速度较快，到排序后期increment取值逐渐变小，子序列中元素个数逐渐增多，但由于前面工作的基础，大多数元素已经基本有序，所以排序速度仍然很快。

http://www.cnblogs.com/chengxiao/p/6104371.html

```java
/**
     * 希尔排序
     * @param arrays 需要排序的序列
     */
    public static void sort(int[] arrays){
        if(arrays == null || arrays.length <= 1){
            return;
        }
        //增量
        int incrementNum = arrays.length/2;
        while(incrementNum >=1){
            for(int i=0;i<arrays.length;i++){
                //进行插入排序
                for(int j=i;j<arrays.length-incrementNum;j=j+incrementNum){
                    if(arrays[j]>arrays[j+incrementNum]){
                        int temple = arrays[j];
                        arrays[j] = arrays[j+incrementNum];
                        arrays[j+incrementNum] = temple;
                    }
                }
            }
            //设置新的增量
            incrementNum = incrementNum/2;
        }
    }
```

## 递归

系统在帮你把每一行方法的信息压到栈中，然后在弹栈的过程中帮你算好了结果

master公式的使用
前提是符合T(N) = a*T(N/b) + O(N^d)
1) log(b,a) > d -> 复杂度为O(N^log(b,a))
2) log(b,a) = d -> 复杂度为O(N^d * logN)
3) log(b,a) < d -> 复杂度为O(N^d)

## 归并
也可以用marster公式
例如，将数组分为两部分，分别排序，之后再新建一个数组，一个一个按顺序merge到新数组里
时间复杂度O(N*logN)， 额外空间复杂度O(N)