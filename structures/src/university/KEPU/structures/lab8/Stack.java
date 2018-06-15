package university.KEPU.structures.lab8;

public class Stack {
    private int stackSize;
    private int[] stackArr;
    private int top;

    public Stack(int size) {
        this.stackSize = size;
        this.stackArr = new int[stackSize];
        this.top = -1;
    }

    public void push(int number) {
        if (isStackFull()) {
            System.out.println("Стек полный, нельзя добавить элементы.");
        }
        System.out.println("Добавление элемента: " + number);
        this.stackArr[++top] = number;
    }

    public int pop() {
        if (isStackEmpty()) {
            System.out.println("Стек пуст. Нельзя удалить элементы.");
        }
        int number = this.stackArr[top--];
        System.out.println("Удаленный элемент: " + number);
        return number;
    }

    public int back() {
        return stackArr[top];
    }

    public boolean isStackEmpty() {
        return (top == -1);
    }

    public boolean isStackFull() {
        return (top == stackSize - 1);
    }

    public void print() {
        for (Integer q : stackArr) {
            System.out.println(q);
        }
    }
}
