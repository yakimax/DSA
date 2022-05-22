package BinaryTree.BinaryTreeConstructor;

import java.util.Stack;

public class BinaryTreeConstructor {
 
    public static class Node {
        int data; 
        Node left;
        Node right;
        Node (int data,Node left ,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }   
        Node(){}  
        Node (int data ){
            this.data = data;
        }  
    }
    public static class Pair {
        Node node;
        int state;

        Pair(Node node,int state){
            this.node = node;
            this.state = state;     
        }
        Pair(){}
        Pair(int state){
            this.state = state;
        }

    }

    public static  Node binaryTreeConstructor(Integer arr[] ){
        int idx = 1 ;
        Node root = new Node(arr[0]);
        Pair rootPair = new Pair(root,idx);
        Stack<Pair> st = new Stack <>();
        st.push(rootPair);

        while(st.size()>0){
            Pair top = st.peek();
            if(top.state == 1)
            {
                top.state++;
                if(arr[idx] != null)
                { 
                    Node leftchild = new Node(arr[idx]);
                    Pair lc = new Pair(leftchild ,1);
                    top.node.left = leftchild;
                    st.push (lc);
                }
                idx++;
            }
            else if(top.state == 2)
            {
                top.state++;
                if(arr[idx] != null)
                { 
                    Node rightchild = new Node(arr[idx]);
                    Pair rc = new Pair(rightchild ,1);
                    top.node.right = rightchild;
                    st.push (rc);
                }
                idx++;
            }
            else{
                st.pop();
            }
        }
         return root;
    }

    public static int sum (Node node ){
        if(node == null)
        {
            return 0;
        }
        int ls = sum(node.left);
        int rs = sum(node.right);

        int ts = ls + rs + node.data;
        return ts;
    }

    public static int size(Node node){
        if(node == null)
        {
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);

        int ts = ls + rs + 1;

        return ts;
    }


    public static int max (Node node){
        if(node==null){
            return Integer.MIN_VALUE;
        }
        int lm = max(node.left);
        int rm = max(node.right);

        int tm = Math.max(node.data,Math.max(lm,rm));
        return tm;
    }

    public static int height(Node node){
        if(node == null)
        {
            return -1;
        }
        int lh = height(node.left);
        int rh = height(node.right);

        int th = Math.max(lh,rh) + 1;
        return th;
    }

    public static void  display(Node node){
        if(node == null)
        {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data +"";
        str += "<-" + node.data +"->";
        str += node.right == null ? "." : node.right.data +""; 
        System.out.println(str);
        display(node.left);
        display(node.right);

    }

    public static  void main(String args[]){
         Integer arr[] = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null} ;
         Node root = binaryTreeConstructor(arr);
         display(root);
         System.out.println(max(root));
         System.out.println(size(root));
         System.out.println(height(root));
         System.out.println(sum(root));

    }
}