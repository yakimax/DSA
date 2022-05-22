package mazepath_02;

public class MazePath {
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

    public static int mazepath_02 ( int sr , int sc , int dr , int dc , int dir[][] , String dirN[] , String asf ) {
            if(sr == dr &&  sc == dc )
            {
                System.out.println(asf);
                return 1;
            }

            int count = 0 ;
            for(int d = 0 ; d < dir.length ; d++)
            {
                for(int jump = 1; jump <= Math.max(dr,dc) ; jump++)
                { 
                    int row = sr + (dir[d][0] * jump);
                    int col = sc + (dir[d][1] * jump);
                    if(inRange(row,col,dr + 1 ,dc + 1 )) {
                        count += mazepath_02( row , col , dr , dc , dir , dirN , asf + dirN[d] + jump);
                    }
                }
            }
            return count ;
        }

    public static void mazepath () {
        int n = 3 ;
        int m = 3 ;
        String [] dirN = {"H","V","D"};
        int dir[][] ={{0,1},{1,0},{1,1}}; 
        int ans  = mazepath_02(0,0,n-1,m-1,dir,dirN,""); 
        System.out.println(ans);
    }

    public static void main(String args[]) {
        mazepath();
    }
}
