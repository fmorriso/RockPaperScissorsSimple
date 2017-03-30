// The set of allowable hand choices.
// Includes the ability to get the hand choice based on a single letter
// that corresponds to the first letter of the choice (case-insensitive).
public enum HandChoice
{
    Rock,
    Paper,
    Scissors;

    private static final String RockFirst = Rock.name().substring(0, 1);
    private static final String PaperFirst = Paper.name().substring(0, 1);
    private static final String ScissorsFirst = Scissors.name().substring(0, 1);

    // returns the enum based on just the first character of the input value
    public static HandChoice getEnumFromFirstLetter(String fullChoice)
    {
        if(fullChoice.length() > 0)
        {
            String firstLetter = fullChoice.substring(0, 1);

            if(RockFirst.equalsIgnoreCase(firstLetter))
                return Rock;
            else if(PaperFirst.equalsIgnoreCase(firstLetter))
                return Paper;
            else if(ScissorsFirst.equalsIgnoreCase(firstLetter))
                return Scissors;
            else
            {
                System.out.println("The first letter of the choice does not match any of the enum names - try again");
                return null;
            }

        }

        System.out.println("Empty choice encountered - please try again");
        return null;
    }
}
