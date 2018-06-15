package university.KEPU.structures.lab9;

public class LinkedList {
    protected Node head;
    protected Node tail;
    public int size;

    // конструктор
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // проверка, пуст ли список
    public boolean isEmpty() {
        return head == null;
    }

    // метод вывода размерности списка
    public int getSize() {
        return size;
    }

    // метод вставки элемента в начало списка
    public void insertAtStart(int val) {
        Node nptr = new Node(val, null, null);
        if (head == null) {
            head = nptr;
            tail = head;
        } else {
            head.setLinkPrev(nptr);
            nptr.setLinkNext(head);
            head = nptr;
        }
        size++;
    }

    // метод вставки элемента в конец списка
    public void insertAtEnd(int val) {
        Node nptr = new Node(val, null, null);
        if (head == null) {
            head = nptr;
            tail = head;
        } else {
            nptr.setLinkPrev(tail);
            tail.setLinkNext(nptr);
            tail = nptr;
        }
        size++;
    }

    // метод вставки заданного элемента по позиции в списке
    public void insertAtPos(int val, int pos) {
        Node nptr = new Node(val, null, null);
        if (pos == 1) {
            insertAtStart(val);
            return;
        }
        Node ptr = head;
        for (int i = 2; i <= size; i++) {
            if (i == pos) {
                Node tmp = ptr.getLinkNext();
                ptr.setLinkNext(nptr);
                nptr.setLinkPrev(ptr);
                nptr.setLinkNext(tmp);
                tmp.setLinkPrev(nptr);
            }
            ptr = ptr.getLinkNext();
        }
        size++;
    }

    // метод удаления заданного элемента по позиции в списке
    public void deleteAtPos(int pos) {
        if (pos == 1) {
            if (size == 1) {
                head = null;
                tail = null;
                size = 0;
                return;
            }
            head = head.getLinkNext();
            head.setLinkPrev(null);
            size--;
            return;
        }
        if (pos == size) {
            tail = tail.getLinkPrev();
            tail.setLinkNext(null);
            size--;
        }
        Node ptr = head.getLinkNext();
        for (int i = 2; i <= size; i++) {
            if (i == pos) {
                Node p = ptr.getLinkPrev();
                Node n = ptr.getLinkNext();

                p.setLinkNext(n);
                n.setLinkPrev(p);
                size--;
                return;
            }
            ptr = ptr.getLinkNext();
        }
    }

    // метод вывода списка на экран
    public void display() {
        System.out.print("Двусвязный список = ");
        if (size == 0) {
            System.out.print("пуст\n");
            return;
        }
        if (head.getLinkNext() == null) {
            System.out.println(head.getData());
            return;
        }
        Node ptr = head;
        System.out.print(head.getData() + " <-> ");
        ptr = head.getLinkNext();
        while (ptr.getLinkNext() != null) {
            System.out.print(ptr.getData() + " <-> ");
            ptr = ptr.getLinkNext();
        }
        System.out.print(ptr.getData() + "\n");
    }
}
