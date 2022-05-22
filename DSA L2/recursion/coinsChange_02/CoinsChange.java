package coinsChange_02;

public class CoinsChange {
     
    public static int coinChange(int coins[],int tar,int idx,String asf){
        if(tar == 0)
        {
            System.out.println(asf);
            return 1; 
        }
        int count = 0 ;
        for( int i = idx ; i < coins.length ; i++ )
        {
            if(tar-coins[i]>=0){
                count += coinChange(coins,tar-coins[i],i,asf + coins[i]);
            }            
        }
        return count;
    } 
    public static void main(String [] args){
        int [] coins = {1,2,5};
        int tar = 11;
        int ans = coinChange(coins, tar,0, "");
        System.out.println("Count is -> " + ans);
    }
}
