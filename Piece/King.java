package Piece;

class King extends Piece.Base
{
    public King(Piece.Base.Team team)
    {
        super(team);
    }

    public Piece.Base.Status canMove(Utils.Position sourcePosition, Utils.Position destinationPosition, final Piece.Base[][] board)
    {
        if (Piece.Base.doesFailBasicChecks(sourcePosition, destinationPosition, board))
        {
            return Piece.Base.Status.ILLEGAL;
        }

        // Checks if the x or y movement is beyond 1.
        if (Math.abs(sourcePosition.x - destinationPosition.x) > 1 ||
            Math.abs(sourcePosition.y - destinationPosition.y) > 1)
        {
            return Piece.Base.Status.ILLEGAL;
        }

        return Piece.Base.getMoveOrKillStatus(destinationPosition, board);
    }
}