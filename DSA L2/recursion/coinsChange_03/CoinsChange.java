package coinsChange_03;

public class CoinsChange {
    public static int coinChange(int coins[],int tar, String asf){
        if(tar == 0)
        {
            System.out.println(asf);
            return 1; 
        }
        int count = 0 ;
        for( int i = 0 ; i < coins.length ; i++ )
        {
            if(coins[i] > 0 && tar-coins[i]>=0){
                int val = coins[i];
                coins[i] = -coins[i];
                count += coinChange(coins,tar-val ,asf + coins[i]);
                coins[i] = -coins[i];
            }            
        }
        return count;
    } 
    public static void main(String [] args){
        int [] coins = {1,2,5};
        int tar = 11;
        int ans = coinChange(coins, tar , "");
        System.out.println("Count is -> " + ans);
    }
}
