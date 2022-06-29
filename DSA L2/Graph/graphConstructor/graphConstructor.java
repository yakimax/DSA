import java.util.*;
public class graphConstructor {
    
    public static class Edge{
        int src ;
        int nbr ;
        int wt ;
        Edge (){}
        Edge(int src, int nbr,int wt){
            this.src = src ;
            this.nbr = nbr ;
            this.wt = wt ;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph , int src, int nbr, int wt) {
        graph[src].add(new Edge(src,nbr,wt)) ;
        graph[nbr].add(new Edge(nbr,src,wt)) ;
    }

    public static void displayGraph(ArrayList<Edge>[] graph ,int N) {
        for(int i = 0 ; i < N ; i++) {
            System.out.print(i + "------") ;
            for(Edge e : graph[i] ) {
                System.out.println(e.src + "-" + e.nbr + "weight->" + e.wt + ".") ;
            }
            System.out.println();
        }
    }

    public static void graphConstructor() {
        int N = 7 ;
        ArrayList<Edge>[] graph = new ArrayList[N] ;
        for(int i = 0 ; i < N ; i++) {
            graph[i] = new ArrayList<>() ;
        }
        addEdge(graph,0,1,20) ;
        addEdge(graph,0,3,10) ;
        addEdge(graph,1,2,10) ;
        addEdge(graph,2,3,40) ;
        addEdge(graph,3,4,2) ;
        addEdge(graph,4,5,2) ; 
        addEdge(graph,5,6,3) ;
        addEdge(graph,4,3,8) ;

        displayGraph( graph ,N) ;
    } 

    public static void main(String args[]){
        graphConstructor();
    }
}
