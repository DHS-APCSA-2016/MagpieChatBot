
import java.util.Scanner;
import java.lang.Math;

class DiganosticFRQ {
    
    public static int max2D(int arry[][]){
        int maxValue = 0;
        for(int i = 0; i < arry.length; i++){
            for(int j = 0; j < arry.length; j++){
                if(arry[i][j] > maxValue){
                    maxValue = arry[i][j];
                }
            }
            
        }
        return maxValue;
    }
}
