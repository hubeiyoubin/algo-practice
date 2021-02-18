package com.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yb
 * @date: 2021-2-9
 * 十大经典排序算法
 * 1.冒泡排序
 * 2.选择排序
 * 3.插入排序
 * 4.希尔排序
 * 5.归并排序
 * 6.快速排序
 * 7.堆排序
 * 8.计数排序
 * 9.桶排序
 * 10.基数排序
 */
public class Sorts {


    public static void main(String[] args) {
        int[] array = {1,4,6,3,2,0,5};
        System.out.println("冒泡排序:"+Arrays.toString(bubbleSort(array)));
        System.out.println("选择排序:"+ Arrays.toString(selectionSort(array)));
        System.out.println("插入排序:"+Arrays.toString(insertionSort(array)));
        System.out.println("希尔排序:"+Arrays.toString(shellSort(array)));
        System.out.println("归并排序:"+Arrays.toString(mergeSort(array)));
        System.out.println("快速排序:"+Arrays.toString(quickSort(array)));
    }

    /**
     * 1.冒泡排序
     * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     * 原地排序，属于稳定性排序
     *
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     *
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     *
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if(array == null)
            throw new NullPointerException("array is null");
        if(array.length == 0)
            return array;
        for(int i = 0; i < array.length; i ++){
            for(int j = 0; j < array.length - i - 1; j ++){
                if(array[j] > array[j+1]){
                    swap(array, j, j+1);
                }
            }
        }
        return array;
    }

    /**
     * 交换位置
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j]=temp;
    }



    /**
     *  2.选择排序
     *  最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
     *  原地排序， 非稳定性排序
     *  首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        if (array == null)
            throw new NullPointerException("array is null");
        if (array.length == 0)
            return array;
        for(int i = 0; i < array.length; i ++){
            // 记录最小值的索引
            int minIndex = i;
            for(int j = i; j < array.length; j ++){
                if(array[j] < array[minIndex])
                    minIndex = j;
            }
            swap(array, minIndex, i);
        }
        return array;
    }

    /**
     * 3.插入排序
     *
     * 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     * 稳定性排序
     *
     * 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
     * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        if (array == null)
            throw new NullPointerException("array is null");
        if (array.length == 0)
            return array;

        int cur;
        for(int i = 0; i < array.length - 1; i ++){
            cur = array[i + 1];
            int preIndex = i;
            while(preIndex >= 0 && cur < array[preIndex]){
                // 移动元素
                array[preIndex + 1] = array[preIndex];
                preIndex --;
            }
            array[preIndex + 1] = cur;
        }
        return array;

    }
    /**
     * 4.希尔排序
     * 最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)　
     * 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序
     * 非稳定性排序
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
    /**
     * 5.归并排序
     *最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
     *  稳定排序，需要额外空间，分治法
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array) {
        if (array == null)
            throw new NullPointerException("array is null");
        if (array.length < 2)
            return array;
        int mid = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        for(int i = 0, j = 0, index = 0; index < res.length; index ++){
            if(i >= left.length){
                res[index] = right[j];
                j ++;
            } else if(j >= right.length){
                res[index] = left[i];
                i ++;
            } else if(left[i] < right[j]){
                res[index] = left[i];
                i ++;
            } else if(left[i] > right[j]){
                res[index] = right[j];
                j ++;
            }
        }
        return res;
    }

    /**
     * 6.快速排序
     * 最佳情况：T(n) = O(nlogn)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(nlogn)　
     * 不稳定排序
     * @param array
     * @return
     */
    public static int[] quickSort(int[] array){
        if (array == null)
            throw new NullPointerException("array is null");
        if (array.length < 2)
            return array;
        return quickSort(array, 0, array.length - 1);
    }

    private static int[] quickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end)
            return array;
        // 以small index为中心， 小的放左边，大的放右边，以此进行递归
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            quickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            quickSort(array, smallIndex + 1, end);
        return array;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        }
        return smallIndex;
    }


    /**
     * 7.堆排序算法
     *最佳情况：T(n) = O(nlogn) 最差情况：T(n) = O(nlogn) 平均情况：T(n) = O(nlogn)
     * @param array
     * @return
     */
    //声明全局变量，用于记录数组array的长度；
    static int len;
    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len < 1) return array;
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }
    /**
     * 建立最大堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjustHeap(array, i);
        }
    }
    /**
     * 调整使之成为最大堆
     *
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;

        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 < len && array[i * 2] > array[maxIndex])
            maxIndex = i * 2;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }

    /**
     * 8.计数排序
     * 当输入的元素是n 个0到k之间的整数时，它的运行时间是 O(n + k)。
     *最佳情况：T(n) = O(n+k)  最差情况：T(n) = O(n+k)  平均情况：T(n) = O(n+k)
     * @param array
     * @return
     */
    public static int[] CountingSort(int[] array) {
        if (array.length == 0) return array;
        int bias, min = array[0], max = array[0];
        // 找出待排序的数组中最大和最小的元素；

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        //统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
        //对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        //反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return array;
    }

    //9.桶排序
    /**
     * 桶排序
     * 桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排
     *最佳情况：T(n) = O(n+k)   最差情况：T(n) = O(n+k)   平均情况：T(n) = O(n2)　
     * @param array
     * @param bucketSize
     * @return
     */
    public static ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketCount == 1)
                bucketSize--;
            ArrayList<Integer> temp = BucketSort(bucketArr.get(i), bucketSize);
            for (int j = 0; j < temp.size(); j++)
                resultArr.add(temp.get(j));
        }
        return resultArr;
    }

    /**
     * 10.基数排序
     *
     * 取得数组中的最大数，并取得位数；
     *
     * arr为原始数组，从最低位开始取每个位组成radix数组；
     *
     * 对radix进行计数排序（利用计数排序适用于小范围数的特点）
     * @param array
     * @return
     */
    public static int[] RadixSort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return array;
    }

}
