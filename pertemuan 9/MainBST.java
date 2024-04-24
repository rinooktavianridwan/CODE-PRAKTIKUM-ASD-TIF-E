
public class MainBST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST bst = new BST();
        bst.add(12);
        bst.add(8);
        bst.add(19);
        bst.add(10);
        bst.add(20);
        bst.add(15);
        bst.add(6);
        bst.preorder(bst.root);
        System.out.println();
        bst.delete(12);
        bst.preorder(bst.root);
        System.out.println();
        bst.add(12);
        bst.preorder(bst.root);

    }
}

class NodeBST {
    int data;
    NodeBST left, right;

    public NodeBST(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST {
    NodeBST root;

    public void add(int data) {
        root = add(root, data);
    }

    public NodeBST add(NodeBST current, int data) {
        NodeBST temp = current;
        if (temp == null) {
            temp = new NodeBST(data);
        } else if (data < current.data) {
            temp.left = add(current.left, data);
        } else if (data > current.data) {
            temp.right = add(current.right, data);
        }
        return temp;
    }


    public void delete(int data) {
        root = delete(root, data);
    }

    public NodeBST delete(NodeBST current, int data) {
        if (current == null) {
            return null;
        }
        if (data < current.data) {
            current.left = delete(current.left, data);
            return current;
        } else if (data > current.data) {
            current.right = delete(current.right, data);
            return current;
        } else {
            // jika data yang akan dihapus merupakan leaf node
            if (current.left == null && current.right == null) {
                return null;
            }
            // jika data yang dihapus memiliki 1 child node
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            // jika data yang dihapus memiliki 2 child node
            int smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = delete(current.right, smallestValue);
            return current;
        }
    }

    public int findSmallestValue(NodeBST root) {
        if (root.left == null) {
            return root.data;
        } else {
            return findSmallestValue(root.left);
        }
    }

    public int findBiggestValue(NodeBST root) {
        if (root.right == null) {
            return root.data;
        } else {
            return findBiggestValue(root.right);
        }
    }

    public void preorder(NodeBST current) {
        System.out.print(current.data + " ");
        if (current.left != null) {
            preorder(current.left);
        }
        if (current.right != null) {
            preorder(current.right);
        }
    }
}