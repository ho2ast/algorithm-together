package datastructure.tree.binaryTree;

public class BinaryTree {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.makeLeftChild(node2);
        node1.makeRightChild(node3);
        node2.makeLeftChild(node4);
        node2.makeRightChild(node5);

        System.out.println("node1.getData() = " + node1.getData());
        Node node2Left = node2.getLeftNode();
        System.out.println("node2Left.getData() = " + node2Left.getData());

        System.out.print("preOrder() : ");
        node1.preOrder(node1);
        System.out.println();
        System.out.print("inOrder() : ");
        node1.inOrder(node1);
        System.out.println();
        System.out.print("postOrder() : ");
        node1.postOrder(node1);
    }
}

class Node {
    private final Object data;
    public Node left;
    public Node right;

    public Node(Object data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void makeLeftChild(Node node) {
        this.left = node;
    }

    public void makeRightChild(Node node) {
        this.right = node;
    }

    public Object getData() {
        return this.data;
    }

    public Node getLeftNode() {
        return this.left;
    }

    public Node getRightNode() {
        return this.right;
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
}
