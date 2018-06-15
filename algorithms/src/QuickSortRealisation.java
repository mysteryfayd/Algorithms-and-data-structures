import java.util.Arrays;

public class QuickSortRealisation {

//    public static void main(String args[]) {
//
//        int[] input = { 23, 31, 1, 21, 36, 72};
//        System.out.println("Before sorting : " + Arrays.toString(input));
//        quickSort(input); // sort the integer array using quick sort algorithm
//        System.out.println("After sorting : " + Arrays.toString(input));
//
//        // input with duplicates
//        int[] withDuplicates = { 11, 14, 16, 12, 11, 15};
//        System.out.println("Before sorting : " + Arrays.toString(withDuplicates));
//        quickSort(withDuplicates); // sort the integer array using quick sort algorithm
//        System.out.println("After sorting : " + Arrays.toString(withDuplicates));
//    }

    public static void quickSort(int[] array) {
        recursiveQuickSort(array, 0, array.length - 1);
    }

    /**
     * Логика рекурсивной быстрой сортировки
     * array        входной массив
     * startIdx     начальный индекс массива
     * конечный     индекс массива
     */

    public static void recursiveQuickSort(int[] array, int startIdx, int endIdx) {

        int idx = partition(array, startIdx, endIdx);

        // Рекурсивный вызов быстрой сортировки в левом подразделении массива
        if (startIdx < idx - 1) {
            recursiveQuickSort(array, startIdx, idx - 1);
        }

        // Рекурсивный вызов быстрой сортировки в правом подразделении массива
        if (endIdx > idx) {
            recursiveQuickSort(array, idx, endIdx);
        }
    }

    /**
     * Разделяет массив от опорного элемента (pivot),
     * левая сторона содержит элементы меньше чем опорный элемент в то время как
     * правая сторона содержит элементы больше, чем опорный элемент.
     *
     * array    разделенный (partitioned) массив
     * left     нижняя граница массива
     * right    верхняя граница массива
     * return   разделенный индекс левой части
     */
    public static int partition(int[] array, int left, int right) {
        int pivot = array[left]; // принимает первый элемент в качестве опорного элемента

        while (left <= right) {
            //  поиск номер, который больше, чем опорный элемент (pivot), снизу вверх
            while (array[left] < pivot) {
                left++;
            }
            // поиск номер, который меньше, чем опорный элемент, сверху вниз
            while (array[right] > pivot) {
                right--;
            }

            // поменять местами значения
            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;

                // увеличиваем левый индекс и уменьшаем правый индекс
                left++;
                right--;
            }
        }
        return left;
    }
}
