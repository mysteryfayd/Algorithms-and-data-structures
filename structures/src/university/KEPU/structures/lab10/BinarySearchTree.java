package university.KEPU.structures.lab10;

public class BinarySearchTree {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Node root;    // корень узла

    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * Метод поиска узла с n значением. Время O(log n)
     * По сути очень простая операция, начинаем поиск с корня (самый верхний элемент дерева), есть пару случаев:
     * - если значение корня больше n, переходим в левую часть дерева и уже там производим поиск
     * - если значение корня меньше n, переходим в правую часть дерева и уже там производим поиск
     * совершая поиск:
     * - если n равен значению узла, возвращаем = true
     * - если мы добрались до листьв (конец дерева), возвращаем = false, не нашли элемент
     **/

    public boolean find(int id) {
        Node current = root;
        while (current != null) {
            if (current.data == id) {
                return true;
            } else if (current.data > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    /**
     * Метод вставки узла с n значением в дерево. Время O(log n)
     * Схож с методом find().
     * Для вставки узла, в первую очередь нужно знать место вставки.
     * Текущий элемент n определяем как корень, сравниваем его с предыдущим корнем
     * - если значение корня больше n, переходим в левую часть дерева
     * - если значение корня меньше n, переходим в правую часть дерева
     * - если в любой момент времени текущий элемент имеет значение NULL,
     * означает что мы уже добрались до конечных узлов, и вставляем свой узел с помощью родительского узла (под него)
     **/

    public void insert(int id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (id < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    /**
     * Метод удаления узла с n значением. Время O(log n)
     * Сложнее чем методы find() и insert(), имеем несколько скучаев:
     * 1 случай: узел, который мы хотим удалить, является конечным узлом (без дочерних элементов)
     * 2 случай: узел, который мы хотим удалить, имеет только один дочерний элемент
     * 3 случай: узел, который мы хотим удалить, имеет два дочерних элемента
     **/

    public boolean delete(int id) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current.data != id) {
            parent = current;
            if (current.data > id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }

        // рассматриваем один из случаев, если нашли узел

        // 1 случай: узел, который мы хотим удалить, является конечным узлом (без дочерних элементов)
        // просто пройдем к этому узлу, отследим сторону в которой он находится (левая или правая)
        // и установим родительскому элементу этого узла значение NULL, в зависимости с какой он стороны находится,
        // если с левой, то parent.left = null,
        // если с правой, то parent.right = null;

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // 2 случай: узел, который мы хотим удалить, имеет только один дочерний элемент
        // просто пройдем к этому узлу, отследим сторону в которой он находится (левая или правая)
        // проверить, на какой стороне дочерний элемент = null (так как у него один дочерний элемент)
        // знаем, что узел, который должен быть удален, на левой стороне
        // берем поодерево удаляемого узла и добавляем его к родительскому удаляемого узла

        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }

            // 3 случай: узел, который мы хотим удалить, имеет два дочерних элемента
            // тут, не выйдет как во втором случае, и нам нужно воспользоватся поиском преемника (Successor) - это узел, который заменит удаленный узел.
            // Преемник - это минимальный узел в правом поддереве узла (который должен быть удален)

            // т.е. находим узел который должен быть удален (понимаем что у него два дочерних элемента),
            // воспользуемся поиском преемника который найдет минимальный узел в правом поддереве удаляемого узла и заменим им удаляемый узел

        } else if (current.left != null && current.right != null) {

            // если мы нашли минимальный элемент в правом поддереве
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node getSuccessor(Node deleleNode) {
        Node successsor = null;
        Node successsorParent = null;
        Node current = deleleNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }

        // проверяем если преемник имеет правого ребенка, он не может иметь левого ребенка
        // если у него есть правый ребенок, добавляем его слева от приемника родителя
        if (successsor != deleleNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }


    /**
     * метод вывода на экран дерева, рекурсивно выводим последовательно всю левую часть дерева, потом правую
     */

    public void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }

    public static void main(String arg[]) {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(3);
        b.insert(8);
        b.insert(1);
        b.insert(4);
        b.insert(6);
        b.insert(2);
        b.insert(10);
        b.insert(9);
        b.insert(20);
        b.insert(25);
        b.insert(15);
        b.insert(16);
        System.out.println("Дерево: ");
        b.display(b.root);
        System.out.println("");
        System.out.println("Проверка, сущетсвует ли элетемент 4 ?: " + b.find(4));
        System.out.println("Удаление узла без детей (2): " + b.delete(2));
        b.display(root);
        System.out.println("\nУдаление узла с одним ребенком (4): " + b.delete(4));
        b.display(root);
        System.out.println("\nУдаление узла с двумя детьми (10): " + b.delete(10));
        b.display(root);
    }
}