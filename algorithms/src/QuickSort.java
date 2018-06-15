public class QuickSort {
//    public static void main(String[] args) {
//
//        Integer[] array = new Integer[100];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = ((int) (Math.random() * 100 + 200));
//        }
//
//        System.out.println(Arrays.toString(array));
//        quickSort(array, 0, array.length - 1);
//        System.out.println(Arrays.toString(array));
//    }

    public static void quickSort(Integer[] arr, int low, int high) {
        ;
        // проверить пустой или нулевой массив
        if (arr == null || arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        // Получить опорный элемент из середины списка
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // берем (левый < опорный элемент) и (правый > опорный элемент)
        int i = low, j = high;
        while (i <= j) {
            // Проверяем, пока все значения в левом массиве не будут меньше, чем опорный элемент
            while (arr[i] < pivot) {
                i++;
            }
            // Проверяем, все значения в левом массиве больше, чем опорный элемент
            while (arr[j] > pivot) {
                j--;
            }
            // Теперь сравниваеи значения с обеих сторон списков, чтобы узнать, требуется ли их замена
            // После замены курсора переместить итератор в оба списка
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        // Выполнение той же операции, что и выше, рекурсивно, чтобы отсортировать два вложенных массива
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    public static void swap(Integer array[], int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
