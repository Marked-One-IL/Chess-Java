package Piece;

class Rook extends Piece.Base
{
    public Rook(Piece.Base.Team team)
    {
        super(team);
    }

    public Piece.Base.Status canMove(Utils.Position sourcePosition, Utils.Position destinationPosition, Piece.Base[][] board)
    {
        if (Piece.Base.doesFailBasicChecks(sourcePosition, destinationPosition, board))
        {
            return Piece.Base.Status.ILLEGAL;
        }

        // If the source piece moves up/down (Vertically).
        if (sourcePosition.x == destinationPosition.x)
        {
            int yStep = (destinationPosition.y > sourcePosition.y) ? 1 : -1;
            for (int y = sourcePosition.y + yStep; y < destinationPosition.y; y += yStep)
            {
                if (board[y][sourcePosition.x] != null)
                {
                    return Piece.Base.Status.ILLEGAL;
                }
            }
        }
        // If the source piece moves left/right (Horizontally).
        else if (sourcePosition.y == destinationPosition.y)
        {
            int xStep = (destinationPosition.x > sourcePosition.x) ? 1 : -1;
            for (int x = sourcePosition.x + xStep; x < destinationPosition.x; x += xStep)
            {
                if (board[sourcePosition.y][x] != null)
                {
                    return Piece.Base.Status.ILLEGAL;
                }
            }
        }
        else // If the direction isn't straight.
        {
            return Piece.Base.Status.ILLEGAL;
        }

        return Piece.Base.getMoveOrKillStatus(destinationPosition, board);
    }
}