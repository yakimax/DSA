package MorrisTraversal;
import java.util.*;
public class morrisTraversal { 
    public static class Node{
        int data ;
        Node left ;
        Node right;
        Node (){}
        Node (int data , Node left , Node right){
            this.data = data ;
            this.left = left ;
            this.right = right ;
        }
        Node (int data){
            this.data = data ; 
        }
    }


    public static class Pair { 
        Node node ;
        int state ;
        Pair(){}
        Pair( Node node, int state ) {
             this.node = node ;
             this.state = state ;
        }
    }


    public static Node TreeConstruct(Integer arr[]){ 
        Stack <Pair> st = new Stack<> () ;
        int i = 0 ;
        Node node = new Node(arr[i]) ;
        Pair fn = new Pair( node , 1 ) ;
        st.push(fn) ;
        while( st.size() > 0 ){
            Pair top = st.peek() ;
            if(top.state == 1) {
                i++ ;
                top.state++ ;
                if(arr[i] != null){
                    Node left = new Node (arr[i]) ;
                    top.node.left = left ;
                    Pair leftPair = new Pair(left,1) ;
                    st.push(leftPair) ;
                }
            }
            else if(top.state == 2){ 
                i++ ;
                top.state++ ;
                if(arr[i] != null){
                    Node right = new Node (arr[i]) ;
                    top.node.right = right ;
                    Pair rightPair = new Pair(right,1) ;
                    st.push(rightPair) ;
                }
            }
            else 
            {
                st.pop();
            }
        }
        return node;
    } 

    public static void display(Node node){
        if(node == null){
            return ;
        }
        String s = "";
        s+= node.left == null ? "." : node.left.data;
        s+= "<-" + node.data + "->";
        s+= node.right == null ? "." : node.right.data;
        System.out.println(s);
        display(node.left) ;
        display(node.right) ;
    }

    public static void morristraversal(Node node){
        Node curr = node ;
        while( curr != null){
            if(curr.left == null){
                System.out.print(curr.data + " ");
                curr = curr.right ;
            }
            else
            {
                Node iop = curr.left ;
                while(iop.right != null && iop.right != curr){
                    iop = iop.right;
                }
                if(iop.right == null){
                    iop.right = curr ;
                    curr = curr.left;
                }
                else{
                    iop.right = null ;
                    System.out.print(curr.data + " "); 
                    curr = curr.right; 
                }
            }
        }
        System.out.println( );
    }

    public static void main(String args[]){
        Integer arr[] = {50,3,8,null,null,2,81,null,null,null,9,63,null,61,21,null,null,null,null};
        Node root = TreeConstruct(arr);
        morristraversal(root);
        display(root);

    }
}