package algorithm;

/**
 * @author DuYang
 * @date 2022/12/13
 * @description
 */
public class PrintHolder {

    private volatile static PrintHolder instance;

    private PrintHolder() {
    }

    public static PrintHolder getInstance() {

        if (instance == null) {
            synchronized (PrintHolder.class) {
                if (instance == null) {
                    instance = new PrintHolder();
                }
            }
        }

        return instance;
    }

    public void printInfo(String des) {
        System.out.println(des);
    }

    public void printArray(int[] printArray, String keyword) {
        System.out.print(keyword + ":" + "\t");
        for (int i : printArray) {
            System.out.print(i + "\t");
        }
        System.out.println("end;");
    }

    public void printHeader(String name, int[] arr) {
        printInfo("----------------------------------------------------");
        printInfo(name);
        printArray(arr, "input");
    }

    public void printFooter(String name, int[] arr, boolean successful, long timeConsumption) {
        printArray(arr, "output");
        printFooter(name, successful, timeConsumption);
    }

    public void printFooter(String name, boolean successful, long timeConsumption) {
        String commonInfo = "\t" + name + "\t" + "execute ";
        String timeConsumptionInfo = "time-consumption: " + timeConsumption;
        if (successful) {
            printInfo("successful!" + commonInfo + "success. " + timeConsumptionInfo);
        } else {
            printInfo("error!" + commonInfo + " failure. " + timeConsumptionInfo);
        }
        printInfo("----------------------------------------------------");
    }
}
