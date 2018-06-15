import java.util.Arrays;

public class MergeSortRealisation {
//    public static void main(String[] args) {
//
//        //lg 16 = 4
//        //lg 32 = 5
//        //lg 1024 = 10
//        //O(n lg n) - n кол-во операций, lg n кол-во уровней
//
//        //int [] list = {7, 3, 4, 9, 5, 1, 2, 6};
//
//        int[] list = new int[10000];
//        for (int i = 0; i < list.length; i++) {
//            list[i] = ((int) (Math.random() * 10000 - 1));
//        }
//
//        System.out.println("Входящий массив: " + "\n" + Arrays.toString(list));
//        long t = System.currentTimeMillis();
//        mergeRecursionSort(list);
//        System.out.println("\nПосле сортировки слиянеем: " + "\n" + Arrays.toString(list));
//        System.out.println("\nВремя в милисекундах: " + (System.currentTimeMillis() - t));     //время выполнения сортировки
//    }

    public static void mergeRecursionSort(int[] array) {
        if (array.length > 1) {
            int[] left = leftHalfOfArray(array);
            int[] right = rightHalfOfArray(array);

            mergeRecursionSort(left);
            mergeRecursionSort(right);

            merge(array, left, right);
        }
    }

    private static int[] leftHalfOfArray(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++)
            left[i] = array[i];
        return left;
    }

    private static int[] rightHalfOfArray(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++)
            right[i] = array[i + size1];
        return right;
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
    }
}
