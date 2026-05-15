package Utils;

public class Position 
{
    public final int x;
    public final int y;

    public Position(String movement) throws Exception
    {        
        if (movement.length() != 2 || !Character.isAlphabetic(movement.charAt(0)) || !Character.isDigit(movement.charAt(1)))
        {
            throw new Exception("Invalid movement syntax");
        }

        // Convert something like "d7d6" to a (3,6) based position.
        this.x = Character.toLowerCase(movement.charAt(0)) - 'a';
        this.y = Character.toLowerCase(movement.charAt(0)) - '1';

        int X_SIZE = 8;
        int Y_SIZE = 8;
        if ((x < 0 || x >= X_SIZE) || (y < 0 || y >= Y_SIZE))
        {
            throw new Exception("Invalid movement position");
        }
    }
}