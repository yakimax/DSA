package binarytreeconstructor; 
import java.util.*;

public class BinaryTreeConstructor {
    
    public static class Node{
        Node left;
        Node right;
        int data;
        Node (){}
        Node (int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
        Node (int data){
            this.data = data;
        }
    }

    public static class  Pair {
        Node node;
        int state;
        Pair(){}
        Pair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }


    public static int sum (Node node){
        if(node == null){
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

        int ts = ls + rs ;

        return ts + 1 ;
    }

    public static int height(Node node){
        if(node == null){
            return 0; 
        }

        int lh = height(node.left);
        int rh = height(node.right);
        
        int th = Math.max(lh,rh );

        return th + 1;
    }

    public static int max(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }

        int lm = max(node.left);
        int rm = max(node.right);

        int max = Math.max(node.data ,Math.max(lm,rm));

        return max;
    }

    public static void LevelOrder(Node node){
        Queue <Node> que = new LinkedList<>();
        que.add(node);
        while(que.size()>0){
            int count = que.size();
            for(int i = 0; i< count; i++)
            {
                node = que.remove();
                System.out.print(node.data + " "); 
                if(node.left != null)
                {
                    que.add(node.left);
                }
                
                if(node.right != null)
                {
                    que.add(node.right);
                }
            }
            System.out.println( ); 
        }
    }


    public static Node treeConstructor (Integer arr[]){
        Node node = new Node(arr[0]);
        int idx = 0;
        Pair firstPair = new Pair(node , 1);
        Stack <Pair> st = new Stack<>();
        st.push(firstPair);
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state == 1){
                idx++;
                top.state++;
                if(arr[idx] != null){ 
                    Node left = new Node(arr[idx]);
                    top.node.left = left;
                    Pair leftPair = new Pair(left,1);
                    st.push(leftPair);
                }
                
            }
            else if(top.state == 2)
            {
                idx++;
                top.state++;
                if(arr[idx] != null){ 
                    Node right = new Node(arr[idx]);
                    top.node.right = right;
                    Pair rightPair = new Pair(right,1);
                    st.push(rightPair);
                } 
            }
            else{
                st.pop();
            }
        }
        return node;
    }

    public static void display (Node node){
        if(node == null){ 
             return;
        }
        String s = "";
        s+= node.left == null ? "." : node.left.data;
        s+= "<-" + node.data + "->";
        s+= node.right == null ? "." : node.right.data;
        System.out.println(s);

        display(node.left);
        display(node.right);

    }

    public static void main (String args []){
        Integer arr[] = {50,3,8,null,null,2,81,null,null,null,9,63,null,61,21,null,null,null,null};
        Node root = treeConstructor(arr);
        display(root);
        System.out.println(sum(root)); 
        System.out.println(size(root));
        System.out.println(height(root));
        System.out.println(max(root));
        LevelOrder(root) ;

        
    }
}
