package algorithm.sort;

import algorithm.IArraySort;
import algorithm.PrintHolder;

/**
 * @author DuYang
 * @date 2022/12/11
 * @description 排序算法测试主类
 */
public class SortTestMain {


    private enum SortType {
        BUBBLE("Bubble sort"),
        SELECTION("Selection sort"),
        INSERT("Insert sort"),
        SHELL("Shell sort");

        private final String name;

        SortType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private static void sortTest(String algorithmName, int[] sourceArray, IArraySort algorithmClass) {
        PrintHolder.getInstance().printHeader(algorithmName, sourceArray);

        try {
            long start = System.currentTimeMillis();
            int[] valueArray = algorithmClass.sort(sourceArray);
            long timeConsumption = System.currentTimeMillis() - start;
            PrintHolder.getInstance().printFooter(algorithmName, valueArray, true, timeConsumption);
        } catch (Exception e) {
            e.printStackTrace();
            PrintHolder.getInstance().printFooter(algorithmName, false, -1L);
        }
    }

    /**
     * 排序器选择
     *
     * @param sortType    排序类型
     * @param sourceArray 待排序数组
     */
    private static void sorterOption(SortType sortType, int[] sourceArray) {
        IArraySort sorter;
        switch (sortType) {
            case BUBBLE: // 冒泡排序
                sorter = new BubbleSort();
                break;
            case SELECTION: // 选择排序
                sorter = new SelectionSort();
                break;
            case INSERT: // 插入排序
                sorter = new InsertSort();
                break;
            case SHELL: // 希尔排序
                sorter = new ShellSort();
                break;
            default:
                sorter = null;
                break;
        }
        if (null == sorter) {
            PrintHolder.getInstance().printInfo("Don`t support this sort type :( !");
            return;
        }
        sortTest(sortType.getName(), sourceArray, sorter);
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{1, 37, 25, 6, 90, 45, 32, 21, 8, 13};
        sorterOption(SortType.SHELL, testArray);
    }
}
