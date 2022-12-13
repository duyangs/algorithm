package algorithm.sort;

import algorithm.IArraySort;
import algorithm.PrintHolder;

/**
 * @author DuYang
 * @date 2022/12/11
 * @description 排序算法测试主类
 */
public class SortTestMain {

    private static void sortTest(String algorithmName, int[] sourceArray, IArraySort algorithmClass) {
        PrintHolder.getInstance().printHeader(algorithmName, sourceArray);

        try {
            long start = System.currentTimeMillis();
            int[] valueArray = algorithmClass.sort(sourceArray);
            long timeConsumption = System.currentTimeMillis() - start;
            PrintHolder.getInstance().printFooter(algorithmName, valueArray, true,timeConsumption);
        } catch (Exception e) {
            e.printStackTrace();
            PrintHolder.getInstance().printFooter(algorithmName, false,-1L);
        }
    }

    /**
     * 冒泡排序测试
     */
    private static void bubbleSortTest(int[] sourceArray) {
        BubbleSort bubbleSort = new BubbleSort();
        sortTest("Bubble sort", sourceArray, bubbleSort);
    }

    /**
     * 选择排序
     * @param sourceArray 待排序数组
     */
    private static void selectionSortTest(int[] sourceArray) {
        SelectionSort selectionSort = new SelectionSort();
        sortTest("Selection sort",sourceArray,selectionSort);
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{1, 37, 25, 6, 90, 45, 32, 21, 8, 13};
        bubbleSortTest(testArray);
        selectionSortTest(testArray);
    }
}
