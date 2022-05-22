package uniquepathobstacle;

public class UniquePathObstacle {
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

    public static int uniquePath ( int sr , int sc , int dr , int dc ,int dir[][], int grid[][] ) {
            if(sr == dr &&  sc == dc )
            { 
                return 1;
            }

            int count = 0 ;
            for(int d = 0 ; d < dir.length ; d++)
            {
                int row = sr + dir[d][0];
                int col = sc + dir[d][1];
                if(inRange(row,col,dr + 1 ,dc + 1 ) && grid[row][col] == 0) {
                    count += uniquePath( row , col , dr , dc , dir ,grid);
                }
            }
            return count ;
        }

    public static int mazepath (int n, int m,int grid[][]) {
       
        int dir[][] ={{0,1},{1,0} };
        int ans  = uniquePath(0,0,n-1,m-1,dir,grid ); 
        return ans;
    }
    
    public static int uniquePathsObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1 )
        {
            return 0;
        }
        return mazepath(n,m,grid);
    }

    public static void main (String args[]){
        int grid[][] = {{0,0,1,0,0,1},{1,0,0,0,0,1},{0,0,1,0,0,1},{1,1,1,1,0,1},{0,0,0,1,0,1},{0,0,1,0,0,0}};
        System.out.println(uniquePathsObstacles(grid));
    }
}
