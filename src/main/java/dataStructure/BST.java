package dataStructure;

//BST = Binary Search Tree
public class BST {

    public Node root;

    public class Node{
        public int value;
        public Node left;
        public Node right;


        public Node(int value){
            this.value = value;
        }
    }

    public void insert( int value){
        if(this.root == null){
            this.root = new Node(value);
        }else{
            insert(this.root, value);
        }
    }



    private void insert(Node root, int value) {
        if(root == null) return;
        if(value == root.value) return;
        if ( value > root.value){
            if (root.right == null) root.right = new Node(value);
            else insert(root.right, value);
        }else{
            if (root.left == null) root.left = new Node(value);
            else insert(root.left, value);
        }
    }

    //em ordem exibe os numeros em ordem
    public void inOrder(){
        inOrder( root);
    }
    private void inOrder(final Node node){
        if(node == null) return;

        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }


    //pre ordem exibi os numeros na ordem que foram adicionados
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(final Node node){
        if(node == null) return;

        System.out.println(node.value);

        preOrder(node.left);
        preOrder(node.right);
    }

    public boolean contains(int value){
        return contains(root, value);
    }

    public boolean contains(final Node root, final int value){
        if( root == null) return false;
        if(root.value == value) return true;
        if (value > root.value) return contains(root.right, value);
        else return contains(root.left, value);

    }

    public int minValue(Node currentNode){
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public void deleteNode(int value){
        root = deleteNode(root,value);
    }

    //deletando um nó
    private Node deleteNode(Node root, int value) {
        if(root == null) return null;
        if (value < root.value){
            root.left = deleteNode(root.left,value);
        }else if (value > root.value){
            root.right = deleteNode(root.right,value);
        }else{
            if(root.left == null && root.right == null){
                return null;
            }
            else if (root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }else{
                int minValue = minValue(root.right);
                root.value = minValue;
                root.right = deleteNode(root.right, minValue);

            }
        }
        return root;
    }


    public static void main(String[] args) {

        BST tree = new BST();
        System.out.println("###########################");
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.inOrder();
        System.out.println("###########################");

        System.out.println("###########################");
        tree.insert(7);
        tree.insert(8);
        tree.insert(4);
        tree.inOrder();
        System.out.println("###########################");

        System.out.println("###########################");
        tree.insert(6);
        tree.insert(5);
        tree.insert(9);
        tree.insert(10);
        tree.insert (90);
        tree.insert(85);
        tree.insert(25);
        tree.inOrder();
        System.out.println("###########################");

        System.out.println("###########################");
        tree.preOrder();
        System.out.println("###########################");

        System.out.println(tree.contains(85));

        tree.deleteNode(8);
        System.out.println("###########################");
        tree.inOrder();
        System.out.println("###########################");

    }


}
