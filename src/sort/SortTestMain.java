package sort;

/**
 * @author DuYang
 * @date 2022/12/11
 * @description 排序算法测试主类
 */
public class SortTestMain {

    private static void printDes(String des){
        System.out.println(des);
    }

    private static void printArray(int[] paintArray, String keyword) {
        System.out.print(keyword + ":" + "\t");
        for (int i : paintArray) {
            System.out.print(i + "\t");
        }
        System.out.println("end;");
    }

    /**
     * 冒泡排序测试
     */
    public static void bubbleSortTest() {
        printDes("冒泡排序");
        int[] testArray = new int[]{1, 37, 25, 6, 90, 45, 32, 21, 8, 13};
        printArray(testArray,"input");

        BubbleSort bubbleSort = new BubbleSort();
        try {
            int[] valueArray = bubbleSort.sort(testArray);
            printArray(valueArray,"output");
            printDes("success 冒泡排序算法执行成功");
        } catch (Exception e) {
            e.printStackTrace();
            printDes("err 冒泡排序算法执行错误");
        }
    }

    public static void main(String[] args) {
        bubbleSortTest();
    }
}
