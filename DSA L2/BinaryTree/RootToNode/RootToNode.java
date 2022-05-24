package RootToNode; 
import java.util.*;

public class RootToNode {
    
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
 

    public static boolean RootToNode(Node node,int data, ArrayList<Integer>al){
        if(node == null){
            return false;
        }
        boolean a = RootToNode(node.left,data,al); 
        boolean b = RootToNode(node.right,data,al);
 
        if(a || b){
            al.add(node.data);
        }
        if(node.data == data){
            al.add(node.data);
            return true;
        } 
        return a||b;
    }


    public static void main (String args []){
        Integer arr[] = {50,3,8,null,null,2,81,null,null,null,9,63,null,61,21,null,null,null,null};
        Node root = treeConstructor(arr); 
        ArrayList<Integer> al = new ArrayList<>();
        RootToNode(root,21,al);
        Collections.reverse(al);
        System.out.println(al); 
    }
}
