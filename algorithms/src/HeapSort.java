import java.util.Arrays;

public class HeapSort {

    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

//    public static void main(String[] args) {
//        int[] numbers = new int[10000];
//        for (int i = 0; i < numbers.length; i++)
//            numbers[i] = ((int) (Math.random() * 10000 - 1));
//
//        System.out.println("Сортировка. Бинарная пирамида\n\nВходящий массив:\n" + Arrays.toString(numbers));
//        long t = System.currentTimeMillis();
//        sort(numbers);
//        System.out.println("После сортировки:\n" + Arrays.toString(numbers));
//        System.out.println("\nВремя в миллисекундах: " + (System.currentTimeMillis() - t)); //время выполнения сортировки
//    }

    //постройка пирамиды
    public static void buildHeap(int[] a) {
        n = a.length - 1;                       //heap_size
        for (int i = n / 2; i >= 0; i--) {
            heapify(a, i);
        }
    }

    //сохранение свойства невозрастающей пирамиды
    public static void heapify(int[] a, int i) {
        left = 2 * i;
        right = 2 * i + 1;

        if (left < n && a[left] > a[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right < n && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            exchange(i, largest);
            heapify(a, largest);
        }
    }

    public static void exchange(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //сортировка heap
    public static void sortHeap(int[] myArray) {
        a = myArray;
        buildHeap(a);
        for (int i = n; i > 0; i--) {
            exchange(0, i);         //меняем местами корень и последний элемент пирамиды
            n = n - 1;              //heap_size = heap_size - 1
            heapify(a, 0);       //помещяем в корень максимальный элемент
        }
    }
}
