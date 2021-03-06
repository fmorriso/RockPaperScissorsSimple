import java.util.Scanner;

public class RockPaperScissorsSimple
{
   private static final Scanner ask = new Scanner(System.in);
   private static int playerScore = 0;
   private static int computerScore = 0;
   private static final int winningScore = 2;
   private static int attemptsToDetermineWinner = 0;
   private static int gamesWonByPlayer = 0;
   private static int gamesWonByComputer = 0;

   public static void main( String[] args )
   {
      boolean continuePlaying = true;
      boolean haveWinner = false;
   
      while(continuePlaying)
      {
         haveWinner = playTheGame();
         if(haveWinner)
         {
            System.out.format("It took %d attempts to determine a winner. %n", attemptsToDetermineWinner);
            resetGame();
            continuePlaying = askToPlayAgain();
         }
      }
      
      displayFinalResults();
      
   }
   
   // Display final results, including how many games
   // the player won and how many times the computer won.
   private static void displayFinalResults()
   {
      String timesPlayerMessage = gamesWonByPlayer == 1 ? "time" : "times";
      String timesComputerMessage = gamesWonByComputer == 1 ? "time" : "times";
      System.out.format("Player won %d %s, computer won %d %s.%n", 
                        gamesWonByPlayer, timesPlayerMessage, gamesWonByComputer, timesComputerMessage);
   }

   // reset the game so we can play again
   private static void resetGame()
   {
      playerScore = 0;
      computerScore = 0;
      attemptsToDetermineWinner = 0;
   }

   // logic to play one round of the game.
   // Returns true if there was a winner
   private static boolean playTheGame()
   {
      attemptsToDetermineWinner++;
      int computerChoice = Weapon.getRandomWeapon();
      int playerChoice = Weapon.askWhichWeapon();
      System.out.format("Player chose %s, Computer chose %s %n", Weapon.getWeaponName(playerChoice), Weapon.getWeaponName(computerChoice) );
   
      GameOutcome outcome = Weapon.CompareChoices(computerChoice, playerChoice);
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
         gamesWonByPlayer++;
         return true;
      }
   
      if(computerScore == winningScore)
      {
         System.out.println("Computer is the game winner");
         gamesWonByComputer++;
         return true;
      }
   
      return false;
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
