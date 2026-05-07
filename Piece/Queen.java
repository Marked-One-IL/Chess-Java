package Piece;

class Queen extends Piece.Base
{
    public Queen(Piece.Base.Team team)
    {
        super(team);
    }

    public Piece.Base.Status canMove(Utils.Position sourcePosition, Utils.Position destinationPosition, final Piece.Base[][] board)
    {
        return Piece.Base.Status.ILLEGAL;
    }
}