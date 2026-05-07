package Piece;

class Bishop extends Piece.Base
{
    public Bishop(Piece.Base.Team team)
    {
        super(team);
    }

    public Piece.Base.Status canMove(Utils.Position sourcePosition, Utils.Position destinationPosition, final Piece.Base[][] board)
    {
        if (Piece.Base.doesFailBasicChecks(sourcePosition, destinationPosition, board))
        {
            return Piece.Base.Status.ILLEGAL;
        }
        // Checking if the movement is diagonal.
        if (Math.abs(destinationPosition.x - sourcePosition.x) != Math.abs(destinationPosition.y - sourcePosition.y))
        {
            return Piece.Base.Status.ILLEGAL;
        }

        // Checking if between source and destination there is an piece blocking.
        int xStep = (destinationPosition.x > sourcePosition.x) ? 1 : -1;
        int yStep = (destinationPosition.y > sourcePosition.y) ? 1 : -1;
        int x = sourcePosition.x + xStep;
        int y = sourcePosition.y + yStep;
        while (x != destinationPosition.x && y != destinationPosition.y)
        {
            if (board[y][x] != null)
            {
                return Piece.Base.Status.ILLEGAL;
            }

            x += xStep;
            y += yStep;
        }

        // Checking if it's a basic movement or a kill.
        return board[destinationPosition.y][destinationPosition.x] == null ? Piece.Base.Status.MOVE : Piece.Base.Status.KILL;
    }
}