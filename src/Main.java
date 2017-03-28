import java.util.Scanner;

public class Main {

    private static final Scanner ask = new Scanner(System.in);

    public static void main(String[] args)
    {
        boolean keepPlaying = true;
        int gamesPlayed = 0;

        while(keepPlaying)
        {
            playTheGame();
            gamesPlayed++;
            keepPlaying = askToPlayAgain();
        }

        System.out.format("Game was played %d times%n", gamesPlayed);
    }

    private static void playTheGame()
    {
        // logic to play one round of the game goes here
    }

    private static boolean askToPlayAgain()
    {
        System.out.print("Do you want to pay again (y/n)? (default is y)>");
        String response = ask.nextLine();
        if (response.length() > 0 && response.toLowerCase().charAt(0) == 'n')
        {
            return false;
        }

        return true;
    }
}
