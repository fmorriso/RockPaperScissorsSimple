import java.util.Scanner;

public class RockPaperScissorsSimple
{
    private static final Scanner ask = new Scanner(System.in);
    private static int playerScore = 0;
    private static int computerScore = 0;
    private static final int winningScore = 2;
    private static int gamesPlayed = 0;

    public static void main( String[] args )
    {
        boolean continuePlaying = true;
        boolean haveWinner = false;

        while(continuePlaying)
        {
            haveWinner = playTheGame();
            gamesPlayed++;
            if(haveWinner)
            {
                System.out.format("It took %d tries to determine a winner %n", gamesPlayed);
                resetGame();
                continuePlaying = askToPlayAgain();
            }
        }
    }

    // reset the game so we can play again
    private static void resetGame()
    {
        playerScore = 0;
        computerScore = 0;
        gamesPlayed = 0;
    }

    // logic to play one round of the game.
    // Returns true if there was a winner
    private static boolean playTheGame()
    {
        int computerChoice = getComputerChoice();
        int playerChoice = getPlayerChoice();
        System.out.format("Player chose %s, Computer chose %s %n", Weapons.getWeaponName(playerChoice), Weapons.getWeaponName(computerChoice) );

        GameOutcome outcome = CompareChoices(computerChoice, playerChoice);
        switch(outcome)
        {
            case PlayerWins:
                System.out.println("Player wins a point");
                playerScore++;
                break;

            case ComputerWins:
                System.out.println("Computer wins a point");
                computerScore++;
                break;

            case Tie:
                System.out.println("Another sister-kissing tie!!");
                break;
        }

        System.out.format("Score: Player: %d, Computer: %d %n", playerScore, computerScore);

        if(playerScore == winningScore)
        {
            System.out.println("Player is the game winner");
            return true;
        }

        if(computerScore == winningScore)
        {
            System.out.println("Computer is the game winner");
            return true;
        }

        return false;
    }

    // Compare the computer's choice to the player's choice and return an outcome.
    private static GameOutcome CompareChoices(int computerChoice, int playerChoice)
    {
        switch(computerChoice){

            case Weapons.Rock:

                switch(playerChoice)
                {
                    case Weapons.Rock:
                        return GameOutcome.Tie;

                    case Weapons.Paper:
                        System.out.println("Paper covers rock");
                        return GameOutcome.PlayerWins;

                    case Weapons.Scissors:
                        System.out.println("Rock smashes scissors");
                        return GameOutcome.ComputerWins;
                }
                break;

            case Weapons.Paper:

                switch(playerChoice)
                {
                    case Weapons.Rock:
                        System.out.println("Paper covers rock");
                        return GameOutcome.ComputerWins;

                    case Weapons.Paper:
                        return GameOutcome.Tie;

                    case Weapons.Scissors:
                        System.out.println("Scissors cut paper");
                        return GameOutcome.PlayerWins;
                }
                break;

            case Weapons.Scissors:

                switch(playerChoice)
                {
                    case Weapons.Rock:
                        System.out.println("Rock smashes scissors");
                        return GameOutcome.PlayerWins;

                    case Weapons.Paper:
                        System.out.println("Scissors cut paper");
                        return GameOutcome.ComputerWins;

                    case Weapons.Scissors:
                        return GameOutcome.Tie;

                }
                break;
        }
        return GameOutcome.Tie;
    }

    private static int getComputerChoice()
    {
        int i = (int)(Math.random() * Weapons.TotalAvailableWeaponChoices) + 1;
        return i;
    }

    // ask the player to make a choice
    private static int getPlayerChoice()
    {
        int hc = 0;

        // keep asking player for a choice until we get a valid one
        while(hc <= 0)
        {
            System.out.println(Weapons.PromptForChoice);
            String response = ask.nextLine();
            hc = Weapons.getChoiceFromFirstLetter(response);
        }
        return hc;
    }

    private static boolean askToPlayAgain()
    {
        System.out.println("Do you want to play again (y/n)? (default is y)");
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
