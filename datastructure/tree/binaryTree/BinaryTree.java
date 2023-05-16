package datastructure.tree.binaryTree;

public class BinaryTree {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.makeLeftChild(node2);
        node1.makeRightChild(node3);
        node2.makeLeftChild(node4);

        System.out.println("node1.getData() = " + node1.getData());
        Node node2Left = node2.getLeftNode();
        System.out.println("node2Left.getData() = " + node2Left.getData());
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
}
