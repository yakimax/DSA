package floodfill_01;

public class FloodFill {
    
    public static boolean inRange(int i , int  j, int [][]arr){
        int n = arr.length;
        int m = arr[0].length;
        if( i < 0 || j < 0 || i >= n || j >= m)
        {
            return false;
        }
        return true;
    }

    public static boolean inRange( int i , int  j , int n , int m){
         if( i < 0 || j < 0 || i >= n || j >= m)
        {
            return false;
        }
        return true;
    }

    public static int floodfill_01 ( int sr , int sc , int dr , int dc ,boolean vis[][], int dir[][] , String dirN[] , String asf ) {
            if(sr == dr &&  sc == dc )
            {
                System.out.println(asf);
                return 1;
            }

            int count = 0 ;
            vis[sr][sc]=true;
            for(int d = 0 ; d < dir.length ; d++)
            {
                int row = sr + dir[d][0];
                int col = sc + dir[d][1];
                if(inRange(row,col,dr + 1 ,dc + 1 ) && !vis[row][col]) {
                    count += floodfill_01( row , col , dr , dc ,vis, dir , dirN , asf + dirN[d] );
                }
            }
            vis[sr][sc]=false;
            return count ;
        }

    public static void floodfill() {
        int n = 3 ;
        int m = 3 ;
        boolean [][] vis = new boolean [n] [m];
        String [] dirN = {"A","B","C","D","E","F","G","H"};
        int dir[][] ={{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        int ans  = floodfill_01(0,0,n-1,m-1,vis,dir,dirN,"");
        System.out.println(ans);
    }

    public static void main(String args[]) {
        floodfill();
    }
}
