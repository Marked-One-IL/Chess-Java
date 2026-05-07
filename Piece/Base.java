package Piece;

abstract class Base 
{
    enum Team 
    {
        BLACK,
        WHITE
    }
    enum Status
    {
        MOVE,
        KILL,
        ILLEGAL
    }

    final Piece.Base.Team team;

    public Base(Piece.Base.Team team)
    {
        this.team = team;
    }

    public static boolean doesFailBasicChecks(Utils.Position sourcePosition, Utils.Position destinationPosition, final Piece.Base[][] board)
    {
        // Checking if I move to the same place.
        if (sourcePosition.x == destinationPosition.x && sourcePosition.y == destinationPosition.y)
        {
            return true;
        }
        // Checking if I move an empty square. 
        if (board[sourcePosition.y][sourcePosition.x] == null)
        {
            return true;
        }
        // Checking if I commit friendly fire?
        if (board[destinationPosition.y][destinationPosition.x] != null && 
            board[sourcePosition.y][sourcePosition.x].team == board[destinationPosition.y][destinationPosition.x].team)
        {
            return true;
        }

        return false;
    }
    public abstract Piece.Base.Status canMove(Utils.Position sourcePosition, Utils.Position destinationPosition, final Piece.Base[][] board);
}