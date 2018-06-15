package university.KEPU.structures.lab10BST;

public class BST {

    // свойства
    private Node root;

    // геттеры и сеттеры
    Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    // метод поиска
    public Node search(Node x, int k) {
        if (x == null || k == x.getKey()) {
            return x;
        }
        if (k < x.getKey()) {
            return search(x.getLeft(), k);
        } else {
            return search(x.getRight(), k);
        }
    }

    // метод вставки
    public void insert(Node z) {
        Node y = null;
        Node x = getRoot();
        while (x != null) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        z.setParent(y);
        if (y == null) {
            setRoot(z);
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }
    }

    // метод вывода
    public void inorder(Node x) {
        if (x != null) {
            inorder(x.getLeft());
            System.out.print(x.getKey() + " ");
            inorder(x.getRight());
        }
    }

    // метод пересадки
    public void transplant(Node u, Node v) {
        if (u.getParent() == null) {
            setRoot(v);
        } else if (u == u.getParent().getLeft()) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }
        if (v != null) {
            v.setParent(u.getParent());
        }
    }

    // метод удаления
    public void delete(Node x) {
        if (x.getLeft() == null) {
            transplant(x, x.getRight());
        } else if (x.getRight() == null) {
            transplant(x, x.getLeft());
        } else {
            Node y = treeMinimum(x.getRight());
            if (y.getParent() != x) {
                transplant(y, y.getRight());
                y.setRight(x.getRight());
                y.getRight().setParent(y);
            }
            transplant(x, y);
            y.setLeft(x.getLeft());
            y.getLeft().setParent(y);
        }
    }

    // поиск минимального
    public Node treeMinimum(Node x) {
        while (x.getLeft() != null) {
            x = x.getLeft();
        }
        return x;
    }

    // поиск максимального
    public Node treeMaximum(Node x) {
        while (x.getRight() != null) {
            x = x.getRight();
        }
        return x;
    }

    // конструктор дерева
    public void createBST(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Node nodeAdd = new Node(arr[i]);
            insert(nodeAdd);
        }
        inorder(root);
    }
}
