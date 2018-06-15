package university.KEPU.structures.lab10BST;

public class MainBST {
    public static void main(String[] args) {

        BST tree = new BST();
        int[] arr = {53, 31, 77, 6, 45, 62, 98};

        tree.createBST(arr);

        System.out.println("\n\nMax Node is:");
        tree.inorder(tree.treeMaximum(tree.getRoot()));
        System.out.println("\nMin Node is:");
        tree.inorder(tree.treeMinimum(tree.getRoot()));
        System.out.println("\n");

        tree.inorder(tree.getRoot());
        System.out.println();

        // вставка
        tree.insert(new Node(24));
        System.out.print("Add 24 ->\t");
        tree.inorder(tree.getRoot());
        System.out.println();

        tree.insert(new Node(480));
        System.out.print("Add 480 ->\t");
        tree.inorder(tree.getRoot());
        System.out.println();

        Node node5 = new Node(5);
        tree.insert(node5);
        System.out.print("Add 5 ->\t");
        tree.inorder(tree.getRoot());
        System.out.println();

        tree.insert(new Node(1000));
        System.out.print("Add 1000 ->\t");
        tree.inorder(tree.getRoot());
        System.out.println();

        System.out.println();
        System.out.println("Max Node is:");
        tree.inorder(tree.treeMaximum(tree.getRoot()));
        System.out.println("\nMin Node is:");
        tree.inorder(tree.treeMinimum(tree.getRoot()));
        System.out.println();

        // поиск
        System.out.println("\nSearch element: ");
        tree.inorder(tree.search(tree.getRoot(), 5));
        System.out.println();

        // удаление
        System.out.println("\nBST after Delete element: ");
        tree.delete(node5);
        tree.inorder(tree.getRoot());
    }
}
