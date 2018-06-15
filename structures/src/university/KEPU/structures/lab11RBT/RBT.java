package university.KEPU.structures.lab11RBT;

import java.util.Scanner;

public class RBT {

    private final Node nil = new Node(-1);
    private Node root = nil;

    private final int RED = 0;
    private final int BLACK = 1;

    public class Node {
        int key = -1, color = BLACK;
        Node left = nil;
        Node right = nil;
        Node parent = nil;

        Node(int key) {
            this.key = key;
        }
    }

    public void printTree(Node node) {
        if (node == nil) {
            return;
        }
        printTree(node.left);
        System.out.print(((node.color == RED) ? "Цвет: Красный " : "Цвет: Черный ") + "Ключ: " + node.key + " Родитель: " + node.parent.key + "\n");
        printTree(node.right);
    }

    private Node search(Node searchNode, Node node) {
        if (root == nil) {
            return null;
        }
        if (searchNode.key < node.key) {
            if (node.left != nil) {
                return search(searchNode, node.left);
            }
        } else if (searchNode.key > node.key) {
            if (node.right != nil) {
                return search(searchNode, node.right);
            }
        } else if (searchNode.key == node.key) {
            return node;
        }
        return null;
    }

    private void insert(Node node) {
        Node tmp = root;
        if (root == nil) {
            root = node;
            node.color = BLACK;
            node.parent = nil;
        } else {
            node.color = RED;
            while (true) {
                if (node.key < tmp.key) {
                    if (tmp.left == nil) {
                        tmp.left = node;
                        node.parent = tmp;
                        break;
                    } else {
                        tmp = tmp.left;
                    }
                } else if (node.key >= tmp.key) {
                    if (tmp.right == nil) {
                        tmp.right = node;
                        node.parent = tmp;
                        break;
                    } else {
                        tmp = tmp.right;
                    }
                }
            }
            fixTree(node);
        }
    }

    // в качестве аргумента принимает только что вставленный узел
    private void fixTree(Node node) {
        while (node.parent.color == RED) {
            Node uncle = nil;
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;

                // y = uncle    z = node

                // случай 1 : дядя красный
                if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                }
                // случай 2 : дядя черный
                if (node == node.parent.right) {
                    node = node.parent;
                    rotateLeft(node);
                }
                // случай 3 : дядя черный (в ряд)
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                rotateRight(node.parent.parent);

            } else {
                // случай 4
                uncle = node.parent.parent.left;
                if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                }
                // случай 5
                if (node == node.parent.left) {
                    node = node.parent;
                    rotateRight(node);
                }
                // случай 6
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                rotateLeft(node.parent.parent);
            }
        }
        // перекрашиваем корень в черный
        root.color = BLACK;
    }

    void rotateLeft(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            node.right.parent = node.parent;
            node.parent = node.right;
            if (node.right.left != nil) {
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left = node;
        } else {                                // ротейтим корень
            Node right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = nil;
            root = right;
        }
    }

    void rotateRight(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }

            node.left.parent = node.parent;
            node.parent = node.left;
            if (node.left.right != nil) {
                node.left.right.parent = node;
            }
            node.left = node.left.right;
            node.parent.right = node;
        } else {                                // ротейтим корень
            Node left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = nil;
            root = left;
        }
    }

    // удалим все дерево
    void deleteTree() {
        root = nil;
    }

    void transplant(Node u, Node v) {
        if (u.parent == nil) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    boolean delete(Node z) {
        if ((z = search(z, root)) == null) return false;
        Node x;
        Node y = z; // временная переменная y
        int y_original_color = y.color;

        if (z.left == nil) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == nil) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = treeMinimum(z.right);
            y_original_color = y.color;
            x = y.right;
            if (y.parent == z)
                x.parent = y;
            else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (y_original_color == BLACK)
            deleteFixup(x);
        return true;
    }

    void deleteFixup(Node x) {
        while (x != root && x.color == BLACK) {
            if (x == x.parent.left) {
                Node w = x.parent.right;
                // случай 1
                if (w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    rotateLeft(x.parent);
                    w = x.parent.right;
                }
                // случай 2
                if (w.left.color == BLACK && w.right.color == BLACK) {
                    w.color = RED;
                    x = x.parent;
                    continue;
                    // случай 3
                } else if (w.right.color == BLACK) {
                    w.left.color = BLACK;
                    w.color = RED;
                    rotateRight(w);
                    w = x.parent.right;
                }
                // случай 4
                if (w.right.color == RED) {
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.right.color = BLACK;
                    rotateLeft(x.parent);
                    x = root;
                }
            } else {
                Node w = x.parent.left;
                if (w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    rotateRight(x.parent);
                    w = x.parent.left;
                }
                if (w.right.color == BLACK && w.left.color == BLACK) {
                    w.color = RED;
                    x = x.parent;
                    continue;
                } else if (w.left.color == BLACK) {
                    w.right.color = BLACK;
                    w.color = RED;
                    rotateLeft(w);
                    w = x.parent.left;
                }
                if (w.left.color == RED) {
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.left.color = BLACK;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
        x.color = BLACK;
    }

    Node treeMinimum(Node subTreeRoot) {
        while (subTreeRoot.left != nil) {
            subTreeRoot = subTreeRoot.left;
        }
        return subTreeRoot;
    }

    public void RBTMenu() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "\n1.- Добавить элемент\n"
                            + "2.- Удалить элемент\n"
                            + "3.- Проверить элементы\n"
                            + "4.- Вывести дерево\n"
                            + "5.- Удалить дерево\n");
            int choice = scan.nextInt();

            int item;
            Node node;
            switch (choice) {
                case 1:
                    item = scan.nextInt();
                    while (item != -999) {
                        node = new Node(item);
                        insert(node);
                        item = scan.nextInt();
                    }
                    printTree(root);
                    break;
                case 2:
                    item = scan.nextInt();
                    while (item != -999) {
                        node = new Node(item);
                        System.out.print("\nУдаляемые элемент " + item);
                        if (delete(node)) {
                            System.out.print(": удалено!");
                        } else {
                            System.out.print(": таких элементов нет!");
                        }
                        item = scan.nextInt();
                    }
                    System.out.println();
                    printTree(root);
                    break;
                case 3:
                    item = scan.nextInt();
                    while (item != -999) {
                        node = new Node(item);
                        if (search(node, root) != null) {
                            System.out.print("найден!");
                        } else {
                            System.out.print("не найден");
                        }
                        item = scan.nextInt();
                    }
                    break;
                case 4:
                    printTree(root);
                    break;
                case 5:
                    deleteTree();
                    System.out.println("Дерево удалено!");
                    break;
            }
        }
    }
}
