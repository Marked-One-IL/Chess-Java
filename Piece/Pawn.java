package Piece;

class Pawn extends Piece.Base
{
    private boolean didMove = false;

    public Pawn(Piece.Base.Team team)
    {
        super(team);
    }

    public void setMoveStatus()
    {
        this.didMove = true;
    }
    public Piece.Base.Status canMove(Utils.Position sourcePosition, Utils.Position destinationPosition, Piece.Base[][] board)
    {
        if (Piece.Base.doesFailBasicChecks(sourcePosition, destinationPosition, board))
        {
            return Piece.Base.Status.ILLEGAL;
        }

        Piece.Base.Status moveStatus = Piece.Base.getMoveOrKillStatus(destinationPosition, board);

        if (moveStatus == Piece.Base.Status.MOVE)
        {
            if (sourcePosition.x == destinationPosition.x) // Checks if the movment goes left/right (Vertically)
            {
                return Piece.Base.Status.ILLEGAL;
            }
            if (board[sourcePosition.y][sourcePosition.x].team == Piece.Base.Team.BLACK)
            {
                if (sourcePosition.y - destinationPosition.y == 2 && !didMove) // If first move allow 2 steps.
                {
                    if (board[sourcePosition.y + 1][sourcePosition.x] != null) // Checks if the pawn skips a piece.
                    {
                        return Piece.Base.Status.ILLEGAL;
                    }
                    return moveStatus;
                }
                if (sourcePosition.y - destinationPosition.y != 1) // Checks if the movement is 1 step.
                {
                    return Piece.Base.Status.ILLEGAL;
                }
            }
            else // if (board[sourcePosition.y][sourcePosition.x].team == Piece.Base.Team.WHITE)
            {
                if (sourcePosition.y - destinationPosition.y == 2 && !didMove) // If first move allow 2 steps.
                {
                    if (board[sourcePosition.y - 1][sourcePosition.x] != null) // Checks if the pawn skips a piece.
                    {
                        return Piece.Base.Status.ILLEGAL;
                    }
                    return moveStatus;
                }
                if (destinationPosition.y - sourcePosition.y != 1) // Checks if the movement is 1 step.
                {
                    return Piece.Base.Status.ILLEGAL;
                }
            }
            
            return moveStatus;
        }
        else if (moveStatus == Piece.Base.Status.KILL)
        {
            if (Math.abs(sourcePosition.x - destinationPosition.x) != 1)  // Checks if the movment doesn't goes left/right (Vertically) by 1 step.
            {
                return Piece.Base.Status.ILLEGAL;
            }
            if (board[sourcePosition.y][sourcePosition.x].team == Piece.Base.Team.BLACK)
            {
                if (sourcePosition.y - destinationPosition.y != 1)
                {
                    return Piece.Base.Status.ILLEGAL;
                }
            }
            else // if (board[sourcePosition.y][sourcePosition.x].team == Piece.Base.Team.WHITE)
            {
                if (destinationPosition.y - sourcePosition.y != 1)
                {
                    return Piece.Base.Status.ILLEGAL;
                }
            }
        }

        return Piece.Base.Status.ILLEGAL;
    }
}