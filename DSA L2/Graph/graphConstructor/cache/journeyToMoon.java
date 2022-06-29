import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */

    public static int journeyToMoon(int n, List<List<Integer>> astronaut) { 

        ArrayList < ArrayList <Integer> >  arr = new ArrayList<>() ;
        boolean vis[] = new boolean[n] ;
            for(int i = 0 ; i < n  ; i++ ) {
                 if( !vis [i] == false ){ 
                        ArrayList < Integer > al = new ArrayList<>();
                        dfs(al,astronaut,vis,i);
                        arr.add(al);
                   }
            }  
    }

    public static void dfs( ArrayList < Integer > al , List<List<Integer>> astronaut , boolean vis[] , int i){
         if(vis[i]==true ){
            return ;
         }
        vis[i] = true ;
        al.add(i) ;
        for(Integer as : astronaut.get(i)) {
            if( vis[as] == false ) {
                dfS (al,astronaut,vis,as) ;
            }
        }
        return ;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
