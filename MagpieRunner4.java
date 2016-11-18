import java.util.Scanner;
import java.math.*;
import java.security.*;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner4
{

    /**
     * Create a Magpie, give it user input, and print its replies.
     */
    public static void main(String[] args)
    {
        Magpie4 maggie = new Magpie4();
        Encryption encrypt = new Encryption();

        Scanner in = new Scanner (System.in);
        System.out.println("Please enter given password: ");
        String pass = in.nextLine();
        int key = 0;
        try{
            key = Integer.parseInt(pass);
        }
        catch(java.lang.NumberFormatException e)
        {
            System.out.println("Incorrect password! Exiting...");
            System.exit(0);
        }

        if(encrypt.encrypt(key) == false){
            System.out.println("Incorrect password! Exiting...");
            System.exit(0);
        }

        System.out.println (maggie.getGreeting());
        String statement = in.nextLine();
        while (!statement.toLowerCase().equals("bye"))
        {
            System.out.println (maggie.getResponse(statement));
            statement = in.nextLine();
        }
        System.out.println("Goodbye! Please exit the chatbot now. ");
    }

}
