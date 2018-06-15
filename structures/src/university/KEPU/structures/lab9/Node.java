package university.KEPU.structures.lab9;

class Node {
    protected int data;
    protected Node next;
    protected Node prev;

    // Конструктор по умолчанию
    public Node() {
        next = null;
        prev = null;
        data = 0;
    }

    // Конструктор с передаваемыми аргументами
    public Node(int d, Node n, Node p) {
        data = d;
        next = n;
        prev = p;
    }

    public void setLinkNext(Node n) {
        next = n;
    }

    public void setLinkPrev(Node p) {
        prev = p;
    }

    public Node getLinkNext() {
        return next;
    }

    public Node getLinkPrev() {
        return prev;
    }

    public void setData(int d) {
        data = d;
    }

    public int getData() {
        return data;
    }
}
