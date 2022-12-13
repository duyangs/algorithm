package algorithm.sort;

import algorithm.IArraySort;

import java.util.Arrays;

/**
 * @author DuYang
 * @date 2022/12/13
 * @description
 */
public class SelectionSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 总共要经过 n-1 轮比较
        for(int i = 0; i < arr.length -1; i++){
            int min = i;

            // 每轮需要比较的次数是 n-i
            for(int j = i+1; j < arr.length; j++){
                if (arr[j] < arr[min]){
                    // 记录目前能找到的最小元素下标
                    min = j;
                }
            }

            if ( i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }
}
