package Piece;

class Knight extends Piece.Base
{
    public Knight(Piece.Base.Team team)
    {
        super(team);
    }

    public Piece.Base.Status canMove(Utils.Position sourcePosition, Utils.Position destinationPosition, final Piece.Base[][] board)
    {
        return Piece.Base.Status.ILLEGAL;
    }
}