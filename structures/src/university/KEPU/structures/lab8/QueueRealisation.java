package university.KEPU.structures.lab8;

public class QueueRealisation {
    private int capacity;       // n
    int queueArray[];
    int head = 0;
    int tail = -1;
    int currentSize = 0;

    public QueueRealisation(int queueSize) {
        this.capacity = queueSize;
        queueArray = new int[this.capacity];
    }

    // добавление элемента в конец очереди (tail)
    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Переполнение (Overflow) ! Невозможно добавить элемент: " + item);
        } else {
            tail++;
            if (tail == capacity - 1) {
                tail = 0;
            }
            queueArray[tail] = item;
            currentSize++;
            System.out.println("Элемент " + item + " добавлен в очередь !");
        }
    }

    // удаление элемента с начала очереди (head)
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Пуст (Underflow) ! Невозможно удалить элемент из очереди ");
        } else {
            head++;
            if (head == capacity - 1) {
                System.out.println("Pop выполнен ! удалено: " + queueArray[head - 1]);
                head = 0;
            } else {
                System.out.println("Pop выполнен ! удалено: " + queueArray[head - 1]);
            }
            currentSize--;
        }
    }

    // проверка, полна ли очередь
    public boolean isQueueFull() {
        boolean status = false;
        if (currentSize == capacity) {
            status = true;
        }
        return status;
    }

    // проверка, пустая ли очередь
    public boolean isQueueEmpty() {
        boolean status = false;
        if (currentSize == 0) {
            status = true;
        }
        return status;
    }

    public void print() {
        for (Integer q : queueArray) {
            System.out.println(q);
        }
    }
}
