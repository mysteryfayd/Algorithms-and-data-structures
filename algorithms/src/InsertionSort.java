import java.util.Scanner;

public class InsertionSort {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("Выбери номер задания: " +
//                "\n1) Сортировка массива в неубывающем порядке." +
//                "\n2) Сортировка массива в невозрастающем порядке." +
//                "\n3) Поиск элемента в массиве."
//        );
//
//        int numOfOperation = input.nextInt();
//        switch (numOfOperation) {
//            case 1: {
//                insertionSort();
//            }
//            break;
//            case 2: {
//                insertionSort2();
//            }
//            break;
//            case 3: {
//                linerSearch();
//            }
//            break;
//        }
//    }

//    // неубывающий порядок
//    public void insertionSort() {
//        int i, sizeOfArray;
//
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("Введите размер массива: ");
//        sizeOfArray = input.nextInt();
//
//        int myArray[] = new int[sizeOfArray];
//
//        System.out.println("Введите " + sizeOfArray + " чисел");
//        for (i = 0; i < sizeOfArray; i++)
//            myArray[i] = input.nextInt();
//
//        myInsertionSort(myArray);
//
//        System.out.println("\nСортировка в неубывающем порядке: ");
//        for (int j = 0; j < myArray.length; j++)
//            System.out.print(myArray[j] + " ");
//    }

    // алгоритм сортировки в неубывающем порядке
    public static void myInsertionSort(int myArray[]) {
        int n = myArray.length;
        for (int j = 1; j < n; j++) {
            int key = myArray[j];
            int i = j - 1;
            while (i > -1 && myArray[i] > key) {
                myArray[i + 1] = myArray[i];
                i--;
            }
            myArray[i + 1] = key;
        }
    }

//    // алгоритм сортировки в невозрастающем порядке
//    public static void insertionSort2() {
//        int i, sizeOfArray;
//
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("Введите размер массива: ");
//        sizeOfArray = input.nextInt();
//
//        int myArray[] = new int[sizeOfArray];
//
//        System.out.println("Введите " + sizeOfArray + " чисел");
//        for (i = 0; i < sizeOfArray; i++)
//            myArray[i] = input.nextInt();
//
//        myInsertionSort2(myArray);
//
//        System.out.println("\nСортировка в невозрастающем порядке: ");
//        for (int j = 0; j < myArray.length; j++)
//            System.out.print(myArray[j] + " ");
//    }

    // невозрастающий порядок
    public static void myInsertionSort2(int myArray[]) {
        int i = 0;
        int j = myArray.length - 1;
        int tmp;
        while (j > i) {
            tmp = myArray[j];
            myArray[j] = myArray[i];
            myArray[i] = tmp;
            j--;
            i++;
        }
    }

    // поиск по индексу
    public static void linerSearch() {
        int i, sizeOfArray, searchingNum;

        Scanner input = new Scanner(System.in);

        System.out.println("Введите размер массива: ");
        sizeOfArray = input.nextInt();

        int myArray[] = new int[sizeOfArray];

        System.out.println("Введите " + sizeOfArray + " чисел");
        for (i = 0; i < sizeOfArray; i++)
            myArray[i] = input.nextInt();

        System.out.println("Введите число, которое надо найти: ");
        searchingNum = input.nextInt();

        for (i = 0; i < sizeOfArray; i++) {
            if (myArray[i] == searchingNum) {
                System.out.println(searchingNum + " является " + (i + 1) + " по счету в массиве");
                break;
            }
        }
        if (i == sizeOfArray)
            System.out.println("Число " + searchingNum + " не найдено в массиве");
    }
}
