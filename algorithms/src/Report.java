import java.util.Arrays;
import java.util.Scanner;

public class Report {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int sizeOfArray = input.nextInt();

        int[] list = new int[sizeOfArray];  // исходный массив
        int[] listRand;                     // рандомный массив
        int[] listAscending;                // возрастающий массив
        int[] listDescending;               // убывающий массив

        // заполняем массив случайными числами
        for (int i = 0; i < sizeOfArray; i++) {
            list[i] = ((int) (Math.random() * 999 - 1));
        }

        // массив хранящий случайные числа
        listRand = Arrays.copyOf(list, sizeOfArray);
        System.out.println("Случайные числа: " + Arrays.toString(listRand));

        // массив хранящий числа по возрастанию
        Arrays.sort(list);
        listAscending = Arrays.copyOf(list, sizeOfArray);
        System.out.println("Числа по возрастанию: " + Arrays.toString(listAscending));

        // массив хранящий числа по убыванию
        for (int i = 0; sizeOfArray / 2 > i; i++) {
            int tmp = list[i];
            list[i] = list[sizeOfArray - i - 1];
            list[sizeOfArray - i - 1] = tmp;
        }

        listDescending = Arrays.copyOf(list, sizeOfArray);
        System.out.println("Числа по убыванию: " + Arrays.toString(listDescending));

        System.out.println("\n\n=============================== INSERTION SORT ===============================");
        insertionSortResult(listRand, listAscending, listDescending);

        System.out.println("\n\n=============================== MERGE SORT ===============================");
        mergeSortResult(listRand, listAscending, listDescending);

        System.out.println("\n\n=============================== HEAP SORT ===============================");
        heapSortResult(listRand, listAscending, listDescending);

        System.out.println("\n\n=============================== QUICK SORT ===============================");
        quickSortResult(listRand, listAscending, listDescending);

