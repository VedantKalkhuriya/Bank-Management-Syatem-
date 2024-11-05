import java.util.Scanner;
import java.util.Random;;
public class gussno {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        String play = "yes";

        while (play.equals("yes")){
            Random rand = new Random();
            int randnum= rand.nextInt(100);
            int guess =-1;
            int tries=0; 
            while (guess != randnum){
                System.out.println("Guess the number ");
                guess= reader.nextInt();
                tries++;
                if (guess == randnum){
                    System.out.println("Awesome you guess the number correctly\n");
                    System.out.println("You took "+tries + " to guess the number\n");
                    System.out.println("Do you want to play the game again ");
                    play = reader.next().toLowerCase(); 


                }
                else if( guess > randnum){
                    System.err.println("you are thinking to high ");
                }
                else{
                    System.out.println("you are thinking too low ");
                }

            


            }
            

        }

       
    reader.close();
    }
    
}
