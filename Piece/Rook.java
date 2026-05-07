package Piece;

class Rook extends Piece.Base
{
    public Rook(Piece.Base.Team team)
    {
        super(team);
    }

    public Piece.Base.Status canMove(Utils.Position sourcePosition, Utils.Position destinationPosition, final Piece.Base[][] board)
    {
        return Piece.Base.Status.ILLEGAL;
    }
}