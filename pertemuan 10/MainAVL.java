public class MainAVL {
    public static void main(String[] args) {
        AVL avl = new AVL();
        avl.add(10);
        avl.add(8);
        avl.add(12);
        avl.add(5);
        avl.add(4);
        // avl.add(11);
        // avl.add(8);
        // avl.add(7);
        avl.preorder(avl.root);
        avl.delete(5);
        System.out.println();
        avl.preorder(avl.root);
        avl.delete(1);
        System.out.println();
        avl.preorder(avl.root);
    }
}

class NodeAVL {
    int data, height;
    NodeAVL left, right;

    NodeAVL(int data) {
        this.data = data;
        height = 1;
        left = right = null;
    }
}

class AVL {
    NodeAVL root;

    public int height(NodeAVL N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }

    // fungsi untuk rotasi kanan
    public NodeAVL rightRotate(NodeAVL y) {
        NodeAVL x = y.left;
        NodeAVL T2 = x.right;
        // rotasi kanan
        x.right = y;
        y.left = T2;
        // perbarui tinggi dari node
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    // fungsi untuk rotasi kiri
    public NodeAVL leftRotate(NodeAVL x) {
        NodeAVL y = x.right;
        NodeAVL T2 = y.left;
        // rotasi kiri
        y.left = x;
        x.right = T2;
        // perbarui tinggi dari node
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    // cek faktor keseimbangan node
    public int getBalance(NodeAVL N) {
        if (N == null) {
            return 0;
        }
        return height(N.left) - height(N.right);
    }

    public void add(int data) {
        root = add(root, data);
    }

    public NodeAVL add(NodeAVL node, int data) {
        if (node == null){
            return (new NodeAVL(data));
        }
        if (data < node.data) {
            node.left = add(node.left, data);
        }
        else if (data > node.data) {
            node.right = add(node.right, data);
        }
        else {
            return node;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);
        // right rotation (left of left)
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }
        // left rotation (right of right)
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }
        // left-right rotation (right of left)
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // right-left rotation (left of right)
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public void delete(int data) {
        root = delete(root, data);
    }
    
    public NodeAVL delete(NodeAVL node, int data) {
        // jika tree hanya memiliki satu node
        if (node == null) {
            return node;
        }
        if (data < node.data) {
            node.left = delete(node.left, data);
        } 
        else if (data > node.data) {
            node.right = delete(node.right, data);
        } 
        else {
            // leaf node
            if (node.left == null && node.right == null) {
                return null;
            }
            // memiliki 1 child node
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }
            // memiliki 2 child node
            NodeAVL smallestValue = findSmallestValue(node.right);
            node.data = smallestValue.data;
            node.right = delete(node.right, smallestValue.data);
            return node;
        }
        // perbarui tinggi node
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        // cek faktor keseimbangan node
        int balance = getBalance(node);
        // right rotation (left of left)
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        // left rotation (right of right)
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        // left-right rotation (right of left)
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // right-left rotation (left of right)
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    
    public NodeAVL findSmallestValue(NodeAVL node) {
        NodeAVL current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public NodeAVL findBiggestValue(NodeAVL node) {
        NodeAVL current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public void preorder(NodeAVL current) {
        System.out.print(current.data + " ");
        if (current.left != null) {
            preorder(current.left);
        }
        if (current.right != null) {
            preorder(current.right);
        }
    }

    public void inorder(NodeAVL current) {
        if (current.left != null) {
            inorder(current.left);
        }
        System.out.print(current.data + " ");
        if (current.right != null) {
            inorder(current.right);
        }
    }

    public void postorder(NodeAVL current) {
        if (current.left != null) {
            postorder(current.left);
        }
        if (current.right != null) {
            postorder(current.right);
        }
        System.out.print(current.data + " ");
    }
}