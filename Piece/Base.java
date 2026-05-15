package Piece;

// The nights are getting darker and darker.

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

    public static boolean doesFailBasicChecks(Utils.Position sourcePosition, Utils.Position destinationPosition, Piece.Base[][] board)
    {
        // Checking if the piece move to the same place.
        if (sourcePosition.x == destinationPosition.x && sourcePosition.y == destinationPosition.y)
        {
            return true;
        }
        // Checking if the piece move to an empty place. 
        if (board[sourcePosition.y][sourcePosition.x] == null)
        {
            return true;
        }
        // Checking if the piece commit friendly fire?
        if (board[destinationPosition.y][destinationPosition.x] != null && 
            board[sourcePosition.y][sourcePosition.x].team == board[destinationPosition.y][destinationPosition.x].team)
        {
            return true;
        }

        return false;
    }
    public static Piece.Base.Status getMoveOrKillStatus(Utils.Position destinationPosition, Piece.Base[][] board)
    {
        return board[destinationPosition.y][destinationPosition.x] == null ? Piece.Base.Status.MOVE : Piece.Base.Status.KILL;
    }
    public abstract Piece.Base.Status canMove(Utils.Position sourcePosition, Utils.Position destinationPosition, Piece.Base[][] board);
}