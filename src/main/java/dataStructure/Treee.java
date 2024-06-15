package dataStructure;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Treee {
    public Node root;
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }

        public boolean isLeaf(){
            return  (this.left == null) && (this.right ==null);
        }
    }

    public void insert(int value){
        if(root == null) root = new Node(value);
        else{
            Node newNode = new Node(value);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while(queue.size() > 0){
                Node currentNode = queue.remove();
                if(currentNode.left == null){
                    currentNode.left = newNode;
                    break;
                }else{
                    queue.add(currentNode.left);
                }
                if(currentNode.right == null){
                    currentNode.right = newNode;
                    break;
                }else{
                    queue.add(currentNode.right);
                }
            }
        }
    }

    //travessia: ordem

    //pré-ordem (R-E-D)

    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(final Node node){
        if(node == null) return;

        System.out.println(node.value);

        preOrder(node.left);
        preOrder(node.right);
    }

    //Em Ordem (E-R-D)

    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(final Node node){
        if(node == null) return;

        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    //Pós Ordem (E-D-R)

    public void posOrder(){
        posOrder(root);
    }
    private void posOrder(final Node node){
        if(node == null) return;

        posOrder(node.left);
        posOrder(node.right);
        System.out.println(node.value);
    }

    //Busca em Largura (BFS)

    public void BFS(){
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.remove();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

            System.out.println(node.value);
        }
    }

    //Busca em Profundidade (DFS) utilisa o mesmo algoritmo de pré ordem.



    public static void main(String[] args) {
        Treee tree = new Treee();

        tree.insert(37);
        tree.insert(11);
        tree.insert(66);
        tree.insert(8);
        tree.insert(17);
        tree.insert(42);
        tree.insert(72);


        System.out.println("####################");
        System.out.println("PRE ORDEM");
        System.out.println("####################");
        tree.preOrder();
        System.out.println("####################");

        System.out.println("####################");
        System.out.println("EM ORDEM");
        System.out.println("####################");
        tree.inOrder();
        System.out.println("####################");

        System.out.println("####################");
        System.out.println("POS ORDEM");
        System.out.println("####################");
        tree.posOrder();
        System.out.println("####################");

        System.out.println("####################");
        System.out.println("Busca em largura");
        System.out.println("####################");
        tree.BFS();
        System.out.println("####################");

    }
}
