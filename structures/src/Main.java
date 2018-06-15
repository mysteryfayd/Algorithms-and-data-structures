//import university.KEPU.structures.lab8.StackRealisation;

import university.KEPU.structures.lab9.LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Введи номер структуры с которой хочешь работать: ");
//        System.out.println("1) Стек");
//        System.out.println("2) Очередь");
//
//        Scanner switchChoice = new Scanner(System.in);
//        int choice = switchChoice.nextInt();
//        switch (choice) {
//            case 1: {
//                //StackRealisation stack = new StackRealisation();
//                Stack stack = new Stack(3);
//
////                System.out.println(
////                        "Stack functions: " +
////                                "\npush - добавляет в стек число." +
////                                "\npop  - удаляет из стека последнее число." +
////                                "\nback  - вывод последнего элемента в стеке." +
////                                "\nsize - вывод количества элементов в стеке." +
////                                "\nprint - вывод стека." +
////                                "\nclear - очистить стек" +
////                                "\nexit - завершение работы со стеком.\n"
////                );
//
//                System.out.println(
//                        "Stack functions: " +
//                                "\npush - добавляет в стек число." +
//                                "\npop  - удаляет из стека последнее число." +
//                                "\nback  - вывод последнего элемента в стеке без удаления." +
//                                "\nprint - вывод стека." +
//                                "\nexit - завершение работы со стеком.\n"
//                );
//
//                Scanner input = new Scanner(System.in);
//                int number;
//                String request;
//
//                System.out.println("Введи операцию: ");
//
////                while (input.hasNextLine()) {
////                    request = input.next();
////                    if (request.equals("push")) {
////                        number = input.nextInt();
////                        stack.push(number);
////                        System.out.println("ok");
////                    } else if (request.equals("pop")) System.out.println(stack.pop());
////                    else if (request.equals("back")) System.out.println(stack.back());
////                    else if (request.equals("size")) System.out.println(stack.size());
////                    else if (request.equals("print")) {
////                        stack.print();
////                    } else if (request.equals("clear")) {
////                        stack.clear();
////                        System.out.println("ok");
////                    } else if (request.equals("exit")) {
////                        System.out.println(stack.exit());
////                        break;
////                    }
////
////                }
//                while (input.hasNextLine()) {
//                    request = input.next();
//                    if (request.equals("push")) {
//                        number = input.nextInt();
//                        stack.push(number);
//                    } else if (request.equals("pop")) System.out.println(stack.pop());
//                    else if (request.equals("back")) System.out.println(stack.back());
//                    else if (request.equals("print")) {
//                        stack.print();
//                    } else if (request.equals("exit")) {
//                        break;
//                    }
//                }
//                break;
//            }
//            case 2: {
//                QueueRealisation queue = new QueueRealisation(4);
//
//                System.out.println(
//                        "Queue functions: " +
//                                "\nenqueue - добавляет число в очередь ." +
//                                "\ndequeue - удаляет из очереди элемента." +
//                                "\nprint - вывод очереди." +
//                                "\nexit - завершение работы с очередью.\n"
//                );
//
//                Scanner input = new Scanner(System.in);
//                int number;
//                String request;
//
//                System.out.println("Введи операцию: ");
//
//                while (input.hasNextLine()) {
//                    request = input.next();
//                    if (request.equals("enqueue")) {
//                        number = input.nextInt();
//                        queue.enqueue(number);
//                    } else if (request.equals("dequeue")) {
//                        queue.dequeue();
//                    } else if (request.equals("print")) {
//                        queue.print();
//                    } else if (request.equals("exit")) {
//                        break;
//                    }
//                }
//                break;
//            }
//        }

        Scanner scan = new Scanner(System.in);
        LinkedList list = new LinkedList();
        System.out.println("Двусвязный список");
        char ch;

        do {
            System.out.println("\nРабота с двусвязным списком:");
            System.out.println(
                    "1) Вставка в начало 2) Вставка в конец 3) Вставка в заданную позицию 4) Удаление из заданной позиции 5) Проверка на пустоту 6) Проверка на размерность"
            );

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Введите число для вставки в начало списка");
                    list.insertAtStart(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Введите число для вставки в конец списка");
                    list.insertAtEnd(scan.nextInt());
                    break;
                case 3:
                    System.out.println("Введите число для вставки в список");
                    int num = scan.nextInt();
                    System.out.println("Введите позицию");
                    int pos = scan.nextInt();
                    if (pos < 1 || pos > list.getSize())
                        System.out.println("Неверная позиция\n");
                    else
                        list.insertAtPos(num, pos);
                    break;
                case 4:
                    System.out.println("Введите позицию");
                    int p = scan.nextInt();
                    if (p < 1 || p > list.getSize())
                        System.out.println("Неверная позиция\n");
                    else
                        list.deleteAtPos(p);
                    break;
                case 5:
                    System.out.println("Пуст ли список = " + list.isEmpty());
                    break;
                case 6:
                    System.out.println("Размер = " + list.getSize() + " ");
                    break;
                default:
                    System.out.println("Не корректный номер операции \n ");
                    break;
            }

            list.display();
            System.out.println("\nПродолжить работу со списком? (Введите д или н)");
            ch = scan.next().charAt(0);
        } while (ch == 'Д' || ch == 'д');
    }
}
