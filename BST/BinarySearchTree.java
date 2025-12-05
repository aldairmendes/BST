public class BinarySearchTree {
    Node root;

    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    private Node insertRecursive(Node current, int key) {
        if (current == null) {
            return new Node(key);
        }
        if (key < current.key) {
            current.left = insertRecursive(current.left, key);
        } else if (key > current.key) {
            current.right = insertRecursive(current.right, key);
        }
        return current;
    }

    public Node find(int key) {
        return findRecursive(root, key);
    }
    
    private Node findRecursive(Node current, int key) {
        if(current == null) {
            System.out.println("404 - Not found.");
            return null;
        }
        if(current.key == key) {
            return current;
        }
        if(current.key > key) {
            return findRecursive(current.left, key);
        } else {
            return findRecursive(current.right, key);
        }
    }
    
    public void delete(int key) {
        deleteRecursive(root, key);
    }
    
    private void deleteRecursive(Node current, int key) {
        if(current == null) {
            System.out.println("404 - Not found.");
            return;
        }

        if(current.key > key) {
            deleteRecursive(current.left, key);
        }

        if(current.key < key) {
            deleteRecursive(current.right, key);
        }

        if(current.key == key) {

            if(current.left != null) {

                if(current.right != null) {
                    var left = current.left;
                    current.left = current.right;
                    current = left;
                }
                current = current.left;
            }
        }
    }
    public void print() {
        printRecursive(root);
    }

    public void printRecursive(Node current) {
        if(current == null) {
            return;
        }
        printRecursive(current.left);
        System.out.println(current);
        printRecursive(current.right);
    }
}
