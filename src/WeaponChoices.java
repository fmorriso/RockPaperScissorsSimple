// The set of allowable hand choices.
// Includes the ability to get the hand choice based on a single letter
// that corresponds to the first letter of the choice (case-insensitive).
public class WeaponChoices
{
    public static final int Rock = 1;
    public static final int Paper = 2;
    public static final int Scissors = 3;

    public static final int TotalAvailableWeaponChoices = 3;

    // Returns the name that corresponds to the specified integer choice
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
    public static int getWeaponChoiceFromFirstLetter(String fullChoice)
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
