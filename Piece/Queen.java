package Piece;

class Queen extends Piece.Base
{
    public Queen(Piece.Base.Team team)
    {
        super(team);
    }

    public Piece.Base.Status canMove(Utils.Position sourcePosition, Utils.Position destinationPosition, final Piece.Base[][] board)
    {
        if (Piece.Base.doesFailBasicChecks(sourcePosition, destinationPosition, board))
        {
            return Piece.Base.Status.ILLEGAL;
        }

        Piece.Bishop bishop = new Piece.Bishop(board[sourcePosition.y][sourcePosition.x].team);
        Piece.Rook rook = new Piece.Rook(board[sourcePosition.y][sourcePosition.x].team);

        // Reusing the logic of Bishop and Rook and seeing which one works.
        Piece.Base.Status bishopStatus = bishop.canMove(sourcePosition, destinationPosition, board);
        if (bishopStatus != Piece.Base.Status.ILLEGAL)
        {
            return bishopStatus;
        }
        return rook.canMove(sourcePosition, destinationPosition, board);
    }
}