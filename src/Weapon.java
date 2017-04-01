import java.util.Scanner;

// The set of allowable weapon choices.
// Includes:
// * Get a randomly selected weapon.
// * The ability to prompt for a weapon that can be chosen using
//   just the first letter of the weapon name.
// * The ability to get the full weapon name from the underlying integer.
// * Compare two weapons to see which one wins.

public class Weapon
{
    public static final int Rock = 1;
    public static final int Paper = 2;
    public static final int Scissors = 3;

    private static final int TotalAvailableWeaponChoices = 3;

    private static final Scanner ask = new Scanner(System.in);
    private static final String PromptForChoice = "(R)ock, (P)aper, or (S)cissors?";

    // Returns the name that corresponds to the specified integer choice
    // or unknown if the input value does not correspond to a known weapon.
    public static String getWeaponName(int choice)
    {
        String nameOfChoice = "unknown";

        switch(choice)
        {
            case Rock:
                nameOfChoice = "Rock";
                break;

            case Paper:
                nameOfChoice = "Paper";
                break;

            case Scissors:
                nameOfChoice = "Scissors";
                break;
        }

        return nameOfChoice;
    }

    // returns the integer choice based on the first letter of the input String.
    // If the value of the integer is out of range, we return zero.
    public static int getChoiceFromFirstLetter(String fullChoice)
    {
        int choice = 0;
        if(fullChoice.length() > 0)
        {
            String firstLetter = fullChoice.substring(0, 1).toLowerCase();
            switch (firstLetter)
            {
                case "r":
                    return Rock;

                case "p":
                    return Paper;

                case "s":
                    return Scissors;

            }
        }

        return choice;
    }

    public static int getRandomWeapon()
    {
        int i = (int)(Math.random() * TotalAvailableWeaponChoices) + 1;
        return i;
    }

    public static int askWhichWeapon()
    {
        int hc = 0;

        // keep asking player for a choice until we get a valid one
        while(hc <= 0)
        {
            System.out.println(PromptForChoice);
            String response = ask.nextLine();
            hc = getChoiceFromFirstLetter(response);
        }
        return hc;
    }

    public static GameOutcome CompareChoices(int computerChoice, int playerChoice)
    {
        switch(computerChoice)
        {

            case Rock:

                switch(playerChoice)
                {
                    case Rock:
                        return GameOutcome.Tie;

                    case Paper:
                        System.out.println("Paper covers rock");
                        return GameOutcome.PlayerWins;

                    case Scissors:
                        System.out.println("Rock smashes scissors");
                        return GameOutcome.ComputerWins;
                }
                break;

            case Paper:

                switch(playerChoice)
                {
                    case Rock:
                        System.out.println("Paper covers rock");
                        return GameOutcome.ComputerWins;

                    case Paper:
                        return GameOutcome.Tie;

                    case Scissors:
                        System.out.println("Scissors cut paper");
                        return GameOutcome.PlayerWins;
                }
                break;

            case Scissors:

                switch(playerChoice)
                {
                    case Rock:
                        System.out.println("Rock smashes scissors");
                        return GameOutcome.PlayerWins;

                    case Paper:
                        System.out.println("Scissors cut paper");
                        return GameOutcome.ComputerWins;

                    case Scissors:
                        return GameOutcome.Tie;

                }
                break;
        }
        return GameOutcome.Tie;
    }

}
