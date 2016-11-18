import java.math.*;
/**
 * Write a description of class Encryption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Encryption
{
    public boolean encrypt(int key){
        if ((Math.pow((key % 127), 4) ==  78074896) && (key > 100000)){
            return true;
        }
            return false;
            }
        }

