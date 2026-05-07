package Piece;

class Pawn extends Piece.Base
{
    private boolean didMove = false;

    public Pawn(Piece.Base.Team team)
    {
        super(team);
    }

    public Piece.Base.Status canMove(Utils.Position sourcePosition, Utils.Position destinationPosition, final Piece.Base[][] board)
    {
        return Piece.Base.Status.ILLEGAL;
    }
}