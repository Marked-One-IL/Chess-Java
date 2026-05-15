package Piece;

class Knight extends Piece.Base
{
    public Knight(Piece.Base.Team team)
    {
        super(team);
    }

    public Piece.Base.Status canMove(Utils.Position sourcePosition, Utils.Position destinationPosition, final Piece.Base[][] board)
    {
        if (Piece.Base.doesFailBasicChecks(sourcePosition, destinationPosition, board))
        {
            return Piece.Base.Status.ILLEGAL;
        }

        // Checks for up/down (Vertically) movement.
        if (Math.abs(sourcePosition.x - destinationPosition.x) != 1 || Math.abs(sourcePosition.y - destinationPosition.y) != 2)
        {
            // Checks for left/right (Horizontally). movement.
            if (Math.abs(sourcePosition.y - destinationPosition.y) != 1 || Math.abs(sourcePosition.x - destinationPosition.x) != 2)
            {
                return Piece.Base.Status.ILLEGAL;
            }
        }

        return Piece.Base.getMoveOrKillStatus(destinationPosition, board);
    }
}