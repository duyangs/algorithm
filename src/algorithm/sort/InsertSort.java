package algorithm.sort;

import algorithm.IArraySort;

import java.util.Arrays;

/**
 * @author DuYang
 * @date 2022/12/13
 * @description 插入排序
 */
public class InsertSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 从下标为1的元素开始选择合适的位置插入，因为元素为0的位置只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {

            // 记录插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }
        }

        return arr;
    }
}
