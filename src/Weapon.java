// The set of allowable weapon choices.
// Includes:
// 1. the ability to get the weapon choice based on a single letter
// that corresponds to the first letter of the choice (case-insensitive).
// 2. the ability to get the full weapon name from the underlying integer
public class Weapon
{
    public static final int Rock = 1;
    public static final int Paper = 2;
    public static final int Scissors = 3;

    public static final int TotalAvailableWeaponChoices = 3;

    public static final String PromptForChoice = "(R)ock, (P)aper, or (S)cissors?";

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

}