        System.out.println("\n\n=============================== BUCKET SORT ===============================");
        int maxValue = BucketSortRealisation.maxValue(listRand);
        bucketSortResult(listRand, listAscending, listDescending, maxValue);
    }

    public static void insertionSortResult(int[] listRand, int[] listAscending, int[] listDescending) {
        InsertionSort insertionSortObj = new InsertionSort();

        int [] listRandCopy = Arrays.copyOf(listRand, listRand.length);
        int [] listAscendingCopy = Arrays.copyOf(listAscending, listAscending.length);
        int [] listDescendingCopy = Arrays.copyOf(listDescending, listDescending.length);

        //System.out.println("\nПодаваемый массив: " + Arrays.toString(listRandCopy));
        long timeRandIS = System.currentTimeMillis();
        insertionSortObj.myInsertionSort(listRandCopy);
        //System.out.println("Сортировка случайных чисел: " + Arrays.toString(listRandCopy));
        System.out.println("Время в милисекундах: " + (System.currentTimeMillis() - timeRandIS));               //время выполнения сортировки

        //System.out.println("\nПодаваемый массив: " + Arrays.toString(listAscendingCopy));
        long timeAscendingIS = System.currentTimeMillis();
        insertionSortObj.myInsertionSort(listAscendingCopy);
        //System.out.println("Сортировка чисел отсортированного массива: " + Arrays.toString(listAscendingCopy));
        System.out.println("Время в милисекундах: " + (System.currentTimeMillis() - timeAscendingIS));         //время выполнения сортировки

        //System.out.println("\nПодаваемый массив: " + Arrays.toString(listDescendingCopy));
        long timeDescendingIS = System.currentTimeMillis();
        insertionSortObj.myInsertionSort(listDescendingCopy);
        //System.out.println("Сортировка чисел отсортированного массива в обратном порядке: " + Arrays.toString(listDescendingCopy));
        System.out.println("Время в милисекундах: " + (System.currentTimeMillis() - timeDescendingIS));         //время выполнения сортировки
    }

    public static void mergeSortResult(int[] listRand, int[] listAscending, int[] listDescending) {
        MergeSortRealisation mergeSortObj = new MergeSortRealisation();

        int [] listRandCopy = Arrays.copyOf(listRand, listRand.length);
        int [] listAscendingCopy = Arrays.copyOf(listAscending, listAscending.length);
        int [] listDescendingCopy = Arrays.copyOf(listDescending, listDescending.length);

        //System.out.println("\nПодаваемый массив: " + Arrays.toString(listRandCopy));
        long timeRandMS = System.currentTimeMillis();
        mergeSortObj.mergeRecursionSort(listRandCopy);
        //System.out.println("Сортировка случайных чисел: " + Arrays.toString(listRandCopy));
        System.out.println("Время в милисекундах: " + (System.currentTimeMillis() - timeRandMS));               //время выполнения сортировки

        //System.out.println("\nПодаваемый массив: " + Arrays.toString(listAscendingCopy));
        long timeAscendingMS = System.currentTimeMillis();
        mergeSortObj.mergeRecursionSort(listAscendingCopy);
        //System.out.println("Сортировка чисел отсортированного массива: " + Arrays.toString(listAscendingCopy));
        System.out.println("Время в милисекундах: " + (System.currentTimeMillis() - timeAscendingMS));         //время выполнения сортировки

        //System.out.println("\nПодаваемый массив: " + Arrays.toString(listDescendingCopy));
        long timeDescendingMS = System.currentTimeMillis();
        mergeSortObj.mergeRecursionSort(listDescendingCopy);
        //System.out.println("Сортировка чисел отсортированного массива в обратном порядке: " + Arrays.toString(listDescendingCopy));
        System.out.println("Время в милисекундах: " + (System.currentTimeMillis() - timeDescendingMS));         //время выполнения сортировки
    }

    public static void heapSortResult(int[] listRand, int[] listAscending, int[] listDescending) {
        HeapSort heapSortObj = new HeapSort();

        int [] listRandCopy = Arrays.copyOf(listRand, listRand.length);
        int [] listAscendingCopy = Arrays.copyOf(listAscending, listAscending.length);
        int [] listDescendingCopy = Arrays.copyOf(listDescending, listDescending.length);

        //System.out.println("\nПодаваемый массив: " + Arrays.toString(listRandCopy));
        long timeRandHS = System.currentTimeMillis();
        heapSortObj.sortHeap(listRandCopy);
        //System.out.println("Сортировка случайных чисел: " + Arrays.toString(listRandCopy));
        System.out.println("Время в милисекундах: " + (System.currentTimeMillis() - timeRandHS));               //время выполнения сортировки

        //System.out.println("\nПодаваемый массив: " + Arrays.toString(listAscendingCopy));
        long timeAscendingHS = System.currentTimeMillis();
        heapSortObj.sortHeap(listAscendingCopy);
        //System.out.println("Сортировка чисел отсортированного массива: " + Arrays.toString(listAscendingCopy));
        System.out.println("Время в милисекундах: " + (System.currentTimeMillis() - timeAscendingHS));         //время выполнения сортировки

        //System.out.println("\nПодаваемый массив: " + Arrays.toString(listDescendingCopy));
        long timeDescendingHS = System.currentTimeMillis();
        heapSortObj.sortHeap(listDescendingCopy);
        //System.out.println("Сортировка чисел отсортированного массива в обратном порядке: " + Arrays.toString(listDescendingCopy));
        System.out.println("Время в милисекундах: " + (System.currentTimeMillis() - timeDescendingHS));         //время выполнения сортировки
    }

    public static void quickSortResult(int[] listRand, int[] listAscending, int[] listDescending) {
        QuickSortRealisation quickSortObj = new QuickSortRealisation();

        int [] listRandCopy = Arrays.copyOf(listRand, listRand.length);
        int [] listAscendingCopy = Arrays.copyOf(listAscending, listAscending.length);
        int [] listDescendingCopy = Arrays.copyOf(listDescending, listDescending.length);

        //System.out.println("\nПодаваемый массив: " + Arrays.toString(listRandCopy));
        long timeRandHS = System.currentTimeMillis();
        quickSortObj.quickSort(listRandCopy);
        //System.out.println("Сортировка случайных чисел: " + Arrays.toString(listRandCopy));
        System.out.println("Время в милисекундах: " + (System.currentTimeMillis() - timeRandHS));               //время выполнения сортировки

        //System.out.println("\nПодаваемый массив: " + Arrays.toString(listAscendingCopy));
        long timeAscendingHS = System.currentTimeMillis();
        quickSortObj.quickSort(listAscendingCopy);
        //System.out.println("Сортировка чисел отсортированного массива: " + Arrays.toString(listAscendingCopy));
        System.out.println("Время в милисекундах: " + (System.currentTimeMillis() - timeAscendingHS));         //время выполнения сортировки

        //System.out.println("\nПодаваемый массив: " + Arrays.toString(listDescendingCopy));
        long timeDescendingHS = System.currentTimeMillis();
        quickSortObj.quickSort(listDescendingCopy);
        //System.out.println("Сортировка чисел отсортированного массива в обратном порядке: " + Arrays.toString(listDescendingCopy));
        System.out.println("Время в милисекундах: " + (System.currentTimeMillis() - timeDescendingHS));         //время выполнения сортировки
    }

    public static void bucketSortResult(int[] listRand, int[] listAscending, int[] listDescending, int maxValue) {
        BucketSortRealisation bucketSortObj = new BucketSortRealisation();

        int[] listRandCopy = Arrays.copyOf(listRand, listRand.length);
        int[] listAscendingCopy = Arrays.copyOf(listAscending, listAscending.length);
        int[] listDescendingCopy = Arrays.copyOf(listDescending, listDescending.length);

        //System.out.println("\nПодаваемый массив: " + Arrays.toString(listRandCopy));
        //System.out.print("Сортировка случайных чисел: ");
        long timeRandBS = System.currentTimeMillis();
        bucketSortObj.printSequence(bucketSortObj.sort(listRandCopy, maxValue));
        System.out.println("Время в милисекундах: " + (System.currentTimeMillis() - timeRandBS));               //время выполнения сортировки

        //System.out.println("\nПодаваемый массив: " + Arrays.toString(listAscendingCopy));
        //System.out.print("Сортировка чисел отсортированного массива: ");
        long timeAscendingBS = System.currentTimeMillis();
        bucketSortObj.printSequence(bucketSortObj.sort(listAscendingCopy, maxValue));
        System.out.println("Время в милисекундах: " + (System.currentTimeMillis() - timeAscendingBS));         //время выполнения сортировки

        //System.out.println("\nПодаваемый массив: " + Arrays.toString(listDescendingCopy));
        //System.out.print("Сортировка чисел отсортированного массива в обратном порядке: ");
        long timeDescendingBS = System.currentTimeMillis();
        bucketSortObj.printSequence(bucketSortObj.sort(listDescendingCopy, maxValue));
        System.out.println("Время в милисекундах: " + (System.currentTimeMillis() - timeDescendingBS));         //время выполнения сортировки
    }

}
