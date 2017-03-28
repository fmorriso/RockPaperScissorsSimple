/*
This code is available online at:
https://github.com/fmorriso/RockPaperScissorsSimple/blob/master/src/RockPaperScissorsSimple.java
*/

import java.util.Scanner;

public class RockPaperScissorsSimple
{

    private static final Scanner ask = new Scanner(System.in);

    public static void main(String[] args)
    {
        boolean keepPlaying = true;
        int gamesPlayed = 0;

        while(keepPlaying)
        {
            playTheGameOneTime();
            gamesPlayed++;
            keepPlaying = askToPlayAgain();
        }

        System.out.format("Game was played %d times%n", gamesPlayed);
    }

    private static void playTheGameOneTime()
    {
        // logic to play the game one time goes here
    }

    private static boolean askToPlayAgain()
    {
        System.out.print("Do you want to play again (y/n)? (default is y)>");
        String response = ask.nextLine();
        // if we got any kind of response and it begins with N or n,
        // interpret that to mean the user does not wish to play again.
        if (response.length() > 0 && response.toLowerCase().charAt(0) == 'n')
        {
            return false;
        }

        return true;
    }
}
